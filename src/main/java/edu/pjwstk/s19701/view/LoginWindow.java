package edu.pjwstk.s19701.view;


import edu.pjwstk.s19701.controller.LoginController;
import edu.pjwstk.s19701.main.Main;

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
        loginButton.addActionListener(event -> {
            LoginController loginController = new LoginController();

            if(loginController.loginEmployee(usernameField.getText(), String.valueOf(passwordField.getPassword()))) {
                JFrame frame = new JFrame("SearchForPet");
                frame.show();
                dispose();
                return;
            }

            if(loginController.loginOwner(usernameField.getText(), String.valueOf(passwordField.getPassword()))) {
                JOptionPane.showMessageDialog(loginButton, "Logged as Pet Owner: " + usernameField.getText());
                return;
            }

            JOptionPane.showMessageDialog(loginButton, "Bad credentials");
        });

    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
