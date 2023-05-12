
import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame {
    String username;
    String password;
    JFrame frame;
    JLabel label1, label2;
    JTextField text1;
    JTextField text2;
    JButton button1, button2;

    Login() {
        frame = new JFrame("Login");

        label1 = new JLabel("Username");
        label2 = new JLabel("Password");
        text1 = new JTextField();
        text2 = new JPasswordField();
        button1 = new JButton("Login");
        button2 = new JButton("Register");

        frame.add(label1);
        frame.add(text1);
        frame.add(label2);
        frame.add(text2);
        frame.add(button1);
        frame.add(button2);

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                username = text1.getText();
                username = username.trim();
                password = text2.getText();
                password = password.trim();
                boolean fendCheck = false;
                // read from the file
                try {
                    // check to the end of file if user is present or not
                    Scanner sc = new Scanner(new File("user.txt"));
                    // Scanner s = new Scanner(System.in);
                    while (sc.hasNextLine()) {
                        String line = sc.nextLine();
                        String[] words = line.split(" ");
                        if (username.equals(words[0]) && password.equals(words[1])) {
                            frame.dispose();
                            JOptionPane.showMessageDialog(null, "Login Successful");
                            String name = words[2] + " " + words[3];
                            new Welcome(name);
                            fendCheck = true;
                            break;
                        }
                    }
                    if (fendCheck == false) {
                        JOptionPane.showMessageDialog(null, "Login Unsuccessful");

                    }

                    sc.close();

                } catch (Exception e1) {
                    System.out.println(e1);
                }

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
        frame.setLayout(new GridLayout(3, 2));
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }

}
