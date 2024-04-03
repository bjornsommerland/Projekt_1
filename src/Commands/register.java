package Commands;
import Controllers.RegisterController;
import Model.User;

public class register {
    public static void execute(String[]args) {
        String input_username = args[0];
        String input_password = args[1];
        String input_name = args[2];
        User U = RegisterController.createUser("Guest",input_password,input_name,input_username);
        return;
    }
}
