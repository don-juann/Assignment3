package com.company;

import java.sql.Connection;
public class Main {
    public static void main(String[] args) {
        DBMethods database = new DBMethods();
        Connection connection = database.connect_to_DB("DatabaseOne", "postgres", "0311");

        //database.createTable(connection, "employee");
        //database.insert_row(connection, "employee", "Zhan", "Astana");
        //database.update_name(connection, "employee", "Daulet", "Zhan" );
        //database.read_data(connection, "employee");
        //database.search_by_name(connection, "employee", "Zhan");
        //database.search_by_id(connection, "employee", 1);
        //database.delete_row_by_id(connection, "employee", 2);
        //database.read_data(connection, "employee");
        //database.delete_table(connection, "employee");
    }
}