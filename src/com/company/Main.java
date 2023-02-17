package com.company;

public class Main {
    public static void main(String[] args) {
        Screen screen = new Screen();   //creating an object of the Screen class
        screen.MainScreen();    //calling the MainScreen method of the Screen class

        /*
        Tables in localhost database were already created by using these methods below.

        DBMethods db = new DBMethods();
        Connection connection = db.connect_to_DB("DatabaseOne", "postgres","0311");
        db.create_client_table(connection);
        db.create_admin_table(connection);
         */
    }
}