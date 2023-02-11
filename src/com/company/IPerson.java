package com.company;

import java.sql.SQLException;

public interface IPerson {  //interface
    public boolean signin_check(String number, String password) throws SQLException;   //method to check if the user is signed in
}