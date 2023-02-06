package com.company;

public class Admin extends Person{
    private int admin_id;

    Admin(){
        //no argument
    }
    Admin(String firstname, String lastname, String phone_number, String password) {
        super(firstname, lastname, phone_number, password);
    }
    @Override
    public  boolean signin_check(String number, String password) {
        return true;
    }
}