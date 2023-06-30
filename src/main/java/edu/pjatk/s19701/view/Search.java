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
        //if we are coming back from the PetRecord page, we need to discard it
        petRecordFrame.dispose();
        //searching for the input chip
        searchByChipButton.addActionListener(event -> {
            SearchByChipController searchByChipController = new SearchByChipController();
            //searching for a record of a pet with the provided chip number
            Pet pet = searchByChipController.findPetByChip(chipNumberTextField.getText());

            //if the chip number is found, a new PetRecord screen is opened
            if(pet != null){
                //the found chip number is passed to the PetRecord instance
                    // so that it can be used to populate the fields containing information about the Pet
                freshPetRecordFrame.setContentPane(new PetRecord(pet).mainPetRecord);
                freshPetRecordFrame.setVisible(true);
                freshPetRecordFrame.setSize(Main.INIT_WIDTH, Main.INIT_HEIGHT);
                freshPetRecordFrame.setIconImage(Main.frame.getIconImage());
                LoginWindow.searchFrame.dispose();
                return;
            }

            //if no record of Pet with the provided chip number is found
                // a pop-up informs the user that an invalid chip number was provided
            JOptionPane.showMessageDialog(searchByChipButton, "Chip number not found");
        });
    }

    //main for testing the screen without going through the login process every time
    public static void main(String[] args) {
        JPanel searchJPanel = new Search().mainSearchForPet;
        searchFrame.setContentPane(searchJPanel);
        searchFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        searchFrame.pack();
        searchFrame.setVisible(true);
        petRecordFrame.dispose();
    }

}
