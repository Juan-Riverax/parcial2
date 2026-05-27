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
    public static List<Videogame> getAllVideogames(){ //esto es para que me los muestre todos con todos los datos
        List<Videogame> catalog = new ArrayList<>();

        String show_catalog="SELECT * FROM Videogames ORDER BY id ASC";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement sc = conn.prepareStatement(show_catalog);
            ResultSet rs = sc.executeQuery()){
            while(rs.next()){
                Videogame v = new Videogame(rs.getInt("id"),rs.getString("name"),rs.getString("genero"),rs.getDouble("precio"),rs.getInt("unidades"),rs.getInt("id_desarrollador"));
                catalog.add(v);
            }
        }
        catch (SQLException e){
            System.err.println("Error:"+e.getMessage());
        }
        return catalog;
    }

    public static List<Videogame> getByName(String s){ // esto es para buscarlo por nombre
        List<Videogame> name = new ArrayList<>();

        String show_name="SELECT * FROM Videogames WHERE name ILIKE ? ORDER BY id ASC";

        try (Connection conn = DBConnection.getConnection(); PreparedStatement sn = conn.prepareStatement(show_name)){
            sn.setString(1,"%"+s+"%");
            ResultSet rs = sn.executeQuery();
            while(rs.next()){
                Videogame v = new Videogame(rs.getInt("id"),rs.getString("name"),rs.getString("genero"),rs.getDouble("precio"),rs.getInt("unidades"),rs.getInt("id_desarrollador"));
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

    public static List<Videogame> getByGenre(String s){// esto es pa buscarlo por genero

        List<Videogame> genero = new ArrayList<>();

        String show_genero="SELECT * FROM Videogames WHERE genero ILIKE ? ORDER BY id ASC";

        try(Connection conn = DBConnection.getConnection(); PreparedStatement sg = conn.prepareStatement(show_genero)){
            sg.setString(1,"%"+s+"%");
            ResultSet rs = sg.executeQuery();
            while(rs.next()){
                Videogame v = new Videogame(rs.getInt("id"),rs.getString("name"),rs.getString("genero"),rs.getDouble("precio"),rs.getInt("unidades"),rs.getInt("id_desarrollador"));
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

    public static Videogame getById(int id){// esto es pa buscarlo por id del juego
        String bid = "SELECT * FROM Videogames WHERE id=?";

        Videogame v = null;

        try(Connection conn=DBConnection.getConnection();PreparedStatement sid=conn.prepareStatement(bid)){
            sid.setInt(1,id);
            ResultSet rs = sid.executeQuery();
            if (rs.next()){
                v= new Videogame(rs.getInt("id"),rs.getString("name"),rs.getString("genero"),rs.getDouble("precio"),rs.getInt("unidades"),rs.getInt("id_desarrollador"));
            }
            else{
                System.out.println("Error: No existe un videojuego con ese id.");
            }
        }
        catch (SQLException e){
            System.err.println("Error: "+e.getMessage());
        }
        return v;
    }

    public static void insertVideogame(Videogame v){//esto es pa meter un juego nuevo
        String adicionar_jogo="INSERT INTO Videogame (name,genero,precio,unidades) VALUES (?,?,?,?)";

        try(Connection conn=DBConnection.getConnection();PreparedStatement ad = conn.prepareStatement(adicionar_jogo)){
            ad.setString(1,v.getName());
            ad.setString(2,v.getGeneroS());
            ad.setDouble(3,v.getPrecio());
            ad.setInt(4,v.getUnidades());
            ad.executeUpdate();

            System.out.println("Añadido correctamente!");
        }
        catch (SQLException e){
            System.err.println("Error: "+e.getMessage());
        }
    }

    public static void alquilarV(int i,String persona_alq){//esto es pa la alquilada de un juego
        String busca="SELECT * FROM Videogames WHERE id = ?";
        String alquilar="UPDATE Videogames set unidades=? WHERE id = ?";

        try(Connection conn = DBConnection.getConnection();PreparedStatement bs = conn.prepareStatement(busca);PreparedStatement alq =conn.prepareStatement(alquilar)){
            bs.setInt(1,i);
            ResultSet rs= bs.executeQuery();

            if(!rs.next()){
                System.out.println("No existe ningun juego con ese id");
                return;
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
            Prestamo prs= new Prestamo(i,persona_alq);
            PrestamoDAO.agregarPers(prs);
            System.out.println("Accion realizada con exito :D!");
        }
        catch (Exception e){
            System.err.println("Error: "+e.getMessage());
        }
    }

    public static void agregarVideojuego(String v, int p){//esto es pa que se agreguen unidades a un jueguito ya existente
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
            System.out.println("Accion realizada con exito! Unidades de "+v+" ahora son de:"+u);
        }
        catch (Exception e){
            System.err.println("Error:"+e.getMessage());
        }
    }

    public static List<Videogame> getByDeveloper_ID(int i){ //esto es pa que lo saquen por id del desarrollador
        String buscarDesa = "SELECT * FROM Videogames WHERE id_desarrollador = ?";
        List<Videogame> sD = new ArrayList<>();
        try(Connection conn=DBConnection.getConnection();PreparedStatement bs = conn.prepareStatement(buscarDesa)){
        bs.setInt(1,i);
        ResultSet rs = bs.executeQuery();

        while(rs.next()){
            Videogame v = new Videogame(rs.getInt("id"),rs.getString("name"),rs.getString("genero"),rs.getDouble("precio"),rs.getInt("unidades"),rs.getInt("id_desarrollador"));
            sD.add(v);
        }
        }
        catch (Exception e){
            System.err.println("Error:"+e.getMessage());
        }
        return sD;
    }
}
