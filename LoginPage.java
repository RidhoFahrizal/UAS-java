import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage {

    public void showLoginPage() {
        // Membuat frame (jendela utama)
        JFrame frame = new JFrame("Login Page");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Label untuk username
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(30, 30, 80, 25);
        frame.add(userLabel);

        // Text field untuk username
        JTextField userText = new JTextField();
        userText.setBounds(120, 30, 165, 25);
        frame.add(userText);

        // Label untuk password
        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(30, 70, 80, 25);
        frame.add(passLabel);

        // Text field untuk password
        JPasswordField passText = new JPasswordField();
        passText.setBounds(120, 70, 165, 25);
        frame.add(passText);

        // Tombol login
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(120, 110, 80, 25);
        frame.add(loginButton);

        // Label untuk pesan (output)
        JLabel messageLabel = new JLabel("");
        messageLabel.setBounds(30, 140, 300, 25);
        messageLabel.setForeground(Color.RED);
        frame.add(messageLabel);

        // Aksi tombol login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passText.getPassword());

                // Verifikasi login (contoh hardcoded)
                if (username.equals("admin") && password.equals("12345")) {
                    JOptionPane.showMessageDialog(frame, "Login Berhasil!");
                } else {
                    messageLabel.setText("Username atau Password salah!");
                }
            }
        });

        // Tampilkan frame
        frame.setVisible(true);
    }
}
