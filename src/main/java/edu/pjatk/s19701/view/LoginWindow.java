package edu.pjatk.s19701.view;


import edu.pjatk.s19701.controller.LoginController;
import edu.pjatk.s19701.main.Main;

import javax.swing.*;

public class LoginWindow extends JFrame {
    JPanel mainPanel;
    JTextField usernameField;
    JButton loginButton;
    JLabel appName;

    @SuppressWarnings("unused")
    JLabel passwordLabel;
    JLabel usernameLabel;
    JPasswordField passwordField;

    public LoginWindow() {
        loginButton.addActionListener(event -> {
            LoginController loginController = new LoginController();

            if(loginController.loginEmployee(usernameField.getText(), String.valueOf(passwordField.getPassword()))) {
                JFrame frame = new JFrame(Main.APPLICATION_NAME);
                frame.setContentPane(new SearchForPet().mainSearchForPet);
                frame.setVisible(true);

                frame.setSize(Main.INIT_WIDTH, Main.INIT_HEIGHT);
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
