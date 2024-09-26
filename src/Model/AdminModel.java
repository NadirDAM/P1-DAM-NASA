package Model;

import Rols.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminModel {

    public static ArrayList<User> getUsers () throws SQLException {
        ArrayList<User> listaUsuarios = new ArrayList<>();

        ResultSet result = DBPreparedStatments.crearSentenciaSelect(DBConnection.crearConexio(), "SELECT * FROM user");
        while (result.next()) {
            listaUsuarios.add(new User(result.getInt(1),result.getString(2),result.getString(3)));
        }
        return listaUsuarios;
    }

    public static ArrayList<String> getRols (int id, boolean isAsignedRols) throws SQLException {
        int valor = isAsignedRols ? 1 : 0;
        ArrayList<String> rols = new ArrayList<>();
        ResultSet result = DBPreparedStatments.crearSentenciaSelect(DBConnection.crearConexio(),
                "SELECT 'mechanic' AS us_mechanic FROM nasa.user WHERE us_mechanic = " + valor + " AND us_id = " + id + " UNION ALL SELECT 'physicist' AS us_physicist FROM nasa.user " +
                    "WHERE us_physicist = " + valor + " AND us_id = " + id + " UNION ALL SELECT 'spy' AS us_spy FROM nasa.user WHERE us_spy = " + valor + " AND us_id = " + id + " UNION ALL SELECT 'astronaut' " +
                    "AS us_astronaut FROM nasa.user WHERE us_astronaut = " + valor + " AND us_id = " + id + "");
        while (result.next()) {
            rols.add(result.getString(1));
        }
        return rols;
    }
}
