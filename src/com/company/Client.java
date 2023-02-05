package com.company;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.Period;

public class Client extends Person{
    private int client_id;
    private String DateOfBirth;
    private double balance;

    public Client(String firstname, String lastname, String phone_number, String DateOfBirth, String password) {
        super(firstname, lastname, phone_number, password);
        setDateOfBirth(DateOfBirth);
        setPassword(password);
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
    public void setFields(){
        DBMethods database = new DBMethods();
        Connection connection = database.connect_to_DB("DatabaseOne", "postgres", "0311");
        database.insert_row(connection, getFirstname(), getLastname(), getPhone_number(), getDateOfBirth(), getPassword());
    }
}