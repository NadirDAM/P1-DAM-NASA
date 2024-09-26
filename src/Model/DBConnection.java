package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection conn;
    private static String url = "jdbc:mysql://localhost/nasa";
    private static String user = "root";
    private static String contrasenya = "123456";


    public static Connection crearConexio () {

        try {
            conn = DriverManager.getConnection(url,user,contrasenya);
            if (!conn.isClosed()) System.out.println("Connexió creada correctament.");
        } catch (SQLException e) {
            System.out.println("Error: Ha fallat la connexió: " + e.getMessage());
        }

        return conn;
    }

    public static void tancarConexio () {
        try {
            conn.close();
            if (conn.isClosed()) System.out.println("Connexió tancada correctament.");
        } catch (SQLException e) {
            System.out.println("Error: Ha fallat el tancament de la connexió: " + e.getMessage());
        }
    }

}