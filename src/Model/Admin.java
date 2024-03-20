package Model;


import Utility.Task;

import java.io.Serializable;
import java.util.ArrayList;

public class Admin extends User implements Serializable {

    public Admin(String password, String name, String username) {
        super(password, name, username,2);
    }
    public void ViewGuest(Guest user_guest) {
        ArrayList <Task> tasks = user_guest.GetTasks();
        String Name = user_guest.getName();
        String Username = user_guest.getUsername();
        // Zrobic
    }

    public void DeleteUser() {

    }
}
