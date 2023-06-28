package edu.pjatk.s19701.view;

import edu.pjatk.s19701.controller.SearchByChipController;
import edu.pjatk.s19701.model.pet.Pet;
import edu.pjatk.s19701.main.Main;

import javax.swing.*;

import static edu.pjatk.s19701.view.PetRecord.petRecordFrame;

public class Search {
    private JButton searchByChipButton;
    private JTextField nameTextField;
    private JTextField surnameTextField;
    private JButton searchByOwnerButton;
    private JTextField chipNumberTextField;
    private JLabel nameLabel;
    private JLabel surnameLabel;
    public JPanel mainSearchForPet;
    private JPanel SearchByChipPanel;
    private JPanel SearchByOwner;
    private JPanel searchByOwnerPanel;
    public static JFrame searchFrame = new JFrame("Search");
    static JFrame freshPetRecordFrame = new JFrame(Main.APPLICATION_NAME);

    public Search(){
        petRecordFrame.dispose();
        searchByChipButton.addActionListener(event -> {
            SearchByChipController searchByChipController = new SearchByChipController();
            Pet pet = searchByChipController.findPetByChip(chipNumberTextField.getText());

            if(pet != null){
                freshPetRecordFrame.setContentPane(new PetRecord(pet).mainPetRecord);
                freshPetRecordFrame.setVisible(true);
                freshPetRecordFrame.setSize(Main.INIT_WIDTH, Main.INIT_HEIGHT);
                freshPetRecordFrame.setIconImage(Main.frame.getIconImage());
                LoginWindow.searchFrame.dispose();
                return;
            }

            JOptionPane.showMessageDialog(searchByChipButton, "Chip number not found");
        });
    }

    public static void main(String[] args) {
        JPanel searchJPanel = new Search().mainSearchForPet;
        searchFrame.setContentPane(searchJPanel);
        searchFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        searchFrame.pack();
        searchFrame.setVisible(true);
        petRecordFrame.dispose();
    }

}
