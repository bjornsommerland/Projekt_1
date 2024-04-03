package Commands;
import Controllers.LoginController;
import Model.User;
import java.util.Scanner;

public class login {
    public static User execute(String[]args) {
        String input_username = args[0];
        String input_password = args[1];

        System.out.println(input_username);
        System.out.println(input_password);
        User U = LoginController.getUserInfo(input_username,input_password);
        return U;
    }
}
