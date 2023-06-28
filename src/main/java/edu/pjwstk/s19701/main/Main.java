package edu.pjwstk.s19701.main;

import edu.pjwstk.s19701.controller.DataManager;
import edu.pjwstk.s19701.view.MainWindow;
import edu.pjwstk.s19701.view.Window;

public class Main {
    public static void main(String[] args) {

         // Utility section for demo purposes.
        DataManager dataManager = new DataManager();
        dataManager.initDataSet();

        Window window = new MainWindow();
        window.display();

    }
}