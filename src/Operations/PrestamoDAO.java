package Operations;

import DB.DBConnection;
import Model.Prestamo;

import java.rmi.ServerError;
import java.sql.*;
import java.util.*;

public class PrestamoDAO {
    public static void agregarPers(Prestamo prs){ //esto me agrega la persona del metodo prestamo del videogameDAO
        String agregarP="INSERT INTO v_alquilados (id_videogame,persona_alq,fecha) VALUES (?,?,?)";
        try(Connection conn= DBConnection.getConnection(); PreparedStatement aP = conn.prepareStatement(agregarP)){
            aP.setInt(1,prs.getIdVideogame());
            aP.setString(2, prs.getPersonaAlq());
            aP.setTimestamp(3,prs.getFechaPrestamo());
            aP.executeUpdate();
        }
        catch(Exception e){
            System.err.println("Error:"+e.getMessage());;
        }
    }

    public static List<Prestamo> getByPers (String n){
        List<Prestamo> prsn = new ArrayList<>();
        String buscarP="SELECT * FROM v_alquilados WHERE persona_alq ILIKE ?";

        try(Connection conn = DBConnection.getConnection();PreparedStatement bp = conn.prepareStatement(buscarP)){
            bp.setString(1,"%"+n+"%");
            ResultSet rs= bp.executeQuery();
            while (rs.next()){
                Prestamo p = new Prestamo(rs.getInt("id"),rs.getString("persona_alq"), rs.getInt("id_videogame"));
                prsn.add(p);
            }
        }catch (SQLException e){
            System.err.println("Error:"+e.getMessage());
        }
        return prsn;
    }

    public static List<Prestamo> getAllPrestamos(){
        List<Prestamo> Lista = new ArrayList<>();
        String todos = "SELECT * FROM v_alquilados ORDER BY id ASC";

        try(Connection conn = DBConnection.getConnection();PreparedStatement tds = conn.prepareStatement(todos);ResultSet rs = tds.executeQuery()){
        while(rs.next()){
            Prestamo l = new Prestamo(rs.getInt("id"),rs.getString("persona_alq"),rs.getTimestamp("fecha"),rs.getInt("id_videogame"));
            Lista.add(l);
        }
        }
        catch (SQLException e){
            System.err.println("Error: "+e.getMessage());
        }
        return Lista;
    }

    public static void getById(int d){
        Prestamo ñ=null;
        String porId="SELECT * FROM v_alquilados WHERE id=?";

        try(Connection conn = DBConnection.getConnection();PreparedStatement pi = conn.prepareStatement(porId)){
            pi.setInt(1,d);
            ResultSet rs = pi.executeQuery();
            if (rs.next()){
                Prestamo p= new Prestamo(rs.getInt("id"),rs.getString("persona_alq"),rs.getTimestamp("fecha"),rs.getInt("id_videogame"));
            }
            else{
                System.out.println("Error: No existe un prestamo con ese id.");
            }
        }
        catch (SQLException e){
            System.err.println();
        }
    }

    public static void devolverV(int id){
        String buscar = "SELECT * FROM v_alquilados WHERE id=?";
        String salvate = "DELETE FROM v_alquilados WHERE id=?";
        String juegodevuelto ="UPDATE Videogames SET unidades=unidades+1 WHERE id=?";

        try(Connection conn = DBConnection.getConnection();PreparedStatement bs = conn.prepareStatement(buscar);PreparedStatement slvt = conn.prepareStatement(salvate);PreparedStatement jd = conn.prepareStatement(juegodevuelto)){
            bs.setInt(1,id);
            slvt.setInt(1,id);

            ResultSet rs = bs.executeQuery();

            if(!rs.next()){
                System.out.println("Error: No existe ningun prestamo con ese id.");
                return;
            }

            int idVidiogueim = rs.getInt("id_videogame");

            jd.setInt(1,idVidiogueim);

            jd.executeUpdate();

            slvt.executeUpdate();

            System.out.println("Juego devuelto correctamente :D!");

        }
        catch (SQLException e){
            System.err.println("Error: "+e.getMessage());
        }
    }

    public static List<Prestamo> getByVideogameId(int id){
        String porVideogameId="SELECT * FROM v_alquilados WHERE id_videogame=?";
        List<Prestamo> PVD = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();PreparedStatement pvd = conn.prepareStatement(porVideogameId)){
            pvd.setInt(1,id);
            ResultSet rs = pvd.executeQuery();
                while(rs.next()){
                    Prestamo m = new Prestamo(rs.getInt("id"),rs.getString("persona_alq"),rs.getInt("id_videogame"));
                    PVD.add(m);
                }
                if (PVD.isEmpty()){
                    System.out.println("Error: No hay unidades prestadas de este juego");
                }
        }
        catch (SQLException e){
            System.err.println("Error: "+e.getMessage());
        }
        return PVD;
    }
}
