package edu.pjatk.s19701.view;

import javax.swing.*;

public class PetRecord {

    public JPanel mainPetRecord;
    private JList<JButton> patientInformation;
    private JButton searchButton;
    private JButton addVisitButton;
    private JButton backButton;
    private JComboBox comboBox1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("PetRecord");
        frame.setContentPane(new PetRecord().mainPetRecord);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
