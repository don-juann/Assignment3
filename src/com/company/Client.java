package com.company;

import java.time.LocalDate;
import java.time.Period;

public class Client extends Person{
    private int client_id;
    private int age;
    private double balance;

    public Client(String firstname, String lastname, int number, String password, String DateOfBirth) {
        super(firstname, lastname, number, password);
        setAge(calculateAge(LocalDate.parse(DateOfBirth)));
        setPassword(password);
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
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

}