package Model;

import java.io.Serializable;

public abstract class User implements Serializable {
    private String password;
    private String name;
    private String username;
    private int permlvl;
    public User(String password, String name, String username, int permissionlvl){
        this.password = password;
        this.name = name;
        this.username = username;
        this.permlvl = permissionlvl;
    }

    public String getName() {
        return this.name;
    }
    public String getUsername() {
        return this.username;
    }

}
