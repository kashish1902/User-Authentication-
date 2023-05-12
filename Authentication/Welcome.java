import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Welcome extends JFrame {
    String username;

    Welcome(String username) {
        this.username = username;
        JFrame frame = new JFrame("Welcome");
        JLabel label1 = new JLabel("Welcome " + username);
        JButton button1 = new JButton("Logout");
        JButton button2 = new JButton("Register");
        frame.add(label1);
        frame.add(button1);
        frame.add(button2);
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                JOptionPane.showMessageDialog(null, "Logout Successful");
                new Login();
            }
        });
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Register();
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(650, 300, 300, 200);
        frame.setLayout(new GridLayout(3, 1));
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Welcome("username");
    }
}
