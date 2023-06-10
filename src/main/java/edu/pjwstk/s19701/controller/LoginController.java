package edu.pjwstk.s19701.controller;

import edu.pjwstk.s19701.model.employee.EmployeeDao;
import edu.pjwstk.s19701.model.owner.OwnerDao;

public class LoginController {

    EmployeeDao employeeDao = new EmployeeDao();
    OwnerDao ownerDao = new OwnerDao();

    public boolean loginEmployee(String user, String password) {
        return employeeDao.verifyIfLoginAndPassExists(user, password);
    }
    public boolean loginOwner(String user, String password) {
        return ownerDao.verifyIfLoginAndPassExists(user, password);
    }
}
