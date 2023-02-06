package com.company;

public class Main {
    public static void main(String[] args) {
        Screen screen = new Screen();   //creating an object of the Screen class
        screen.MainScreen();    //calling the MainScreen method of the Screen class

/*
        Below is a program we used only once to create tables in our localhost database, table "client" was made in a similar way.

        DBMethods database = new DBMethods();
        Connection connection = database.connect_to_DB("DatabaseOne", "postgres", "pgadmin");
        database.create_table(connection, "admin");

        public void create_table(Connection connection, String table_name){
        Statement stmt;
        try{
            String query = " create table " + table_name + "(admin_id SERIAL, firstname varchar(20), lastname varchar(20), phone_number varchar(20), password varchar(20), primary key(admin_id));";
            stmt  = connection.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Table created");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
 */

    }
}