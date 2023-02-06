package com.company;

public abstract class Person implements IPerson{
    private String firstname, lastname; //firstname and lastname are reserved words in SQL, so we use "firstname" and "lastname" instead
    private String phone_number;    //phone number is a reserved word in SQL, so we use "phone_number" instead
    private String password;    //password is a reserved word in SQL, so we use "password" instead

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
    public abstract boolean signin_check(String phone_number, String password) throws Exception;    //method to check if the user is signed in

}