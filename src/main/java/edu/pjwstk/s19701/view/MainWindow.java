package edu.pjwstk.s19701.view;

import javax.swing.*;

import static edu.pjwstk.s19701.main.Main.APPLICATION_NAME;

public class MainWindow implements Window {

    public void display() {
        JFrame frame = new JFrame(APPLICATION_NAME);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        JButton button = new JButton("Press");
        frame.getContentPane().add(button); // Adds Button to content pane of frame
        frame.setVisible(true);
    }


}
