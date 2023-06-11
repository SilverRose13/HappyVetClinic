package edu.pjwstk.s19701.view;

import javax.swing.*;

public class SearchForPet {
    private JButton searchByChipButton;
    private JTextField nameTextField;
    private JTextField surnameTextField;
    private JButton searchByOwnerButton;
    private JLabel searchByChipLabel;
    private JTextField chipNumberTextField;
    private JLabel searchByOwnerLabel;
    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JLabel searchForPetLabel;
    public JPanel mainSearchForPet;
    private JPanel SearchByChip;
    private JPanel SearchByOwner;
    private JPanel searchByOwnerPanel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("SearchForPet");
        frame.setContentPane(new SearchForPet().mainSearchForPet);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
