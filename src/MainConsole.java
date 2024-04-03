import Database._DATA;
import Model.Admin;
import Model.Guest;
import Model.User;
import Controllers.*;
import Utility.Task;
import java.util.Scanner;
import Commands.*;


public class MainConsole {

    public static void main(String[]any) {


       LoginController.getUserInfo("user_guest_1","login1234");
        Admin admin = (Admin) _DATA.getUser("user_admin_1");
        admin.assignTask("user_guest_1","Task_1","2025-20-01","Description");
        Guest guest = _DATA.getGuest("user_guest_1");
        for (Task t : guest.getTasks()) {
            System.out.println(t.getName());
        }
        Scanner myObj = new Scanner(System.in);

        /*while (true) {
            System.out.println("/login nazwa haslo");
            String input = myObj.nextLine();
            String[] splited_input = input.split(" ");
            String command_name = splited_input[0];

            if (command_name.equals("/login")) {
                String[] args = new String[5];
                for (int i = 1;i<splited_input.length;i++) {
                    args[i-1] = splited_input[i];
                }
                login.execute(myObj,args);
            }else if (command_name.equals("/exit")) {
                break;
            }
        }*/


    }
}
