package edu.pjatk.s19701.view;

import edu.pjatk.s19701.main.Main;
import edu.pjatk.s19701.model.Condition;
import edu.pjatk.s19701.model.Visit;
import edu.pjatk.s19701.model.employee.Employee;
import edu.pjatk.s19701.model.owner.Owner;
import edu.pjatk.s19701.model.pet.Pet;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static edu.pjatk.s19701.view.Search.freshPetRecordFrame;

public class VisitDetails {
    private JTextField visitDate;
    private BackButton backButton;
    public JPanel mainPanel;
    private JTextField symptoms;
    private JPanel mainVisitRecord;
    private JPanel BottomRow;
    private JPanel visitInformationJPanel;
    private JFormattedTextField supervisingEmployee;
    private JFormattedTextField patientName;
    private JButton saveButton;
    private BackButton back;
    static JFrame visitDetailsFrame = new JFrame(Main.APPLICATION_NAME);

    public VisitDetails(Visit visit, Pet pet) {
        visitDate.setText(visit.getDateTime().toLocalDate().toString());

        patientName.setText(pet.getName());
        symptoms.setText(visit.getConditions().stream().map(Condition::getSymptoms)
                .collect(Collectors.joining(",")));
        supervisingEmployee.setText(visit.getEmployee().getFullName());
        backButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                //populating the fields with information about the visit
                //uses instance of Pet found through the Search screen and passed through the PetRecord screen
                if(pet != null){
                    freshPetRecordFrame.setContentPane(new PetRecord(pet).mainPetRecord);
                    freshPetRecordFrame.setVisible(true);
                    freshPetRecordFrame.setSize(Main.INIT_WIDTH, Main.INIT_HEIGHT);
                    freshPetRecordFrame.setIconImage(Main.frame.getIconImage());
                    PetRecord.freshViewVisitFrame.dispose();
                }
            }
        });

    }
    public static void main(String[] args){

        //example data
        Pet pet1  = new Pet();
        pet1.setName("Woof");
        Visit visit = new Visit();
        Employee testEmployee = new Employee();
        visit.setEmployee(testEmployee);
        visit.setDateTime(LocalDateTime.now());
        visit.setPet(pet1);
        //visit.setConditions(new Condition<>());
        Owner owner = new Owner();

        Pet pet2 = new  Pet();
        pet2.setName("Miau");
        List<Pet> testPetList = new ArrayList<>();
        testPetList.add(pet1);
        testPetList.add(pet2);

        JPanel visitDetailsPanel = new VisitDetails(visit, pet1).mainPanel;

        visitDetailsFrame.setContentPane(visitDetailsPanel);
        visitDetailsFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        visitDetailsFrame.setSize(Main.INIT_WIDTH, Main.INIT_HEIGHT);
        visitDetailsFrame.pack();
        visitDetailsFrame.setVisible(true);
    }
}
