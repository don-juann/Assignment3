package com.company;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

public class Client extends Person{
    private int client_id;
    private String DateOfBirth;
    private double balance;

    Client(){
        //no argument
    }
    Client(String firstname, String lastname, String phone_number, String DateOfBirth, String password) {
        super(firstname, lastname, phone_number, password);
        setDateOfBirth(DateOfBirth);
        //setPassword(password);
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int calculateAge(LocalDate dob) {
        LocalDate currentDate = LocalDate.now();
        if (dob != null) {
            return Period.between(dob, currentDate).getYears();
        } else {
            return 0;
        }
    }

    @Override
    public boolean signin_check(String phone_number, String password) throws Exception {
        DBMethods database = new DBMethods();
        Connection connection = database.connect_to_DB("DatabaseOne", "postgres", "pgadmin");

        // int sign_in_id = database.get_id_by_phone_number_client(connection, phone_number);

        if(database.check1(connection, phone_number, password)){
            return true;
        } else {
            return false;
        }

    }

    public void setFields(){
        DBMethods database = new DBMethods();
        Connection connection = database.connect_to_DB("DatabaseOne", "postgres", "pgadmin");
        database.insert_row(connection, getFirstname(), getLastname(), getPhone_number(), getDateOfBirth(), getPassword());
    }
}