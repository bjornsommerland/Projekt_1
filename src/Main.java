import Database._DATA;
import Model.Guest;
import Model.User;

import java.util.ArrayList;


public class Main {


     public static void main(String[]any) {
         ArrayList <User> Data = new ArrayList<User>();
         /*_DATA.odczyt_zadan("DATABASE.ser");
         _DATA.odczyt_uzytkownikow("DATABASE.ser");*/
         Data = _DATA.odczyt_uzytkownikow("DATABASE.ser");
         System.out.println(Data.get(0));
     }
}
