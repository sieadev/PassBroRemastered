package dev.siea.passbro.gui;

import javax.swing.*;
import com.formdev.flatlaf.FlatDarkLaf;
import dev.siea.passbro.PassBro;
import dev.siea.passbro.database.AccountDatabase;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicalUserInterface {
    private final PassBro main;
    private JFrame mainFrame;
    private JProgressBar loadingBar;
    public GraphicalUserInterface(PassBro main){
        this.main = main;
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        initializeLoginWindow();
    }


    private void initializeLoginWindow() {
        mainFrame = new JFrame("PassBro");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel loginPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel usernameLabel = new JLabel("Username:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        loginPanel.add(usernameLabel, gbc);

        JTextField usernameField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        loginPanel.add(usernameField, gbc);

        JLabel passwordLabel = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        loginPanel.add(passwordLabel, gbc);

        JPasswordField passwordField = new JPasswordField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        loginPanel.add(passwordField, gbc);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (AccountDatabase.isValid(usernameField.getText(), passwordField.getPassword())){
                    initializeMainWindow();
                };
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 2;
        loginPanel.add(loginButton, gbc);

        mainFrame.getContentPane().add(loginPanel, BorderLayout.CENTER);
        mainFrame.setSize(340, 150);
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }


    private void initializeMainWindow() {
        clearFrame();
        mainFrame.setVisible(false);
        mainFrame.setResizable(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1200, 800);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setTitle("Passbro - Welcome!");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    private void clearFrame(){
        for (Component component : mainFrame.getComponents()){
            mainFrame.remove(component);
        }
    }

    public void close() {
        mainFrame.dispose();
    }

}
