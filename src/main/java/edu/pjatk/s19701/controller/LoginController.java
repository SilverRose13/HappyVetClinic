package edu.pjatk.s19701.controller;

import edu.pjatk.s19701.model.employee.EmployeeDao;
import edu.pjatk.s19701.model.owner.OwnerDao;

public class LoginController {

    EmployeeDao employeeDao = new EmployeeDao();
    OwnerDao ownerDao = new OwnerDao();

    //searches for an Employee with the provided credentials to check if they are valid
    //uses DAO class to communicate with the DB
    public boolean loginEmployee(String user, String password) {
        return employeeDao.verifyIfLoginAndPassExists(user, password);
    }

    //searches for an Owner with the provided credentials to check if they are valid
    //uses DAO class to communicate with the DB
    public boolean loginOwner(String user, String password) {
        return ownerDao.verifyIfLoginAndPassExists(user, password);
    }
}
