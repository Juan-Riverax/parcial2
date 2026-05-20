package DB;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL = "jdbc:postgresql://ep-steep-bonus-aq5p30th-pooler.c-8.us-east-1.aws.neon.tech/neondb?user=neondb_owner&password=npg_YF48MpbhAKLx&sslmode=require&channelBinding=require";
    private static final String USER = "neondb_owner";
    private static final String PASSWORD = "npg_YF48MpbhAKLx";

    private static Connection getConnection() {

        try{ Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("exito pai");
            return connection;
        } catch (Exception e){
            System.out.println("Error pai");
            System.out.println(e.getMessage());
            return null;
        }
    }

}
