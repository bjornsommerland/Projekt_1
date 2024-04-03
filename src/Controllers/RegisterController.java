package Controllers;
import Database._DATA;
import Model.*;

public class RegisterController {

    public static User createUser(String class_name,String password,String name,String username) {
        User u = null;
        if (class_name.equals("Guest")) {
            u = new Guest(password,name,username);
        } else if (class_name.equals("Admin")) {
            u = new Admin(password,name,username);
        }
        if (u == null) {return null;}
        _DATA.addtoUserData(u);
        return u;
    }
}
