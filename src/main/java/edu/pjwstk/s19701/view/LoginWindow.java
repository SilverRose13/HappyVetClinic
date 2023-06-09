package edu.pjwstk.s19701.view;


import javax.swing.*;

public class LoginWindow extends JFrame {
    JPanel mainPanel;
    JTextField usernameField;
    JButton loginButton;
    JLabel appName;
    JLabel passwordLabel;
    JLabel usernameLabel;
    JPasswordField passwordField;

    public LoginWindow() {
        loginButton.addActionListener(event -> JOptionPane.showMessageDialog(loginButton, "Login action performed"));
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
