package cms;

public class Users {

    private int id;
    private String name;
    private String password;

    public Users(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Usuario [username=").append(name).append(", password= ********").append("]");
        return builder.toString();
    }


}
