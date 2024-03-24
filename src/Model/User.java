package Model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public abstract class User implements Serializable {
    private HashMap<String,String> loginData;
    private String password;
    private String name;
    private String username;
    private int permlvl;
    public User(String password, String name, String username, int permissionlvl){
        this.password = password;
        this.name = name;
        this.username = username;
        this.permlvl = permissionlvl;
        this.loginData.put(username,password);
    }

    public boolean loginInfo(String username, String password){

        if (!loginData.containsKey(username)){
            return false;
        }
        return Objects.equals(password, loginData.get(username));
    }
    public String getName() {
        return this.name;
    }
    public String getUsername() {
        return this.username;
    }

}
