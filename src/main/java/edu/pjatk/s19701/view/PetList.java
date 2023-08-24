package edu.pjatk.s19701.view;

import edu.pjatk.s19701.main.Main;
import edu.pjatk.s19701.model.owner.Owner;
import edu.pjatk.s19701.model.pet.Pet;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static edu.pjatk.s19701.view.Search.freshPetRecordFrame;
import static edu.pjatk.s19701.view.Search.searchFrame;

//displays a screenwith Pets associated with an Owner provided on the Search screen
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

        //preparing a list of Strings to represent the Pets displayed in petListJList
        String[] petNamesList = new String[petList.size()];
        for(int i = 0; i < petList.size(); i++){
            petNamesList[i] = petList.get(i).getName();
        }


        petListJList.setListData(petNamesList);

        //if a Pet is selected from the list
        petListJList.addListSelectionListener(listener ->{
            //if the viewPetButton is pressed
            viewPetButton.addActionListener(pass -> {
                //JOptionPane.showMessageDialog(petListJList, petListJList.getSelectedValue());

                //for the Pet selected by the user, open a petRecordFrame
                // to be populated with the selected Pet info
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


    public static void main(String[] args){

        //example data
        Owner owner = new Owner();
        Pet pet1  = new Pet();
        pet1.setName("Woof");
        Pet pet2 = new  Pet();
        pet2.setName("Miau");
        List<Pet>  testPetList = new ArrayList<>();
        testPetList.add(pet1);
        testPetList.add(pet2);

        JPanel petListPanel = new PetList(owner, testPetList).mainPetList;

        petListFrame.setContentPane(petListPanel);
        petListFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        petListFrame.setSize(Main.INIT_WIDTH, Main.INIT_HEIGHT);
        petListFrame.pack();
        petListFrame.setVisible(true);
    }
}
