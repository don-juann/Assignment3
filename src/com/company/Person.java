package com.company;

import java.sql.SQLException;

public abstract class Person implements IPerson{
    private String firstname;
    private String lastname;
    private String phone_number;
    private String password;
    Person(){
        //no argument
    }
    Person(String firstname, String lastname, String phone_number, String password){    //constructor
        setFirstname(firstname);    //calling the setter method
        setLastname(lastname);  //calling the setter method
        setPhone_number(phone_number);  //calling the setter method
        setPassword(password);  //calling the setter method
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }   //end of setter method
    public String getFirstname() {
        return firstname;
    }   //end of getter method

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }   //end of setter method
    public String getLastname() {
        return lastname;
    }   //end of getter method

    public void setPhone_number(String number) {
        this.phone_number = number; //setting the value of the phone number
    }
    public String getPhone_number() {
        return phone_number;
    }   //end of getter method

    public void setPassword(String password) {
        this.password = password;
    }   //end of setter method
    public String getPassword() {
        return password;
    }   //end of getter method

    @Override   //overriding the IPerson interface method
    public abstract boolean signin_check(String phone_number, String password) throws SQLException;    //method to check if the user is signed in

}