package Operations;

import DB.DBConnection;
import Model.Prestamo;
import Model.Videogame;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VideogameDAO {
    public static List<Videogame> getAllVideogames(){
        List<Videogame> catalog = new ArrayList<>();

        String show_catalog="SELECT * FROM Videogames ORDER BY id ASC";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement sc = conn.prepareStatement(show_catalog);
            ResultSet rs = sc.executeQuery()){
            while(rs.next()){
                Videogame v = new Videogame(rs.getInt("id"),rs.getString("name"),rs.getString("genero"),rs.getDouble("precio"),rs.getInt("unidades"));
                catalog.add(v);
            }
        }
        catch (SQLException e){
            System.err.println("Error:"+e.getMessage());
        }
        return catalog;
    }

    public static List<Videogame> getByName(String s){
        List<Videogame> name = new ArrayList<>();

        String show_name="SELECT * FROM Videogames WHERE name ILIKE ? ORDER BY id ASC";

        try (Connection conn = DBConnection.getConnection(); PreparedStatement sn = conn.prepareStatement(show_name)){
            sn.setString(1,"%"+s+"%");
            ResultSet rs = sn.executeQuery();
            while(rs.next()){
                Videogame v = new Videogame(rs.getInt("id"),rs.getString("name"),rs.getString("genero"),rs.getDouble("precio"),rs.getInt("unidades"));
                name.add(v);
            }
            if(name.isEmpty()) {
                System.out.println("ERROR: NOMBRE NO ENCONTRADO :(");
            }
        }
        catch (Exception e){
            System.err.println("Error:"+e.getMessage());
        }
    return name;
    }

    private static List<Videogame> getByGenre(String s){

        List<Videogame> genero = new ArrayList<>();

        String show_genero="SELECT * FROM Videogames WHERE genero ILIKE ? ORDER BY id ASC";

        try(Connection conn = DBConnection.getConnection(); PreparedStatement sg = conn.prepareStatement(show_genero)){
            sg.setString(1,"%"+s+"%");
            ResultSet rs = sg.executeQuery();
            while(rs.next()){
                Videogame v = new Videogame(rs.getInt("id"),rs.getString("name"),rs.getString("genero"),rs.getDouble("precio"),rs.getInt("unidades"));
                genero.add(v);
            }
            if (genero.isEmpty()){
                System.out.println("Genero no registrado :(");
            }
        }
        catch (Exception e){
            System.err.println("Error:"+e.getMessage());
        }
        return genero;
    }

    private static Videogame getById(int id){
        String bid = "SELECT * FROM Videogames WHERE id=?";

        Videogame v = null;

        try(Connection conn=DBConnection.getConnection();PreparedStatement sid=conn.prepareStatement(bid)){
            sid.setInt(1,id);
            ResultSet rs = sid.executeQuery();
            if (rs.next()){
                v= new Videogame(rs.getInt("id"),rs.getString("name"),rs.getString("genero"),rs.getDouble("precio"),rs.getInt("unidades"));
            }
        }
        catch (SQLException e){
            System.err.println("Error: "+e.getMessage());
        }
        return v;
    }

    private static void insertVideogame(Videogame v){
        String adicionar_jogo="INSERT INTO Videogame (name,genero,precio,unidades)";

        try(Connection conn=DBConnection.getConnection();PreparedStatement ad = conn.prepareStatement(adicionar_jogo)){
            ad.setString(1,v.getName());
            ad.setString(2,v.getGeneroS());
            ad.setDouble(3,v.getPrecio());
            ad.setInt(4,v.getUnidades());
            ad.executeQuery();

            System.out.println("Añadido correctamente!");
        }
        catch (SQLException e){
            System.err.println("Error: "+e.getMessage());
        }
    }

    private static void alquilarV(int i,String cliente){
        String busca="SELECT * FROM Videogames WHERE id = ?";
        String alquilar="UPDATE Videogames set unidades=? WHERE id = ?";

        try(Connection conn = DBConnection.getConnection();PreparedStatement bs = conn.prepareStatement(busca);PreparedStatement alq =conn.prepareStatement(alquilar)){
            bs.setInt(1,i);
            ResultSet rs= bs.executeQuery();

            if(!rs.next()){
                System.out.println("No existe ningun juego con ese id");
            }

            int u = rs.getInt("unidades");

            if(u==0){
                System.out.println("No hay unidades disponibles");
                return;
            }

            u--;

            alq.setInt(1,u);
            alq.setInt(2,i);
            alq.executeUpdate();
            int x = rs.getInt("id");
            Prestamo prs= new Prestamo(x,cliente);
            PrestamoDAO.agregarPers(prs);
            System.out.println("Accion realizada con exito :D!");
        }
        catch (Exception e){
            System.err.println("Error: "+e.getMessage());
        }
    }

    private static void agregarVideojuego(String v, int p){
        String subir ="UPDATE Videogames SET unidades=? WHERE name = ?";
        String buscar ="SELECT * FROM Videogames WHERE name = ?";

        try(Connection conn = DBConnection.getConnection();PreparedStatement bs=conn.prepareStatement(buscar);PreparedStatement sb = conn.prepareStatement(subir)){
            bs.setString(1,v);
            ResultSet rs = bs.executeQuery();
            int u=0;

            if(rs.next()){
                u=rs.getInt("unidades")+p;
                sb.setInt(1,u);
                sb.setString(2,v);
                sb.executeUpdate();
            }
            System.out.println("Accion realizada con exito! Unidades de"+v+"ahora son de:"+u);
        }
        catch (Exception e){
            System.err.println("Error:"+e.getMessage());
        }
    }
}
