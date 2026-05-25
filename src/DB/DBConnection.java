package DB;
import java.sql.Connection;
import java.sql.DriverManager;
import com.github.shyiko.dotenv.DotEnv;
import java.sql.SQLException;
import java.util.Map;

public class DBConnection {
    private static final Map<String, String> dotenv = DotEnv.load();

    public static Connection getConnection() throws SQLException {
        String URL = dotenv.get("URLSUPERSECRETA");
        String USER = dotenv.get("USUARIOSUPERSECRETO");
        String KEY = dotenv.get("KEYSUPERSECRETA");
        return DriverManager.getConnection(URL, USER, KEY);
    }
}
