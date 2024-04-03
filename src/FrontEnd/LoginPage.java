package FrontEnd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Commands.login;
import Model.Admin;
import Model.Guest;
import Model.User;


public class LoginPage implements ActionListener {

    JButton submitbutton;
    JButton comebackbutton;
    JTextField passwordfield;
    JTextField usernamefield;
    JFrame Frame;

    public void Init() {
        this.Frame = new JFrame("Login Page");
        JPanel main = new JPanel();
        // Tworzenie obiektów.
        JLabel usernamelabel = new JLabel("Username");
        this.comebackbutton = new JButton("Exit");
        this.usernamefield = new JTextField();
        JLabel passwordlabel = new JLabel("Password");
        this.passwordfield = new JTextField();
        this.submitbutton = new JButton("Submit");
        // Funkcjonalność.
        submitbutton.addActionListener(this);
        comebackbutton.addActionListener(this);
        // Pozycjonowanie i ustawianie stworzonych obiektów.
        Frame.setMinimumSize(new Dimension(500, 500));
        main.setLayout(new GridLayout(3, 2));
        main.add(usernamelabel);
        main.add(passwordlabel);
        main.add(usernamefield);
        main.add(passwordfield);
        main.add(submitbutton);
        main.add(comebackbutton);
        Frame.add(main);
        // Końcowe ustawianie.
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.pack();
        Frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitbutton) {
            String[] args = new String[2];
            args[0] = usernamefield.getText();
            args[1] = passwordfield.getText();
            User u = login.execute(args);
            if (u != null) {
                // GUEST
                if (u.getPermlvl() == 1) {
                    GuestPage Page = new GuestPage((Guest) u);
                    Page.Init();
                }
                // ADMIN
                /*if (u.getPermlvl() == 2) {
                    AdminPage Page = new AdminPage((Admin) u);
                }*/
                Frame.dispose();
            }
        } else if (e.getSource() == comebackbutton) {
            WelcomePage Page = new WelcomePage();
            Page.Init();
            Frame.dispose();
        }
    }
}
