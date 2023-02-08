package com.company;

import java.sql.*;
import java.util.Objects;

//database.createTable(connection, "employee");
//database.insert_row(connection, "employee", "Zhan", "Astana");
//database.update_name(connection, "employee", "Daulet", "Zhan" );
//database.read_data(connection, "employee");
//database.search_by_name(connection, "employee", "Zhan");
//database.search_by_id(connection, "employee", 1);
//database.delete_row_by_id(connection, "employee", 2);
//database.read_data(connection, "employee");
//database.delete_table(connection, "employee");

public class DBMethods {
    public Connection connect_to_DB(String DBName, String Username, String password ){  //method to connect to the database
        Connection connection = null;   //creating a connection object
        try {   //try block
            Class.forName("org.postgresql.Driver"); //loading the driver
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+DBName, Username, password);   //connecting to the database
            if(connection!=null){   //if the connection is not null
                System.out.println(" ");    //print a blank line
            }else{  //if the connection is null
                System.out.println("Connection failed");    //print a message
            }   //end of if statement
        } catch (Exception e) { //catch block
            System.out.println(e);  //print the exception
        }
        return connection;  //return the connection
    }



    public void insert_row(Connection connection, String firstname, String lastname, String phone_number, String DateOfBirth, String password){ //method to insert a row into the table
        Statement stmt; //creating a statement object
        String table_name = "client";   //creating a string variable to store the table name
        try{    //try block
            String query = String.format("insert into %s(firstname, lastname, phone_number, DateOfBirth, password) values('%s','%s','%s','%s','%s');", table_name, firstname, lastname, phone_number, DateOfBirth, password);   //creating a string variable to store the query
            stmt = connection.createStatement();    //creating a statement object
            stmt.executeUpdate(query);  //executing the query
        }catch(Exception e){        //catch block
            System.out.println(e);  //print the exception
        }   //end of try-catch block
    }


    public void read_data(Connection connection, String table_name){    //method to read data from the table
        Statement stmt; //creating a statement object
        ResultSet rs = null;    //creating a result set object
        try{    //try block
            String query = String.format("select * from %s", table_name);   //creating a string variable to store the query
            stmt = connection.createStatement();    //creating a statement object
            rs = stmt.executeQuery(query);  //executing the query
            while(rs.next()){   //while loop
                System.out.print(rs.getString("client_id") + " ");  //print the client_id
                System.out.print(rs.getString("firstname")+ " ");   //print the firstname
                System.out.println(rs.getString("lastname")+ " ");  //print the lastname
                System.out.println(rs.getString("phone_number")+ " ");  //print the phone_number
                System.out.println(rs.getString("DateOfBirth")+ " ");   //print the DateOfBirth
            }


        }catch(Exception e){    //catch block
            System.out.println(e);  //print the exception
        }
    }

    public boolean checkClient(Connection connection,String phone_number, String password) throws SQLException {
        String query = String.format("select password from client where phone_number = '%s'",phone_number);
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        int d = 0;
        rs.next();
        return Objects.equals(rs.getString("password"), password);
    }

    public boolean checkAdmin(Connection connection,String phone_number, String password) throws SQLException {
        String query = String.format("select password from admin where phone_number = '%s'",phone_number);
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        rs.next();
        return Objects.equals(rs.getString("password"), password);
    }
}

/*
        public void delete_row_by_id(Connection connection, String table_name, int client_id){
        Statement stmt;
        try{
            String query = String.format("delete from %s where client_id = '%s'", table_name, client_id);
            stmt = connection.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Data Deleted");
        }catch(Exception e){
            System.out.println(e);
        }
    }
* */