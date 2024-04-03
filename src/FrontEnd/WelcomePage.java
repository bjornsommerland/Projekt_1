package FrontEnd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage implements ActionListener {

    JButton registerbutton;
    JButton loginbutton;
    JFrame Frame;
    JFrame mainFrame;


    public void Init(){
        this.Frame = new JFrame("Welcome Page");
        JPanel main = new JPanel();
        // Tworzenie obiektów.
        JLabel welcomeLabel = new JLabel("Welcome");
        this.registerbutton = new JButton("Register");;
        this.loginbutton = new JButton("Login");
        // Funkcjonalność.
        registerbutton.addActionListener(this);
        loginbutton.addActionListener(this);
        // Pozycjonowanie i ustawianie stworzonych obiektów.
        Frame.setMinimumSize(new Dimension(500,500));
        main.setLayout(new GridLayout(3,2));
        main.add(welcomeLabel);
        main.add(registerbutton);
        main.add(loginbutton);
        Frame.add(main);

        // Końcowe ustawianie.
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.pack();
        Frame.setVisible(true);

    }

    /*public WelcomePage(JFrame _MainFrame) {
        this.mainFrame = _MainFrame;
        this.mainFrame.setLayout(new CardLayout());
    }*/
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerbutton) {
            RegisterPage Page = new RegisterPage();
            Page.Init();
            Frame.dispose();
        } else if (e.getSource() == loginbutton) {
            LoginPage Page = new LoginPage();
            Page.Init();
            Frame.dispose();
        }
    }
}
