package edu.pjatk.s19701.view;


import edu.pjatk.s19701.controller.LoginController;
import edu.pjatk.s19701.main.Main;

import javax.swing.*;
import java.awt.*;

public class LoginWindow extends JFrame {
    JPanel mainPanel;
    JTextField usernameField;
    JButton loginButton;

    @SuppressWarnings("unused")
    JLabel passwordLabel;
    JLabel usernameLabel;
    JPasswordField passwordField;
    static JFrame searchFrame = new JFrame(Main.APPLICATION_NAME);


    public LoginWindow() {

        loginButton.setBorderPainted(false);

        loginButton.addActionListener(event -> {
            LoginController loginController = new LoginController();

            if(loginController.loginEmployee(usernameField.getText(), String.valueOf(passwordField.getPassword()))) {
                searchFrame.setContentPane(new Search().mainSearchForPet);
                searchFrame.setVisible(true);
                searchFrame.setSize(Main.INIT_WIDTH, Main.INIT_HEIGHT);
                searchFrame.setIconImage(Main.frame.getIconImage());
                Main.frame.dispose();
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
