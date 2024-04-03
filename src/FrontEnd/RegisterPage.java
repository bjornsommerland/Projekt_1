package FrontEnd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Commands.register;

public class RegisterPage implements ActionListener {

    JButton submitbutton;
    JButton comebackbutton;
    JTextField passwordfield;
    JTextField usernamefield;
    JTextField namefield;
    JFrame Frame;

    public void Init() {
        this.Frame = new JFrame("Register Page");
        JPanel main = new JPanel();
        // Tworzenie obiektów.
        JLabel usernamelabel = new JLabel("Username");
        this.comebackbutton = new JButton("Exit");
        this.usernamefield = new JTextField();
        JLabel passwordlabel = new JLabel("Password");
        this.passwordfield = new JTextField();
        this.submitbutton = new JButton("Submit");
        JLabel namelabel = new JLabel("Name");
        this.namefield = new JTextField();
        // Funkcjonalność.
        submitbutton.addActionListener(this);
        comebackbutton.addActionListener(this);
        // Pozycjonowanie i ustawianie stworzonych obiektów.
        Frame.setMinimumSize(new Dimension(500, 500));
        main.setLayout(new GridLayout(3, 3));
        main.add(usernamelabel);
        main.add(passwordlabel);
        main.add(namelabel);
        main.add(usernamefield);
        main.add(passwordfield);
        main.add(namefield);
        main.add(submitbutton);
        main.add(comebackbutton);
        Frame.add(main);
        // Końcowe ustawianie.
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.pack();
        Frame.setVisible(true);
    }
    public void comebackWelcomePage() {
        WelcomePage page = new WelcomePage();
        page.Init();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitbutton) {
            String[] args = new String[3];
            args[0] = usernamefield.getText();
            args[1] = passwordfield.getText();
            args[2] = namefield.getText();
            register.execute(args);
            comebackWelcomePage();
            Frame.dispose();
        } else if (e.getSource() == comebackbutton) {
            comebackWelcomePage();
            Frame.dispose();
        }
        System.out.println(e.getSource().toString());
        System.out.println("ACTION DONE");
    }
}
