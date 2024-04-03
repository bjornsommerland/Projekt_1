package FrontEnd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Commands.login;
import Model.Guest;
import Model.User;

public class GuestPage implements ActionListener {


    JFrame Frame;
    JPanel main_panel;
    JPanel task_panel;
    JButton viewtasks;
    JButton exittasks;
    Guest user;

    public GuestPage(Guest u){
        this.user = u;
    }
    public JPanel initMainPanel() {
        this.main_panel = new JPanel();
        JLabel usernamelabel = new JLabel(user.getName());
        this.viewtasks = new JButton("View Tasks");
        main_panel.setLayout(new GridLayout(2, 1));
        main_panel.add(usernamelabel);
        main_panel.add(viewtasks);
        viewtasks.addActionListener(this);
        return main_panel;
    }

    public JPanel initTaskPanel() {
        this.task_panel = new JPanel();
        this.exittasks = new JButton("Exit Tasks");
        JLabel taskdisplay = new JLabel(user.DisplayTasks());
        task_panel.setLayout(new GridLayout(1, 2));
        task_panel.add(this.exittasks);
        task_panel.add(taskdisplay);
        exittasks.addActionListener(this);
        return task_panel;
    }

    public void Init() {
        this.Frame = new JFrame(user.getName() + " Page");
        // Pozycjonowanie i ustawianie stworzonych obiektów.
        Frame.setMinimumSize(new Dimension(500, 500));
        // Załaczanie paneli.
        Frame.add(initTaskPanel());
        // Końcowe ustawianie.
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.pack();
        Frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.viewtasks) {
            Frame.removeAll();
            Frame.add(initTaskPanel());
        } else if (e.getSource() == this.exittasks) {
            Frame.removeAll();
            Frame.add(initMainPanel());
        }
    }
}
