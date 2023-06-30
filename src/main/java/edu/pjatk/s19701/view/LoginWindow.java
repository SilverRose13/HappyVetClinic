package edu.pjatk.s19701.view;


import edu.pjatk.s19701.controller.LoginController;
import edu.pjatk.s19701.main.Main;

import javax.swing.*;

public class LoginWindow extends JFrame {
    JPanel mainPanel;
    JTextField usernameField;
    JButton loginButton;

    JLabel passwordLabel;
    JLabel usernameLabel;
    JPasswordField passwordField;
    static JFrame searchFrame = new JFrame(Main.APPLICATION_NAME);


    public LoginWindow() {

        loginButton.setBorderPainted(false);

        loginButton.addActionListener(event -> {
            LoginController loginController = new LoginController();

            //if a unique combination of username and login exists for an Employee,
                // they are taken to the Search for pet screen
            if(loginController.loginEmployee(usernameField.getText(), String.valueOf(passwordField.getPassword()))) {
                searchFrame.setContentPane(new Search().mainSearchForPet);
                searchFrame.setVisible(true);
                searchFrame.setSize(Main.INIT_WIDTH, Main.INIT_HEIGHT);
                searchFrame.setIconImage(Main.frame.getIconImage());
                Main.frame.dispose();
                return;
            }

            //for the purpose of the chosen Use Case only the Employee login needs to be functional
            //however because an Owner would have access to different functionalities an Employee,
                //it is important to note that there is a differentiation between their login credentials/implementation
            if(loginController.loginOwner(usernameField.getText(), String.valueOf(passwordField.getPassword()))) {
                JOptionPane.showMessageDialog(loginButton, "Logged as Pet Owner: " + usernameField.getText());
                return;
            }

            //if the input credentials cannot be found a pop-up will inform the user
                // about the input of invalid credentials
            JOptionPane.showMessageDialog(loginButton, "Bad credentials");
        });

    }

    //the main panel is where all the other elements of the GUI are placed
    public JPanel getMainPanel() {
        return mainPanel;
    }

}
