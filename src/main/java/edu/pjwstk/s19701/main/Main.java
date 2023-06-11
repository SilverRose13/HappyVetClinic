package edu.pjwstk.s19701.main;

import edu.pjwstk.s19701.controller.DataManager;
import edu.pjwstk.s19701.view.LoginWindow;
import edu.pjwstk.s19701.view.SearchForPet;

import javax.swing.*;

/**
 * Run project here.
 */
public class Main {
    public static final String APPLICATION_NAME = "Happy Vet Clinic";

    private static final int INIT_WIDTH = 640;
    private static final int INIT_HEIGHT = 480;

    public static void main(String[] args) {

         // Utility section for demo purposes.
        DataManager dataManager = new DataManager();
        dataManager.initDataSet();

        runGUI();
    }

    private static void runGUI() {
        JFrame frame = new JFrame("LoginWindow");
//        frame.setContentPane(new LoginWindow().getMainPanel());
        frame.setContentPane(new SearchForPet().mainSearchForPet);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        frame.setSize(INIT_WIDTH, INIT_HEIGHT);
    }
}