package src;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage {

    public void showLoginPage() {
        JFrame frame = new JFrame("Login Page");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(30, 30, 80, 25);
        frame.add(userLabel);

        JTextField userText = new JTextField();
        userText.setBounds(120, 30, 165, 25);
        frame.add(userText);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(30, 70, 80, 25);
        frame.add(passLabel);

        JPasswordField passText = new JPasswordField();
        passText.setBounds(120, 70, 165, 25);
        frame.add(passText);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(120, 110, 80, 25);
        frame.add(loginButton);

        JLabel messageLabel = new JLabel("");
        messageLabel.setBounds(30, 140, 300, 25);
        messageLabel.setForeground(Color.RED);
        frame.add(messageLabel);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passText.getPassword());

                if (username.equals("admin") && password.equals("12345")) {
                    JOptionPane.showMessageDialog(frame, "Login Berhasil!");
                } else {
                    messageLabel.setText("Username atau Password salah!");
                }
            }
        });
        
        frame.setVisible(true);
    }
}
