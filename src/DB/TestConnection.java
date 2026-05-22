package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) throws SQLException {

        String connection_key= "jdbc:postgresql://ep-steep-bonus-aq5p30th-pooler.c-8.us-east-1.aws.neon.tech/neondb?user=neondb_owner&password=npg_YF48MpbhAKLx&sslmode=require&channelBinding=require";

        Connection conn = DriverManager.getConnection(connection_key);
        System.out.println("Exitos");

    }
}
