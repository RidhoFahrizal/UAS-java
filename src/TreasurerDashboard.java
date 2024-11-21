package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TreasurerDashboard extends JFrame {
    private Treasurer treasurer;

    public TreasurerDashboard(Treasurer treasurer) {
        this.treasurer = treasurer;

        setTitle("Treasurer Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton addTransactionButton = new JButton("Add Transaction");
        JButton viewAllTransactionsButton = new JButton("View All Transactions");
        JButton viewTransactionByIdButton = new JButton("View Transaction by ID");
        JButton checkTotalCashButton = new JButton("Check Total Cash");

        panel.add(addTransactionButton);
        panel.add(viewAllTransactionsButton);
        panel.add(viewTransactionByIdButton);
        panel.add(checkTotalCashButton);

        add(panel);

        addTransactionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idStr = JOptionPane.showInputDialog("Enter Transaction ID:");
                String nominalStr = JOptionPane.showInputDialog("Enter Nominal:");
                String description = JOptionPane.showInputDialog("Enter Description:");

                if (idStr != null && nominalStr != null && description != null) {
                    int id = Integer.parseInt(idStr);
                    int nominal = Integer.parseInt(nominalStr);
                    treasurer.takingCashNotes(id, nominal, description);
                    JOptionPane.showMessageDialog(null, "Transaction added successfully!");
                }
            }
        });

        viewAllTransactionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, treasurer.viewAllTransactions());
            }
        });

        viewTransactionByIdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idStr = JOptionPane.showInputDialog("Enter Transaction ID:");
                if (idStr != null) {
                    int id = Integer.parseInt(idStr);
                    treasurer.viewTransactionByIdString(id);
                }
            }
        });

        checkTotalCashButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, treasurer.checkTotalCash());
            }
        });
    }
}
