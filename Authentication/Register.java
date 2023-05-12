import java.util.Scanner;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Register extends JFrame {
    String First_Name;
    String Last_Name;
    String username;
    String password;
    String number;
    String Email;

    Register() {
        JFrame frame = new JFrame("Register");

        JLabel label1 = new JLabel("First_Name");
        JLabel label2 = new JLabel("Last_Name");
        JLabel label3 = new JLabel("Username");
        JLabel label4 = new JLabel("Password");
        JLabel label5 = new JLabel("number");
        JLabel label6 = new JLabel("Email");
        JTextField text1 = new JTextField();
        JTextField text2 = new JTextField();
        JTextField text3 = new JTextField();
        JTextField text4 = new JPasswordField();
        JTextField text5 = new JTextField();
        JTextField text6 = new JTextField();

        JButton button1 = new JButton("Register");
        JButton button2 = new JButton("Login");

        frame.add(label1);
        frame.add(text1);
        frame.add(label2);

        frame.add(text2);
        frame.add(label3);
        frame.add(text3);
        frame.add(label4);
        frame.add(text4);
        frame.add(label5);
        frame.add(text5);
        frame.add(label6);
        frame.add(text6);
        frame.add(button1);
        frame.add(button2);

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                First_Name = text1.getText();
                First_Name = First_Name.trim();
                Last_Name = text2.getText();
                Last_Name = Last_Name.trim();
                username = text3.getText();
                username = username.trim();
                password = text4.getText();
                password = password.trim();
                number = text5.getText();
                number = number.trim();
                Email = text6.getText();
                Email = Email.trim();

                try {
                    FileWriter fw = new FileWriter("user.txt", true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(username + " " + password + " " + First_Name + " " + Last_Name + " " + number + " "
                            + Email);
                    bw.newLine();
                    bw.close();
                    fw.close();
                    if (First_Name.isEmpty() || Last_Name.isEmpty() || username.isEmpty() || password.isEmpty()
                            || number.isEmpty() || Email.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please Fill all the details.", "Error",
                                JOptionPane.ERROR_MESSAGE);

                    } else if (number.length() != 10) {
                        JOptionPane.showMessageDialog(null, "Number should be of ten digits");
                    }

                    else
                        JOptionPane.showMessageDialog(frame, "Registration Successful");

                    Scanner sc = new Scanner(new File("user.txt"));

                } catch (Exception e1) {
                    System.out.println(e1);
                }
            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Login();
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 300, 500, 400);
        frame.setLayout(new GridLayout(8, 3));
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Register();
    }

}
