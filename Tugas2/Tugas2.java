package Tugas2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Tugas2 extends JFrame {
    public Tugas2() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem resetMenuItem = new JMenuItem("Reset");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        menu.add(resetMenuItem);
        menu.add(exitMenuItem);
        menuBar.add(menu);
        this.setJMenuBar(menuBar);

        // Labels and TextFields
        JLabel nameLabel = new JLabel("Nama: ");
        JTextField nameField = new JTextField();

        JLabel phoneLabel = new JLabel("No. Telepon: ");
        JTextField phoneField = new JTextField();

        JLabel addressLabel = new JLabel("Alamat: ");
        JTextField addressField = new JTextField();

        // JList for savings account type
        JLabel savingsLabel = new JLabel("Jenis Tabungan: ");
        String[] savingsTypes = {"Tabungan A", "Tabungan B", "Tabungan C", "Tabungan D"};
        JList<String> savingsList = new JList<>(savingsTypes);
        savingsList.setVisibleRowCount(2);
        savingsList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        JScrollPane savingsScrollPane = new JScrollPane(savingsList);

        // JSlider for transaction frequency
        JLabel transactionLabel = new JLabel("Frekuensi Transaksi per Bulan: ");
        JSlider transactionFrequencySlider = new JSlider(1, 100, 1);
        transactionFrequencySlider.setPaintLabels(true);
        transactionFrequencySlider.setPaintTicks(true);
        transactionFrequencySlider.setMajorTickSpacing(9);
        JLabel transactionValueLabel = new JLabel("");
        transactionFrequencySlider.addChangeListener(e -> {
            transactionValueLabel.setText(String.valueOf(transactionFrequencySlider.getValue()));
        });

        // JPasswordField for password and confirm password
        JLabel passwordLabel = new JLabel("Password: ");
        JPasswordField passwordField = new JPasswordField();

        JLabel confirmPasswordLabel = new JLabel("Confirm Password: ");
        JPasswordField confirmPasswordField = new JPasswordField();

        // JSpinner for date of birth
        JLabel dobLabel = new JLabel("Tanggal Lahir: ");
        JSpinner dobSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dobSpinner, "dd/MM/yyyy");
        dobSpinner.setEditor(dateEditor);

        // Button and TextArea
        JButton button = new JButton("Simpan");
        JTextArea textOutput = new JTextArea(5, 20);
        textOutput.setEditable(false);
        JScrollPane textOutputScrollPane = new JScrollPane(textOutput);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String phone = phoneField.getText();
                String address = addressField.getText();
                String savingsType = savingsList.getSelectedValue();
                int transactionFrequency = transactionFrequencySlider.getValue();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());
                Date dob = (Date) dobSpinner.getValue();

                textOutput.setText("Nama: " + name + "\n");
                textOutput.append("No. Telepon: " + phone + "\n");
                textOutput.append("Alamat: " + address + "\n");
                textOutput.append("Jenis Tabungan: " + savingsType + "\n");
                textOutput.append("Frekuensi Transaksi per Bulan: " + transactionFrequency + "\n");
                textOutput.append("Tanggal Lahir: " + dateEditor.getFormat().format(dob) + "\n");
                textOutput.append("Password Match: " + password.equals(confirmPassword) + "\n");

                nameField.setText("");
                phoneField.setText("");
                addressField.setText("");
                savingsList.clearSelection();
                transactionFrequencySlider.setValue(1);
                passwordField.setText("");
                confirmPasswordField.setText("");
                dobSpinner.setValue(new Date());
            }
        });

        resetMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nameField.setText("");
                phoneField.setText("");
                addressField.setText("");
                savingsList.clearSelection();
                transactionFrequencySlider.setValue(1);
                passwordField.setText("");
                confirmPasswordField.setText("");
                dobSpinner.setValue(new Date());
                textOutput.setText("");
            }
        });

        exitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Layout
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(nameLabel)
            .addComponent(nameField)
            .addComponent(phoneLabel)
            .addComponent(phoneField)
            .addComponent(addressLabel)
            .addComponent(addressField)
            .addComponent(savingsLabel)
            .addComponent(savingsScrollPane)
            .addComponent(transactionLabel)
            .addGroup(layout.createSequentialGroup()
                .addComponent(transactionFrequencySlider)
                .addComponent(transactionValueLabel))
            .addComponent(passwordLabel)
            .addComponent(passwordField)
            .addComponent(confirmPasswordLabel)
            .addComponent(confirmPasswordField)
            .addComponent(dobLabel)
            .addComponent(dobSpinner)
            .addComponent(button)
            .addComponent(textOutputScrollPane)
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
            .addComponent(nameLabel)
            .addComponent(nameField)
            .addComponent(phoneLabel)
            .addComponent(phoneField)
            .addComponent(addressLabel)
            .addComponent(addressField)
            .addComponent(savingsLabel)
            .addComponent(savingsScrollPane)
            .addComponent(transactionLabel)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(transactionFrequencySlider)
                .addComponent(transactionValueLabel))
            .addComponent(passwordLabel)
            .addComponent(passwordField)
            .addComponent(confirmPasswordLabel)
            .addComponent(confirmPasswordField)
            .addComponent(dobLabel)
            .addComponent(dobSpinner)
            .addComponent(button)
            .addComponent(textOutputScrollPane)
        );

        this.setSize(500, 800);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Tugas2 frame = new Tugas2();
                frame.setVisible(true);
            }
        });
    }
}