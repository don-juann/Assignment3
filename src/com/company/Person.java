package com.company;

public class Person extends DBMethods{
    private String firstname, lastname;
    private int id;
    Person(String firstname, String lastname){
        setFirstname(firstname);
        setLastname(lastname);
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
