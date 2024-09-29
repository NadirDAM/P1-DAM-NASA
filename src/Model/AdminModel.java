package Model;

import Rols.Astronaut;
import Rols.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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


    public static void deleteUser (int id) throws SQLException {
        Statement result;
        DBPreparedStatments.crearSentenciaInsert(DBConnection.crearConexio(),"DELETE FROM astronaut WHERE ast_us_id = " +id +"");
        DBPreparedStatments.crearSentenciaInsert(DBConnection.crearConexio(),"DELETE FROM mechanic WHERE mec_us_id =  " +id +"");
        DBPreparedStatments.crearSentenciaInsert(DBConnection.crearConexio(),"DELETE FROM physicist WHERE phy_us_id = " +id +"");
        DBPreparedStatments.crearSentenciaInsert(DBConnection.crearConexio(),"DELETE FROM spy WHERE spy_us_id = " +id +"");
        DBPreparedStatments.crearSentenciaInsert(DBConnection.crearConexio(),"DELETE FROM user WHERE  us_id= " +id +"");
        DBPreparedStatments.crearSentenciaInsert(DBConnection.crearConexio(),"DELETE FROM working_hours WHERE wh_us_id = " +id +"");
    }

    public static void crearAstronaut (String user, String password) throws SQLException {
        DBPreparedStatments.crearSentenciaInsert(DBConnection.crearConexio(),"INSERT INTO user (us_name, us_password, us_admin, us_mechanic, us_physicist ,us_spy, us_astronaut) " +
                "VALUES ( '" + user + "', '" + password + "', 0,0,0,0,0);");

    }
    public static void editarAstronaut (int ast_us_id, String ast_name, String ast_birthday, String ast_first_fly , String ast_address, String ast_range) throws SQLException {

        DBPreparedStatments.crearSentenciaInsert(DBConnection.crearConexio(), "UPDATE astronaut " +
                " SET ast_name = '" + ast_name +"'," +
                "     ast_birthday = '" + ast_birthday +"'," +
                "     ast_first_fly = '" + ast_first_fly +"'," +
                "     ast_address = '" + ast_address +"'," +
                "     ast_range = '" + ast_range +"'" +
                " WHERE ast_us_id = " + ast_us_id);

    }

    public static void asignarRolAstronaut (int ast_us_id, String ast_name, String ast_birthday, String ast_first_fly , String ast_address, String ast_range) throws SQLException {

        DBPreparedStatments.crearSentenciaInsert(DBConnection.crearConexio(),"INSERT INTO astronaut (ast_us_id, ast_name, ast_birthday, ast_first_fly, ast_address, ast_range) " +
                "VALUES ( " + ast_us_id + ", '" + ast_name + "', '" + ast_birthday + "', '" + ast_first_fly + "', '" + ast_address + "', '" + ast_range + "');");

        DBPreparedStatments.crearSentenciaInsert(DBConnection.crearConexio(), "UPDATE user " +
                " SET us_astronaut = 1 " +
                " WHERE us_id = " + ast_us_id);

    }

    public static Astronaut getAtronautByID (int id) throws SQLException {

        ResultSet result = DBPreparedStatments.crearSentenciaSelect(DBConnection.crearConexio(), "SELECT ast_us_id, ast_name, ast_birthday, ast_first_fly, ast_address, ast_range FROM astronaut WHERE ast_us_id = " + id + " ");

        Astronaut astronaut = null;

        while (result.next()) {
            astronaut = new Astronaut(result.getInt(1),result.getString(2),result.getString(3), result.getString(4),result.getString(5),result.getString(6));
        }
        return astronaut;
    }
}
