package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBPreparedStatments {

    private static PreparedStatement sentencia;


    public static java.sql.Statement crearSentenciaInsert (Connection conn, String sql) {
        try {
            sentencia = conn.prepareStatement(sql);
            sentencia.execute();
            if (!sentencia.isClosed()) System.out.println("Sentencia insert executada correctament.");
        } catch (SQLException e) {
            System.out.println("Error: Ha fallat la creació de la sentencia: " + e.getMessage());
        }

        return sentencia;
    }

    public static ResultSet crearSentenciaSelect (Connection conn, String sql) {
        ResultSet resultat = null;
        try {
            sentencia = conn.prepareStatement(sql);
            resultat = sentencia.executeQuery();
            if (!sentencia.isClosed()) System.out.println("Sentencia select executada correctament.");

        } catch (SQLException e) {
            System.out.println("Error: Ha fallat la creació de la sentencia: " + e.getMessage());
        }
        return resultat;
    }

    public static void tancarSentencia () {
        try {
            sentencia.close();
            if (sentencia.isClosed()) System.out.println("Sentencia tancada correctament.");
        } catch (SQLException e) {
            System.out.println("Error: Ha fallat el tancament de la sentencia: " + e.getMessage());
        }
    }

}