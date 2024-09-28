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
        String sql = "SELECT us_password FROM users WHERE us_name = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                // Assuming the password is stored as plain text for this example
                isValid = password.equals(rs.getString("us_password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.tancarConexio();
        }
        return isValid;
    }

    // Method to check if the user is an astronaut
    public boolean isAstronaut(int userId) {
        boolean isAstronaut = false;
        Connection conn = DBConnection.crearConexio();
        String sql = "SELECT us_astronaut FROM users WHERE us_id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                isAstronaut = rs.getInt("us_astronaut") == 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.tancarConexio();
        }
        return isAstronaut;
    }

    // Method to get user ID based on username
    public int getUserId(String username) {
        int userId = -1; // Default value if not found
        Connection conn = DBConnection.crearConexio();
        String sql = "SELECT us_id FROM users WHERE us_name = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                userId = rs.getInt("us_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.tancarConexio();
        }
        return userId;
    }
}
