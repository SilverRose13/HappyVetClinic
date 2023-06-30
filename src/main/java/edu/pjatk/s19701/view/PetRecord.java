package edu.pjatk.s19701.view;

import edu.pjatk.s19701.main.Main;
import edu.pjatk.s19701.model.Visit;
import edu.pjatk.s19701.model.pet.Pet;

import javax.swing.*;
import java.util.List;

import static edu.pjatk.s19701.view.Search.searchFrame;

public class PetRecord {
    private Pet pet;
    public JPanel mainPetRecord;
    public JList<String> patientInformation;
    private JButton searchButton;
    private JButton addVisitButton;
    private BackButton backButton;
    private JComboBox<String> visitDataFields;
    private JPanel PatientInformatioJPanel;
    private JPanel SearchForVisit;
    private JPanel MedicalInformation;
    private JFormattedTextField PatientName;
    private JFormattedTextField Breed;
    private JFormattedTextField OwnersName;
    private JFormattedTextField Age;
    private JPanel BottomRow;
    private JScrollPane MedicalHistory;
    static JFrame petRecordFrame = new JFrame(Main.APPLICATION_NAME);

    static JFrame viewDetails = new JFrame(Main.APPLICATION_NAME);


    public PetRecord(Pet pet){
        searchFrame.dispose();

        this.pet = pet;

        List<Visit> visits = pet.getVisits().stream().toList();

        //prepares the items to be listed in the medical history
        String[] visitsHistory = new String[visits.size()];
        String[] visitsDates = new String[visits.size()];
        for(int i=0; i<visits.size(); i++){
            visitsHistory[i] = visits.get(i).toString();
            visitsDates[i] = visits.get(i).getDateTime().toLocalDate().toString();
        }

        //list of medical history
        patientInformation.setListData(visitsHistory);
        //if an item is selected we see the visit details in a pop-up
        patientInformation.addListSelectionListener(listener -> JOptionPane.showMessageDialog(patientInformation, patientInformation.getSelectedValue()));

        //populating patient information data fields
        PatientName.setValue(pet.getName());
        Breed.setValue(pet.getBreed());
        Age.setValue(pet.getAge());
        OwnersName.setValue(pet.getOwner().getFullName());

        //button to return to the Search screen
        backButton.addActionListener(event -> {
            searchFrame.setContentPane(new Search().mainSearchForPet);
            searchFrame.setVisible(true);
            searchFrame.setSize(Main.INIT_WIDTH, Main.INIT_HEIGHT);
            searchFrame.setIconImage(Main.frame.getIconImage());
            Search.freshPetRecordFrame.dispose();
        });


        visitDataFields.setModel(new DefaultComboBoxModel(visitsDates));

        //searches for the visit selected by date
        searchButton.addActionListener(event -> {
            visitDataFields.getEditor().getItem();

            visits.forEach(visit -> {
                //searches for the visit with the date chosen
                if(datesAreEq(visit)) {
                    //opens a VisitDetails screen
                    viewDetails.setContentPane(new VisitDetails(visit, pet).mainPanel);
                    viewDetails.setVisible(true);
                    viewDetails.setSize(Main.INIT_WIDTH, Main.INIT_HEIGHT);
                    viewDetails.setIconImage(Main.frame.getIconImage());
                    Search.freshPetRecordFrame.dispose();
                }
            });

        });
    }

    private boolean datesAreEq(Visit v) {
        //naive check. can be done better
        return v.getDateTime().toLocalDate().toString().equalsIgnoreCase(visitDataFields.getSelectedItem().toString());
    }

    //for testing screen
    public static void main(String[] args) {
        JPanel petRecordPanel = new PetRecord(new Pet()).mainPetRecord;
        petRecordFrame.setContentPane(petRecordPanel);
        petRecordFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        petRecordFrame.pack();
        petRecordFrame.setVisible(true);
    }
}
