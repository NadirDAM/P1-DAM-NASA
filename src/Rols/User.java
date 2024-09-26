package Rols;

public class User {
    private int us_id;
    private String us_name;
    private String us_password;

    public User(int id, String nombre, String rol) {
        this.us_id = id;
        this.us_name = nombre;
        this.us_password = rol;
    }

    public int getId() { return us_id; }
    public void setId(int id) { this.us_id = id; }

    public String getNombre() { return us_name; }
    public void setNombre(String nombre) { this.us_name = nombre; }

    public String getRol() { return us_password; }
    public void setRol(String rol) { this.us_password = rol; }
}