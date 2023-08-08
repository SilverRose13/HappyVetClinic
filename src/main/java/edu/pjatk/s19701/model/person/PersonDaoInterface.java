package edu.pjatk.s19701.model.person;

public interface PersonDaoInterface<Person, String> {

    //verifies that a Person with the provided credentials exists
    boolean verifyIfLoginAndPassExists(String user, String password);

}
