package edu.pjatk.s19701.view;

import edu.pjatk.s19701.main.Main;
import edu.pjatk.s19701.model.pet.Pet;

import javax.swing.*;

import static edu.pjatk.s19701.view.Search.searchFrame;

public class PetRecord {
    private Pet pet;
    public JPanel mainPetRecord;
    private JList<JButton> patientInformation;
    private JButton searchButton;
    private JButton addVisitButton;
    private JButton backButton;
    private JComboBox comboBox1;
    private JPanel PatientInformatioJPanel;
    private JPanel SearchForVisit;
    private JPanel SaveAndAddVisitButtons;
    private JLabel AppName;
    private JPanel MedicalInformation;
    private JFormattedTextField PatientName;
    private JFormattedTextField Breed;
    private JFormattedTextField OwnersName;
    private JFormattedTextField Age;
    static JFrame petRecordFrame = new JFrame(Main.APPLICATION_NAME);

    public PetRecord(Pet pet){
        searchFrame.dispose();

        this.pet = pet;

        PatientName.setValue(pet.getName());
        Breed.setValue(pet.getBreed());
        Age.setValue(pet.getAge());

        backButton.addActionListener(event -> {
            searchFrame.setContentPane(new Search().mainSearchForPet);
            searchFrame.setVisible(true);
            searchFrame.setSize(Main.INIT_WIDTH, Main.INIT_HEIGHT);
            searchFrame.setIconImage(Main.frame.getIconImage());
            Search.freshPetRecordFrame.dispose();
        });
    }

    public static void main(String[] args) {
        JPanel petRecordPanel = new PetRecord(new Pet()).mainPetRecord;
        petRecordFrame.setContentPane(petRecordPanel);
        petRecordFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        petRecordFrame.pack();
        petRecordFrame.setVisible(true);
    }
}
