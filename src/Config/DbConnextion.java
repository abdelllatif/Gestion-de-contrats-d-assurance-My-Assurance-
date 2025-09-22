package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnextion {
    private final String url = "jdbc:mysql://localhost:3306/gestion_contracts";
    private final String user = "root";
    private final String password = "";
    private final String driver = "com.mysql.cj.jdbc.Driver";

    public Connection getConnection(){
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException|SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
