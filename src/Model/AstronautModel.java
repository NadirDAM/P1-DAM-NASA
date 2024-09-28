package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AstronautModel {
    private int usId;
    private String name;
    private String birthday;
    private String firstFly;
    private int successMission;
    private int failMission;
    private String address;
    private String range;

    public int getUsId() {
        return usId;
    }

    public void setUsId(int usId) {
        this.usId = usId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getFirstFly() {
        return firstFly;
    }

    public void setFirstFly(String firstFly) {
        this.firstFly = firstFly;
    }

    public int getSuccessMission() {
        return successMission;
    }

    public void setSuccessMission(int successMission) {
        this.successMission = successMission;
    }

    public int getFailMission() {
        return failMission;
    }

    public void setFailMission(int failMission) {
        this.failMission = failMission;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public void fetchAstronautDetails(int usId) {
        Connection conn = DBConnection.crearConexio();
        String query = "SELECT * FROM astronaut WHERE ast_us_id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, usId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                this.usId = rs.getInt("ast_us_id");
                this.name = rs.getString("ast_name");
                this.birthday = rs.getString("ast_birthday");
                this.firstFly = rs.getString("ast_firts_fly");
                this.successMission = rs.getInt("ast_success_mision");
                this.failMission = rs.getInt("ast_fail_mision");
                this.address = rs.getString("ast_address");
                this.range = rs.getString("ast_range");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.tancarConexio();
        }
    }
}