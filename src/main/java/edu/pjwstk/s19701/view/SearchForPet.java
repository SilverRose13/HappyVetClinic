package edu.pjwstk.s19701.view;

import edu.pjwstk.s19701.controller.SearchByChipCotroller;
import edu.pjwstk.s19701.main.Main;

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
    private JPanel SearchByChipPanel;
    private JPanel SearchByOwner;
    private JPanel searchByOwnerPanel;

    public SearchForPet(){
        searchByChipButton.addActionListener(event -> {
            SearchByChipCotroller searchByChipCotroller = new SearchByChipCotroller();

            if(searchByChipCotroller.findPetByChip(chipNumberTextField.getText()) != null){
                JFrame frame = new JFrame("PetRecord");
                frame.setContentPane(new PetRecord().mainPetRecord);
                frame.setVisible(true);

                frame.setSize(Main.INIT_WIDTH, Main.INIT_HEIGHT);
                Main.frame.dispose();
                return;
            }

            JOptionPane.showMessageDialog(searchByChipButton, "Chip number not found");

        });

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("SearchForPet");
        frame.setContentPane(new SearchForPet().mainSearchForPet);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
