import Database._DATA;
import Model.Admin;
import Model.Guest;
import Model.User;
import Controllers.*;
import Utility.Task;

import java.awt.*;
import java.util.Scanner;
import Commands.*;
import FrontEnd.*;

import javax.swing.*;

public class MainSwing {
    public static void main(String[]args){
        _DATA.init();
        _DATA.odczyt_uzytkownikow("DATABASE.ser");
        //RegisterController.createUser("Admin","login1234","marcin","user_admin_1");
        //RegisterController.createUser("Guest","login1234","gabrys","user_guest_1");
        /**/
        Admin admin = (Admin) _DATA.getUser("user_admin_1");
        admin.assignTask("user_guest_1","Task_1","2025-20-01","Description");
        admin.assignTask("user_guest_1","Task_2","2025-20-01","Description");
        admin.assignTask("user_guest_1","Task_3","2025-20-01","Description");

        for (User u : _DATA.getUserData()) {
            System.out.println(u.getUsername());
        }

        /*JFrame Main = new JFrame();
        Main.setLayout(new CardLayout());*/

        WelcomePage page = new WelcomePage();

        page.Init();
        _DATA.zapis_daty_uzytkownikow("DATABASE.ser",_DATA.getUserData());
    }
}
