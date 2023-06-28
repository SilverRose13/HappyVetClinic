package edu.pjatk.s19701.view;

import edu.pjatk.s19701.main.Main;
import edu.pjatk.s19701.model.Condition;
import edu.pjatk.s19701.model.Visit;
import edu.pjatk.s19701.model.pet.Pet;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.stream.Collectors;

import static edu.pjatk.s19701.view.Search.freshPetRecordFrame;

public class VisitDetails {
    private JTextField visitDate;
    private BackButton backButton;
    public JPanel mainPanel;
    private JTextField symptoms;
    private BackButton back;

    public VisitDetails(Visit visit, Pet pet) {
        visitDate.setText(visit.getDateTime().toLocalDate().toString());

        symptoms.setText(visit.getConditions().stream().map(Condition::getSymptoms)
                .collect(Collectors.joining(",")));
        backButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if(pet != null){
                    freshPetRecordFrame.setContentPane(new PetRecord(pet).mainPetRecord);
                    freshPetRecordFrame.setVisible(true);
                    freshPetRecordFrame.setSize(Main.INIT_WIDTH, Main.INIT_HEIGHT);
                    freshPetRecordFrame.setIconImage(Main.frame.getIconImage());
                    PetRecord.viewDetails.dispose();
                }
            }
        });
    }
}
