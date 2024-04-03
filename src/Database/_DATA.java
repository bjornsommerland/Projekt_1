package Database;
import Model.Guest;
import Model.User;
import Utility.Task;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class _DATA  {
    private static HashMap<String,String> loginData;
    private static ArrayList<User> UserData;
    private static ArrayList<Task> TaskData;

    public static void init() {
        if (UserData == null) {
            UserData = new ArrayList<User>();
        }
        if (TaskData == null) {
            TaskData = new ArrayList<Task>();
        }
        if (loginData == null) {
            loginData = new HashMap<String,String>();
        }
        System.out.println("initialized data");
    }
    public static void odczyt_uzytkownikow(String nazwaPliku) {
        ArrayList<User> listaOsobOdczytana = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nazwaPliku))) {
            listaOsobOdczytana = (ArrayList<User>) inputStream.readObject();
            UserData = listaOsobOdczytana;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Nie dziala");
        }
        for (User u : listaOsobOdczytana) {
            loginData.put(u.getUsername(),u.getPassword());
        }
    }
    public static boolean checkifCanLogIn(String username, String passentered) {
        boolean CanLogIn = false;
        try {
            String password = loginData.get(username);

            if (password.equals(passentered)) {
                CanLogIn = true;
            }
        } catch (Error e) {
            System.out.println(e);
        }

        return CanLogIn;
    }
    public static void addtoUserData(User u) {
        UserData.add(u);
    }
    public static ArrayList<User> getUserData() {
        return UserData;
    }
    public static ArrayList<Task> getTaskData() {
        return TaskData;
    }
    public static User getUser(String username) {
        for (User u : getUserData()) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }
    public static Guest getGuest(String username) {
        User u = getUser(username);

        try {
            if (u instanceof Guest) {
                Guest u1 = (Guest) u;
                return u1;
            }
        } catch (Error e) {
            System.out.println("User most likely doesn't exist");
        }
        return null;
    }
    public static ArrayList<Task> odczyt_zadan(String nazwaPliku) {
        ArrayList<Task> listaZadanOdczytana = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nazwaPliku))) {
            listaZadanOdczytana = (ArrayList<Task>) inputStream.readObject();
            TaskData = listaZadanOdczytana;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Nie dziala");
        }
        return listaZadanOdczytana;
    }

    public static void removeUser(String username) {
        Guest U = (Guest) getUser(username);
        if (U != null) {
            for (Task t : U.getTasks()) {
                TaskData.remove(t);
            }
            UserData.remove(U);
            zapis_daty_uzytkownikow("DATABASE.ser",UserData);
            zapis_daty_zadan("DATABASE.ser",TaskData);
        }
    }

    public static void zapis_daty_uzytkownikow(String nazwaPliku, ArrayList<User> userdata) {
        try (ObjectOutputStream OutputStream = new ObjectOutputStream(new FileOutputStream(nazwaPliku))) {
            OutputStream.writeObject(userdata);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void zapis_daty_zadan(String nazwaPliku, ArrayList<Task> taskdata) {
        try (ObjectOutputStream OutputStream = new ObjectOutputStream(new FileOutputStream(nazwaPliku))) {
            OutputStream.writeObject(taskdata);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
