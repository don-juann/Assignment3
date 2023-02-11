package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

public class Client extends Person{ //inheritance
    private int id;
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
    private static int checkBalance(Connection connection, int clientId) throws SQLException {  //method to check the balance of the client
        String sql = "SELECT balance FROM clients WHERE id = ?";   //sql query to get the balance of the client
        PreparedStatement statement = connection.prepareStatement(sql); //preparing the statement
        statement.setInt(1, clientId);  //setting the value of the client id
        ResultSet resultSet = statement.executeQuery();   //executing the query

        if (resultSet.next()) { //if the result set is not empty
            int balance = resultSet.getInt("balance");  //getting the balance of the client
            System.out.println("Your balance is: " + balance);  //printing the balance of the client
            return balance; //returning the balance of the client
        } else {
            System.out.println("Failed to retrieve balance. Please try again.");    //printing a message
            return -1;  //returning -1
        }
    }
}