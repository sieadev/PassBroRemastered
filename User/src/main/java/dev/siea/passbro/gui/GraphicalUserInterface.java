package dev.siea.passbro.gui;

import javax.swing.*;

import com.formdev.flatlaf.FlatDarkLaf;
import dev.siea.passbro.PassBro;
import dev.siea.passbro.database.AccountDatabase;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicalUserInterface {
    private JTabbedPane tabbedPane;
    private JFrame mainFrame;
    public GraphicalUserInterface(PassBro main){
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
        mainFrame.setMinimumSize(new Dimension(450, 200));
        mainFrame.setVisible(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1200, 800);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setTitle("Passbro - Welcome!");

        // Create tabs
        tabbedPane = new JTabbedPane();

        // Add tabs to the tabbedPane
        addTab("Passwords", createPasswordPanel());
        addTab("Notes", createNotesPanel());
        addTab("Contacts", createContactsPanel());
        addTab("Generator", createGeneratorPanel());
        addTab("Account", createAccountPanel());

        mainFrame.add(tabbedPane, BorderLayout.CENTER);

        mainFrame.setResizable(true);
        mainFrame.setVisible(true);
    }

    private JPanel createPasswordPanel() {
        JPanel passwordPanel = new JPanel();
        passwordPanel.add(new JLabel("Password Tab Content"));
        return passwordPanel;
    }

    private JPanel createNotesPanel() {
        JPanel notesPanel = new JPanel();
        notesPanel.add(new JLabel("Notes Tab Content"));
        return notesPanel;
    }

    private JPanel createContactsPanel() {
        JPanel contactsPanel = new JPanel();
        contactsPanel.add(new JLabel("Contacts Tab Content"));
        return contactsPanel;
    }

    private JPanel createGeneratorPanel() {
        JPanel generatorPanel = new JPanel();
        generatorPanel.add(new JLabel("Generator Tab Content"));
        return generatorPanel;
    }

    private JPanel createAccountPanel() {
        JPanel accountPanel = new JPanel();
        accountPanel.add(new JLabel("Account Tab Content"));
        return accountPanel;
    }

    private void addTab(String title, JPanel panel) {
        tabbedPane.addTab(title, panel);
        int index = tabbedPane.indexOfTab(title);

        JPanel tabPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));

        JButton tabButton = new JButton(title);
        tabButton.setFocusable(false);
        tabButton.setBorderPainted(true);
        tabButton.setFocusPainted(true);
        tabButton.setContentAreaFilled(false);

        // Set the tab layout policy to make tabs stretch to fill the available space
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

        // Set the tab placement to LEFT
        tabbedPane.setTabPlacement(JTabbedPane.LEFT);

        tabButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setSelectedIndex(index);
            }
        });

        tabPanel.add(tabButton);
        tabbedPane.setTabComponentAt(index, tabPanel);
    }

    private void clearFrame() {
        mainFrame.getContentPane().removeAll();
    }

    public void close() {
        mainFrame.dispose();
    }
}
