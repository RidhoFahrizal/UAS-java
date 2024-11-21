package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    private Treasurer treasurer;
    private Student student;

    public LoginGUI(Treasurer treasurer, Student student) {
        this.treasurer = treasurer;
        this.student = student;

        setTitle("Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel());
        panel.add(loginButton);

        add(panel);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
    }

    private void login() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (username.equals(treasurer.getAccount().getName()) &&
            password.equals(treasurer.getAccount().getPassword())) {
            JOptionPane.showMessageDialog(this, "Welcome Treasurer!");
            new TreasurerDashboard(treasurer).setVisible(true);
            dispose();
        } else if (username.equals(student.getAccount().getName()) &&
                   password.equals(student.getAccount().getPassword())) {
            JOptionPane.showMessageDialog(this, "Welcome Student!");
            new StudentDashboard(student, treasurer).setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid credentials. Please try again.");
        }
    }

    public static void main(String[] args) {
        Treasurer treasurer = new Treasurer("John Treasurer", 1, "treasurer123", "password123");
        Student student = new Student("Jane Student", 2, "student123", "password123");

        new LoginGUI(treasurer, student).setVisible(true);
    }
}
