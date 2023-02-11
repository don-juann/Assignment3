package com.company;

import java.sql.Connection;
import java.sql.SQLException;

public class Admin extends Person{
    private int admin_id;

    Admin(){
        //no argument
    }
    Admin(String firstname, String lastname, String phone_number, String password) {
        super(firstname, lastname, phone_number, password);
    }
    @Override
    public  boolean signin_check(String phone_number, String password) throws SQLException{
        DBMethods database = new DBMethods();
        //int d = 0;
        Connection connection = database.connect_to_DB("DatabaseOne", "postgres", "0311");
        return database.checkAdmin(connection, phone_number, password);
    }
}