package com.company;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

public class Client extends Person{ //inheritance
    private int client_id;
    private String DateOfBirth;
    private double balance;

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

    public double getBalance() {
        return balance;
    }   //end of getter method
    public void setBalance(double balance) {
        this.balance = balance;
    }   //end of setter method

    public int calculateAge(LocalDate dob) {    //method to calculate the age of the client
        LocalDate currentDate = LocalDate.now();    //getting the current date
        if (dob != null) {  //if the date of birth is not null
            return Period.between(dob, currentDate).getYears();     //return the age of the client
        } else {    //if the date of birth is null
            return 0;   //return 0
        }
    }

    @Override
    public boolean signin_check(String phone_number, String password) throws Exception {    //overriding the Person class method
        DBMethods database = new DBMethods();   //creating an object of the DBMethods class
        Connection connection = database.connect_to_DB("DatabaseOne", "postgres", "pgadmin");   //connecting to the database

        // int sign_in_id = database.get_id_by_phone_number_client(connection, phone_number);

        if(database.check1(connection, phone_number, password)){    //if the phone number and password are correct
            return true;    //return true
        } else {    //if the phone number and password are not correct
            return false;   //return false
        }

    }

    public void setFields(){    //method to set the fields of the client
        DBMethods database = new DBMethods();   //creating an object of the DBMethods class
        Connection connection = database.connect_to_DB("DatabaseOne", "postgres", "pgadmin");   //connecting to the database
        database.insert_row(connection, getFirstname(), getLastname(), getPhone_number(), getDateOfBirth(), getPassword());  //inserting the client's details into the database
    }
}