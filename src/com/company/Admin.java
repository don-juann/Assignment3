package com.company;

import java.sql.Connection;

public class Admin extends Person{
    private int admin_id;

    Admin(){
        //no argument
    }
    Admin(String firstname, String lastname, String phone_number, String password) {
        super(firstname, lastname, phone_number, password);
    }
    @Override
    public  boolean signin_check(String phone_number, String password) throws Exception {
        DBMethods database = new DBMethods();
        //int d = 0;
        Connection connection = database.connect_to_DB("DatabaseOne", "postgres", "pgadmin");
        return database.checkAdmin(connection, phone_number, password);
    }
}