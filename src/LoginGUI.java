package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel statusLabel;

    // Daftar akun
private static final Account[] accounts = {
    new Account("treasurer", "1234"),
    new Account("student", "1234")
};


    public LoginGUI() {
        setTitle("Login - CashBook App");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel utama
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));

        // Komponen login
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");
        statusLabel = new JLabel("", SwingConstants.CENTER);

        // Tambahkan komponen ke panel
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel()); // Spacer
        panel.add(loginButton);
        panel.add(statusLabel);

        add(panel);

        // Action listener untuk tombol login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                handleLogin(username, password);
            }
        });
    }

    // Metode untuk menangani login
    private void handleLogin(String username, String password) {
        for (Account account : accounts) {
            if (account.getName().equals(username) && account.getPassword().equals(password)) {
                if (username.equals("treasurer")) {
                    new DashboardGUI(true).setVisible(true);
                } else {
                    new DashboardGUI(false).setVisible(true);
                }
                this.dispose();
                return;
            }
        }
        statusLabel.setText("Invalid credentials. Try again.");
        statusLabel.setForeground(Color.RED);
    }
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginGUI().setVisible(true));
    }
}
