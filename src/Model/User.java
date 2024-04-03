package Model;

import Database._DATA;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public abstract class User implements Serializable {
    //private HashMap<String,String> loginData;
    private String password;
    private String name;

    private String username;
    private int permlvl;
    public User(String password, String name, String username, int permissionlvl){
        this.password = password;
        this.name = name;
        this.username = username;
        this.permlvl = permissionlvl;
        _DATA.addtoUserData(this);
        _DATA.zapis_daty_uzytkownikow("DATABASE.ser",_DATA.getUserData());
       // this.loginData.put(username,password);
    }
    public abstract boolean LoopAction(Scanner myObj);

    /*public boolean loginInfo(String username, String password){

        if (!loginData.containsKey(username)){
            return false;
        }
        return Objects.equals(password, loginData.get(username));
    }*/
    public String getPassword() {
        return this.password;
    }
    public String getName() {
        return this.name;
    }
    public String getUsername() {
        return this.username;
    }

    public int getPermlvl() {

        return this.permlvl;
    }

}
