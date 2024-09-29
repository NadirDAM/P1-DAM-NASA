package Rols;

public class Astronaut {
    private int ast_us_id;
    private String ast_name;
    private String ast_birthday;
    private String ast_first_fly;
    private String ast_address;
    private String ast_range;

    public Astronaut(int ast_us_id, String ast_name, String ast_birthday, String ast_first_fly, String ast_address,String ast_range) {
        this.ast_us_id = ast_us_id;
        this.ast_name = ast_name;
        this.ast_birthday = ast_birthday;
        this.ast_first_fly = ast_first_fly;
        this.ast_address = ast_address;
        this.ast_range = ast_range;
    }

    public String getAst_address() {
        return ast_address;
    }

    public void setAst_address(String ast_address) {
        this.ast_address = ast_address;
    }

    public int getAst_us_id() {
        return ast_us_id;
    }

    public void setAst_us_id(int ast_us_id) {
        this.ast_us_id = ast_us_id;
    }

    public String getAst_name() {
        return ast_name;
    }

    public void setAst_name(String ast_name) {
        this.ast_name = ast_name;
    }

    public String getAst_birthday() {
        return ast_birthday;
    }

    public void setAst_birthday(String ast_birthday) {
        this.ast_birthday = ast_birthday;
    }

    public String getAst_first_fly() {
        return ast_first_fly;
    }

    public void setAst_first_fly(String ast_first_fly) {
        this.ast_first_fly = ast_first_fly;
    }

    public String getAst_range() {
        return ast_range;
    }

    public void setAst_range(String ast_range) {
        this.ast_range = ast_range;
    }


}