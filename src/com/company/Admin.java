package com.company;

public class Admin extends Person{
    private int admin_id;

    Admin(String firstname, String lastname, String phone_number, String password) {
        super(firstname, lastname, phone_number, password);
    }
}