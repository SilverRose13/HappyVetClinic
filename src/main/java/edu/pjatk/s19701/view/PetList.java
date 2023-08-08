package edu.pjatk.s19701.view;

import edu.pjatk.s19701.main.Main;
import edu.pjatk.s19701.model.Visit;
import edu.pjatk.s19701.model.owner.Owner;
import edu.pjatk.s19701.model.pet.Pet;

import javax.swing.*;
import java.util.List;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import static edu.pjatk.s19701.view.Search.freshPetRecordFrame;
import static edu.pjatk.s19701.view.Search.searchFrame;

public class PetList {
    private List<Pet> petList;
    private Owner owner;
    public JPanel mainPetList;
    private JPanel BottomRow;
    private JButton viewPetButton;
    private BackButton backButton;
    private JPanel PetListJPanel;
    private JScrollPane petListScrollPanel;
    private JList petListJList;
    static JFrame petListFrame = new JFrame(Main.APPLICATION_NAME);
    
    public PetList(Owner owner, List<Pet> petList) {
        searchFrame.dispose();
        
        this.owner = owner;
        this.petList = petList;

        String[] petNamesList = new String[petList.size()];
        for(int i = 0; i < petList.size(); i++){
            petNamesList[i] = petList.get(i).getName();
        }


        petListJList.setListData(petNamesList);

        petListJList.addListSelectionListener(listener ->{
            viewPetButton.addActionListener(pass -> {
                //JOptionPane.showMessageDialog(petListJList, petListJList.getSelectedValue());

                petList.forEach(petName -> {
                    if (petName.getName().equalsIgnoreCase(petListJList.getSelectedValue().toString())) {
                        freshPetRecordFrame.setContentPane(new PetRecord(petName).mainPetRecord);
                        freshPetRecordFrame.setVisible(true);
                        freshPetRecordFrame.setSize(Main.INIT_WIDTH, Main.INIT_HEIGHT);
                        freshPetRecordFrame.setIconImage(Main.frame.getIconImage());
                        LoginWindow.searchFrame.dispose();
                        return;
                    }
                });

            });
        });



        //button to return to the Search screen
        backButton.addActionListener(event -> {
            searchFrame.setContentPane(new Search().mainSearchForPet);
            searchFrame.setVisible(true);
            searchFrame.setSize(Main.INIT_WIDTH, Main.INIT_HEIGHT);
            searchFrame.setIconImage(Main.frame.getIconImage());
            Search.freshPetListFrame.dispose();
        });
    }
    
/*    static void main(String[] args){
        JPanel petListPanel = new PetList(new Owner(), new List<Pet>).mainPetList;

        petListFrame.setContentPane(petListPanel);
        petListFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        petListFrame.pack();
        petListFrame.setVisible(true);
    }*/
}
