package com.company;

public abstract class Person{
    private String firstname, lastname;
    private int number;
    private String password;

    Person(String firstname, String lastname, int number, String password){
        setFirstname(firstname);
        setLastname(lastname);
        setNumber(number);
        setPassword(password);
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getFirstname() {
        return firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getLastname() {
        return lastname;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    public int getNumber() {
        return number;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
}
