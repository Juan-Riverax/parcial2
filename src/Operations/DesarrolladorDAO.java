package Operations;

import DB.DBConnection;
import Model.Desarrollador;
import Model.DesarrolladorYJuego;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DesarrolladorDAO {

    public static List<Desarrollador> getAllDevelopers(){
        List<Desarrollador> D = new ArrayList<>();
        String todos="SELECT * FROM desarrolladores ORDER BY id ASC";

        try(Connection conn = DBConnection.getConnection();PreparedStatement tds = conn.prepareStatement(todos); ResultSet rs = tds.executeQuery()){
            while(rs.next()){
                 Desarrollador ds = new Desarrollador(rs.getInt("id"),rs.getString("name"),rs.getString("pais"));
                 D.add(ds);
            }
        }
        catch (SQLException e){
            System.err.println("Error: "+e.getMessage());
        }
        return D;
    }

    public static List<DesarrolladorYJuego> showDevelpoerAndGame(int d){
        String prompt ="SELECT desarrolladores.name AS desarrollador, videogames.name AS juego FROM desarrolladores JOIN videogames ON videogames.id_desarrollador=desarrolladores.id WHERE desarrolladores.id=?";
        List<DesarrolladorYJuego> lst = new ArrayList<>();

        try(Connection conn = DBConnection.getConnection();PreparedStatement prmpt = conn.prepareStatement(prompt)){
            prmpt.setInt(1,d);
            ResultSet rs = prmpt.executeQuery();
            while(rs.next()){
                DesarrolladorYJuego l =new DesarrolladorYJuego(rs.getString("desarrollador"),rs.getString("juego"));
                lst.add(l);
            }
            if(lst.isEmpty()){
                System.out.println("No hay ningun desarrollador registrado con este id.");
            }
        }
        catch (SQLException e){
            System.err.println("Error: "+e.getMessage());
        }
        return lst;
    }

    public static List<Desarrollador> getByCountry(String s){
        List<Desarrollador> D = new ArrayList<>();
        String todos="SELECT * FROM desarrolladores WHERE pais=?";

        try(Connection conn = DBConnection.getConnection();PreparedStatement tds = conn.prepareStatement(todos)){
            tds.setString(1,"%"+s+"%");
            ResultSet rs = tds.executeQuery();
            while(rs.next()){
                Desarrollador ds = new Desarrollador(rs.getInt("id"),rs.getString("name"),rs.getString("pais"));
                D.add(ds);
            }
        }
        catch (SQLException e){
            System.err.println("Error: "+e.getMessage());
        }
        return D;
    }

}
