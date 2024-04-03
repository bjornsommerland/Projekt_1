package Model;


import Database._DATA;
import Utility.Task;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends User implements Serializable {

    public Admin(String password, String name, String username) {
        super(password, name, username,2);
    }

    public void assignTask(String username, String Name, String DueDate, String Description) {
        Guest g = _DATA.getGuest(username);
        if (g == null) {return;}
        Task task = new Task(Name,DueDate,Description);
        g.RegisterTask(task);

    }

    @Override
    public boolean LoopAction(Scanner myObj) {
        System.out.println("/assign guest_name task_name task_description task_duedate");
        System.out.println("/delete guest_name");
        System.out.println("/view guest_name");
        System.out.println("/logout");
        String input = myObj.nextLine();
        String[] splited_input = input.split(" ");
        String command_name = splited_input[0];
        if (command_name.equals("/assign")) {
            String guest_name = splited_input[1];
            String task_name = splited_input[2];
            String task_description = splited_input[3];
            String task_duedate = splited_input[4];
            this.assignTask(guest_name,task_name,task_duedate,task_description);
        } else if (command_name.equals("/delete")) {
            String guest_name = splited_input[1];
            _DATA.removeUser(guest_name);
        } else if (command_name.equals("/view") ) {
            String guest_name = splited_input[1];
            Guest Guest_User = _DATA.getGuest(guest_name);
            if (Guest_User != null) {
                System.out.println("Name: " + Guest_User.getName());
                System.out.println("Username: " + Guest_User.getUsername());
                Guest_User.DisplayTasks();
            }
        } else if (command_name.equals("/logout")) {
            return false;
        }
        return true;
    }


}
