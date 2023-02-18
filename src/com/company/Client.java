package com.company;

import java.sql.Connection;
import java.sql.SQLException;

public class Client extends Person{ //inheritance
    private String DateOfBirth;
    Client(){
        //no argument
    }
    Client(String firstname, String lastname, String phone_number, String DateOfBirth, String password) {//constructor
        super(firstname, lastname, phone_number, password);//calling the constructor of the parent class
        setDateOfBirth(DateOfBirth);//calling the setter method of the parent class
        //setPassword(password);
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }//end of getter method

    public void setDateOfBirth(String dateOfBirth) {    //setter method
        DateOfBirth = dateOfBirth; //setting the value of the date of birth
    }

    @Override
    public boolean signin_check(String phone_number, String password) throws SQLException {
        DBMethods database = new DBMethods();
        Connection connection = database.connect_to_DB("DatabaseOne", "postgres", "0311");
        return database.checkClient(connection, phone_number, password);
    }

    public void setFields(){    //method to set the fields of the client
        DBMethods database = new DBMethods();   //creating an object of the DBMethods class
        Connection connection = database.connect_to_DB("DatabaseOne", "postgres", "0311");   //connecting to the database
        database.insert_row(connection, getFirstname(), getLastname(), getPhone_number(), getDateOfBirth(), getPassword());  //inserting the client's details into the database
    }
}