package src;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginFrame() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel utama
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Username Label dan Field
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(10, 20, 80, 25);
        panel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(100, 20, 165, 25);
        panel.add(usernameField);

        // Password Label dan Field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(100, 50, 165, 25);
        panel.add(passwordField);

        // Login Button
        loginButton = new JButton("Login");
        loginButton.setBounds(100, 90, 80, 25);
        panel.add(loginButton);

        // Event ketika tombol Login ditekan
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Proses login
                if (username.equals("treasurer") && password.equals("1234")) {
                    JOptionPane.showMessageDialog(null, "Login sebagai Treasurer");
                    new TreasurerDashboard().setVisible(true);
                    dispose();
                } else if (username.equals("student") && password.equals("1234")) {
                    JOptionPane.showMessageDialog(null, "Login sebagai Student");
                    new StudentDashboard().setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Username atau Password salah!");
                }
            }
        });

        add(panel);
    }

    public static void main(String[] args) {
        new LoginFrame().setVisible(true);
    }
}
