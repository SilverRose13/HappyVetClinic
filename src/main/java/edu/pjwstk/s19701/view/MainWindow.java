package edu.pjwstk.s19701.view;

import javax.swing.*;

public class MainWindow implements Window {

    public void display() {
        JFrame frame = new JFrame("My First GUI");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        JButton button = new JButton("Press");
        frame.getContentPane().add(button); // Adds Button to content pane of frame
        frame.setVisible(true);
    }


}
