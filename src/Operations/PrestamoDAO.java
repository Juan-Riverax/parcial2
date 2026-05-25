package Operations;

import DB.DBConnection;
import Model.Prestamo;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PrestamoDAO {
    public static void agregarPers(Prestamo prs){
        String agregarP="INSERT INTO v_alquilados (id_videogame,persona_alq) VALUES (?,?)";
        try(Connection conn= DBConnection.getConnection(); PreparedStatement aP = conn.prepareStatement(agregarP)){
            aP.setInt(1,prs.getId_videogame());
            aP.setString(2, prs.getCliente());
            aP.executeUpdate();
        }
        catch(Exception e){
            System.err.println("Error:"+e.getMessage());;
        }
    }

}
