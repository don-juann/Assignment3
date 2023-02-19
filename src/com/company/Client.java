package com.company;

import java.sql.Connection;
import java.sql.SQLException;

public class Client extends Person{ //inheritance
    private String Date_Of_Birth;
    Client(){
        //no argument
    }
    Client(String firstname, String lastname, String phone_number, String DateOfBirth, String password) {//constructor
        super(firstname, lastname, phone_number, password);//calling the constructor of the parent class
        setDateOfBirth(DateOfBirth);//calling the setter method of the parent class
    }

    public String getDate_Of_Birth() {
        return Date_Of_Birth;
    }//end of getter method

    public void setDateOfBirth(String dateOfBirth) {    //setter method
        Date_Of_Birth = dateOfBirth; //setting the value of the date of birth
    }

    @Override
    public boolean signin_check(String phone_number, String password) throws SQLException {
        DBMethods database = new DBMethods();
        Connection connection = database.connect_to_DB();
        return database.checkClient(connection, phone_number, password);
    }

    public void setFields(){    //method to set the fields of the client
        DBMethods database = new DBMethods();   //creating an object of the DBMethods class
        Connection connection = database.connect_to_DB();   //connecting to the database
        database.insert_row(connection, getFirstname(), getLastname(), getPhone_number(), getDate_Of_Birth(), getPassword());  //inserting the client's details into the database
    }
}