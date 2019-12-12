/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexionbd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author akoum
 */
public class basededonnees {
    private String url = "jdbc:mysql://localhost:3306/pidev";
    private String login = "root";
    private String password = "";
    private Connection connection;
    private static basededonnees dataSource;

    private basededonnees() {
        try {
            connection = DriverManager.getConnection(url, login, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   public final boolean testexistdatabase()
{
    try {
            connection = DriverManager.getConnection(url, login, password);
        } catch (SQLException ex) {
            return false;
        }
    return true;
}
    public Connection getConnection() {
        return connection;
    }

    public static basededonnees getInstance() {
        if (dataSource == null) {
            dataSource = new basededonnees();
        }
        return dataSource;
    }
}
