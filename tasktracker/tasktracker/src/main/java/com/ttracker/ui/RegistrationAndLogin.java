package com.ttracker.ui;

import javax.swing.*;

import com.ttracker.dao.UserDAO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationAndLogin extends JFrame {

    private static final String LOGIN_PANEL = "Login Panel";
    private static final String REGISTRATION_PANEL = "Registration Panel";
    private JPanel cardPanel;
    private CardLayout cardLayout;

    private JTextField loginUsernameField;
    private JPasswordField loginPasswordField;
    private JTextField registerFirstNameField;
    private JTextField registerEmailField;
    private JPasswordField registerPasswordField;

    public RegistrationAndLogin() {
        setTitle("User Authentication");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Create the login panel and add it to the card layout
        JPanel loginPanel = createLoginPanel();
        cardPanel.add(loginPanel, LOGIN_PANEL);

        // Create the registration panel and add it to the card layout
        JPanel registrationPanel = createRegistrationPanel();
        cardPanel.add(registrationPanel, REGISTRATION_PANEL);

        add(cardPanel);

        // Initially show the login panel
        cardLayout.show(cardPanel, LOGIN_PANEL);
    }

    private JPanel createLoginPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Username components
        panel.add(new JLabel("Email:"));
        loginUsernameField = new JTextField(20);
        panel.add(loginUsernameField);

        // Password components
        panel.add(new JLabel("Password:"));
        loginPasswordField = new JPasswordField(20);
        panel.add(loginPasswordField);

        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Go to Register");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user_email = loginUsernameField.getText();
                String password = new String(loginPasswordField.getPassword());
                
                // Check if user exists and credentials are correct
                boolean loginSuccessful = false;
                loginSuccessful = UserDAO.LoginDAO(user_email,password);

                if (loginSuccessful) {
                    JOptionPane.showMessageDialog(RegistrationAndLogin.this, "Login successful!");
                    
                    // Close the current window and open the MainFrame
                    dispose(); // Close this JFrame
                    
                    SwingUtilities.invokeLater(() -> {
                        MainMenu.main(new String[]{});
                    });
                } else {
                    JOptionPane.showMessageDialog(RegistrationAndLogin.this, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, REGISTRATION_PANEL);
            }
        });

        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);

        panel.add(buttonPanel);
        return panel;
    }

    //=============================ReGistration Form========================================

    private JPanel createRegistrationPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // First Name components
        panel.add(new JLabel("First Name:"));
        registerFirstNameField = new JTextField(20);
        panel.add(registerFirstNameField);

        panel.add(new JLabel("Email:"));
        registerEmailField = new JTextField(20);
        panel.add(registerEmailField);

        // Password components
        panel.add(new JLabel("Password:"));
        registerPasswordField = new JPasswordField(20);
        panel.add(registerPasswordField);

        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        JButton registerButton = new JButton("Register");
        JButton loginButton = new JButton("Go to Login");

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String first_name = registerFirstNameField.getText();
                String email = registerEmailField.getText();
                String password = new String(registerPasswordField.getPassword());
                
                if (first_name.isEmpty() || password.isEmpty() || email.isEmpty()) {
                    JOptionPane.showMessageDialog(RegistrationAndLogin.this, "Username and password cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                else{
                    UserDAO.addUserDAO(first_name, email, password);

                    JOptionPane.showMessageDialog(RegistrationAndLogin.this, "Registration successful!");

                    dispose(); // Close this JFrame
                    
                    SwingUtilities.invokeLater(() -> {
                        MainMenu.main(new String[]{});
                    });
                }
                // Clear fields and switch to login panel
                registerFirstNameField.setText("");
                registerEmailField.setText("");
                registerPasswordField.setText("");
                cardLayout.show(cardPanel, LOGIN_PANEL);
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, LOGIN_PANEL);
            }
        });

        buttonPanel.add(registerButton);
        buttonPanel.add(loginButton);

        panel.add(buttonPanel);
        return panel;
    }

    public static void main(String[] args) {
        // Ensure GUI is created on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            new RegistrationAndLogin().setVisible(true);
        });
    }
}
