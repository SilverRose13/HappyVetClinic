package edu.pjatk.s19701.model.person;

public interface PersonDaoInterface<Person, String> {

    boolean verifyIfLoginAndPassExists(String user, String password);

}