package src;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransactionSystemUI {
    private JFrame mainFrame;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private Treasurer treasurer;
    private Student student;

    // Login Screen
    private void createLoginScreen() {
        JPanel loginPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        JLabel titleLabel = new JLabel("Transaction Management System");
        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField(15);
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(15);
        JButton loginButton = new JButton("Login");
        JComboBox<String> roleComboBox = new JComboBox<>(new String[]{"Treasurer", "Student"});

        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        loginPanel.add(titleLabel, gbc);

        gbc.gridy = 1;
        gbc.gridwidth = 1;
        loginPanel.add(usernameLabel, gbc);
        gbc.gridx = 1;
        loginPanel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        loginPanel.add(passwordLabel, gbc);
        gbc.gridx = 1;
        loginPanel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        loginPanel.add(roleComboBox, gbc);

        gbc.gridy = 4;
        loginPanel.add(loginButton, gbc);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String role = (String) roleComboBox.getSelectedItem();

                // Simulated authentication (replace with actual authentication logic)
                if ("treasurer".equals(username.toLowerCase()) && "treasurer".equals(password) && "Treasurer".equals(role)) {
                    treasurer = new Treasurer("Treasurer Name", 1, username, password);
                    cardLayout.show(mainPanel, "TreasurerDashboard");
                } else if ("student".equals(username.toLowerCase()) && "student".equals(password) && "Student".equals(role)) {
                    student = new Student("Student Name", 2, username, password);
                    cardLayout.show(mainPanel, "StudentDashboard");
                } else {
                    JOptionPane.showMessageDialog(mainFrame, "Invalid credentials", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        mainPanel.add(loginPanel, "LoginScreen");
    }

    // Treasurer Dashboard
    private void createTreasurerDashboard() {
        JPanel treasurerPanel = new JPanel(new BorderLayout());
        
        JButton addTransactionButton = new JButton("Add Transaction");
        JButton viewTransactionsButton = new JButton("View Transactions");
        JButton checkCashButton = new JButton("Check Total Cash");
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addTransactionButton);
        buttonPanel.add(viewTransactionsButton);
        buttonPanel.add(checkCashButton);
        
        treasurerPanel.add(buttonPanel, BorderLayout.NORTH);
        
        // Transaction Adding Dialog
        addTransactionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField idField = new JTextField(10);
                JTextField nominalField = new JTextField(10);
                JTextField descriptionField = new JTextField(20);
                
                JPanel inputPanel = new JPanel(new GridLayout(3, 2));
                inputPanel.add(new JLabel("Transaction ID:"));
                inputPanel.add(idField);
                inputPanel.add(new JLabel("Nominal:"));
                inputPanel.add(nominalField);
                inputPanel.add(new JLabel("Description:"));
                inputPanel.add(descriptionField);
                
                int result = JOptionPane.showConfirmDialog(null, inputPanel, 
                    "Add Transaction", JOptionPane.OK_CANCEL_OPTION);
                
                if (result == JOptionPane.OK_OPTION) {
                    try {
                        int id = Integer.parseInt(idField.getText());
                        int nominal = Integer.parseInt(nominalField.getText());
                        String description = descriptionField.getText();
                        
                        treasurer.takingCashNotes(id, nominal, description);
                        JOptionPane.showMessageDialog(null, "Transaction Added Successfully");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        
        // View Transactions Dialog
        viewTransactionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String transactions = treasurer.viewAllTransactions();
                JTextArea textArea = new JTextArea(transactions);
                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new Dimension(400, 300));
                
                JOptionPane.showMessageDialog(null, scrollPane, "All Transactions", JOptionPane.PLAIN_MESSAGE);
            }
        });
        
        // Check Total Cash
        checkCashButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String totalCash = treasurer.checkTotalCash();
                JOptionPane.showMessageDialog(null, totalCash, "Total Cash", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        mainPanel.add(treasurerPanel, "TreasurerDashboard");
    }

    // Student Dashboard
    private void createStudentDashboard() {
        JPanel studentPanel = new JPanel(new BorderLayout());
        
        JButton viewTransactionButton = new JButton("View Transaction by ID");
        JButton viewAccountButton = new JButton("View Account Details");
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(viewTransactionButton);
        buttonPanel.add(viewAccountButton);
        
        studentPanel.add(buttonPanel, BorderLayout.NORTH);
        
        // View Transaction by ID
        viewTransactionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idString = JOptionPane.showInputDialog("Enter Transaction ID:");
                try {
                    int id = Integer.parseInt(idString);
                    // Assume you have a method to get HistoryTransaction
                    HistoryTransaction historyTransaction = new HistoryTransaction();
                    student.viewHistoryTransaction(historyTransaction, id);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid ID", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        // View Account Details
        viewAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Account account = student.getAccount();
                String details = "Username: " + account.getName();
                JOptionPane.showMessageDialog(null, details, "Account Details", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        mainPanel.add(studentPanel, "StudentDashboard");
    }

    // Main Application Setup
    public TransactionSystemUI() {
        mainFrame = new JFrame("Transaction Management System");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(500, 400);
        
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        
        createLoginScreen();
        createTreasurerDashboard();
        createStudentDashboard();
        
        mainFrame.add(mainPanel);
        cardLayout.show(mainPanel, "LoginScreen");
    }

    public void show() {
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TransactionSystemUI().show();
            }
        });
    }
}