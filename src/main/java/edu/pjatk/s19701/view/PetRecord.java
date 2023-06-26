package edu.pjatk.s19701.view;

import edu.pjatk.s19701.model.pet.Pet;

import javax.swing.*;

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

    public PetRecord(Pet pet){
        this.pet = pet;

        PatientName.setValue(pet.getName());
        Breed.setValue(pet.getBreed());
        Age.setValue(pet.getAge());
        //OwnersName.setValue(pet.getOwner().getName());

    }

    public PetRecord(){

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("PetRecord");
        frame.setContentPane(new PetRecord().mainPetRecord);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
