package Database;
import Model.User;
import Utility.Task;

import java.io.*;
import java.util.ArrayList;

public class _DATA  {
    private static ArrayList<User> UserData;
    private static ArrayList<Task> TaskData;
    public static ArrayList<User> odczyt_uzytkownikow(String nazwaPliku) {
        ArrayList<User> listaOsobOdczytana = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nazwaPliku))) {
            listaOsobOdczytana = (ArrayList<User>) inputStream.readObject();
            UserData = listaOsobOdczytana;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Nie dziala");
        }
        return listaOsobOdczytana;
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
