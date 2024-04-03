package Controllers;

import Database._DATA;
import Model.User;

public class LoginController {
    public static User getUserInfo(String username,String password) {
        boolean verdict = _DATA.checkifCanLogIn(username,password);
        if (verdict) {
            User u = _DATA.getUser(username);
            System.out.println("zalogowany");
            return u;
        }else {
            System.out.println("bledne haslo");
        }
        return null;
    }
}
