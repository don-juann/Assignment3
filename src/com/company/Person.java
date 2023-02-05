package com.company;

public abstract class Person{
    private String firstname, lastname;
    private String phone_number;
    private String password;

    Person(String firstname, String lastname, String phone_number, String password){
        setFirstname(firstname);
        setLastname(lastname);
        setPhone_number(phone_number);
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

    public void setPhone_number(String number) {
        this.phone_number = number;
    }
    public String getPhone_number() {
        return phone_number;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
}
