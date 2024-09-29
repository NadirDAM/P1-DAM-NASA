package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {
    // Method to validate username and password
    public boolean validateUser(String username, String password) {
        boolean isValid = false;
        Connection conn = DBConnection.crearConexio();
        String sql = "SELECT us_password FROM user WHERE us_name = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                // Check if the password matches
                isValid = password.equals(rs.getString("us_password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isValid;
    }

    // Method to check if the user is an astronaut
    public boolean isAstronaut(int userId) {
        boolean isAstronaut = false;
        Connection conn = DBConnection.crearConexio();
        String sql = "SELECT us_astronaut FROM user WHERE us_id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                // Check if us_astronaut is set to 1
                isAstronaut = rs.getInt("us_astronaut") == 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAstronaut;
    }

    public boolean isAdmin(int userId) {
        boolean isAdmin = false;
        Connection conn = DBConnection.crearConexio();
        String sql = "SELECT us_admin FROM user WHERE us_id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                // Check if us_admin is set to 1
                isAdmin = rs.getInt("us_admin") == 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAdmin;
    }


    // Method to get user ID based on username
    public int getUserId(String username) {
        int userId = -1; // Default value if not found
        Connection conn = DBConnection.crearConexio();
        String sql = "SELECT us_id FROM user WHERE us_name = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                userId = rs.getInt("us_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userId;
    }
}
