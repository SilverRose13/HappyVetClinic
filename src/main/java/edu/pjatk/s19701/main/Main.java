package edu.pjatk.s19701.main;

import edu.pjatk.s19701.view.LoginWindow;

import javax.swing.*;

/**
 * Run project here.
 */
public class Main {
    public static final String APPLICATION_NAME = "Happy Vet Clinic";

    public static final JFrame frame = new JFrame("Login");

    public static final int INIT_WIDTH = 640;
    public static final int INIT_HEIGHT = 480;

    public static void main(String[] args) {

         // Utility section for demo purposes.
        DataManager dataManager = new DataManager();
        dataManager.initDataSet();

        runGUI();
    }

    private static void runGUI() {
        frame.setContentPane(new LoginWindow().getMainPanel());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(INIT_WIDTH, INIT_HEIGHT);
    }
}