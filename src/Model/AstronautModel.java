package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AstronautModel {
    private String name;
    private String address;
    private String firstFly;
    private int successMissions;
    private int failMissions;
    private String range;

    public void fetchAstronautDetails(int userId) {
        Connection conn = DBConnection.crearConexio();
        String sql = "SELECT ast_name, ast_address, ast_first_fly, ast_success_mision, ast_fail_mision, ast_range FROM astronaut WHERE ast_us_id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                this.name = rs.getString("ast_name");
                this.address = rs.getString("ast_address");
                this.firstFly = rs.getString("ast_first_fly");
                this.successMissions = rs.getInt("ast_success_mision");
                this.failMissions = rs.getInt("ast_fail_mision");
                this.range = rs.getString("ast_range");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.tancarConexio();
        }
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getFirstFly() {
        return firstFly;
    }

    public int getSuccessMissions() {
        return successMissions;
    }

    public int getFailMissions() {
        return failMissions;
    }

    public String getRange() {
        return range;
    }
}
