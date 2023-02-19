package com.company;

import java.sql.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class DBMethods {
    public Connection connect_to_DB() {  //method to connect to the database
        Connection connection = null;   //creating a connection object
        String DBName = "DatabaseOne";
        String Username = "postgres";
        String password = "0311";

        try {   //try block
            Class.forName("org.postgresql.Driver"); //loading the driver
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+ DBName, Username, password);   //connecting to the database
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

    public void create_client_table(Connection connection){
        Statement stmt;
        try{
            String query = "create table client(id SERIAL,firstname varchar(30),lastname varchar(30),phone_number varchar(15),date_of_birth varchar(15),password varchar(30), balance varchar(15), primary key(id));";
            stmt = connection.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Table client is created");
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void create_admin_table(Connection connection){
        Statement stmt;
        try{
            String query = "create table admin(id SERIAL,firstname varchar(30),lastname varchar(30),phone_number varchar(15),date_of_birth varchar(15),password varchar(30),primary key(id));";
            stmt = connection.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Table admin is created");
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void insert_row(Connection connection, String firstname, String lastname, String phone_number, String DateOfBirth, String password){ //method to insert a row into the table
        Statement stmt; //creating a statement object
        double balance = 0.0;   //creating a double variable to store the balance
        try{    //try block
            String query = String.format("insert into client(firstname, lastname, phone_number, Date_Of_Birth, password, balance) values('%s','%s','%s','%s','%s','%s');", firstname, lastname, phone_number, DateOfBirth, password, balance);   //creating a string variable to store the query
            stmt = connection.createStatement();    //creating a statement object
            stmt.executeUpdate(query);  //executing the query

        }catch(Exception e){        //catch block
            System.out.println(e);  //print the exception
        }   //end of try-catch block
    }


    public void read_data_of_client(Connection connection, String phone_number){   //method to read data from the table
        Statement stmt; //creating a statement object
        ResultSet rs = null;    //creating a result set object
        try{    //try block
            String query = String.format("select * from client where phone_number = '%s'", phone_number);  //creating a string variable to store the query
            stmt = connection.createStatement();    //creating a statement object
            rs = stmt.executeQuery(query);  //executing the query
            if (rs.next()) {
                System.out.println("ID: " + rs.getString("id"));  //print the client_id
                System.out.print(rs.getString("firstname")+ " ");   //print the firstname
                System.out.println(rs.getString("lastname"));  //print the lastname
                System.out.println("Phone Number: " + rs.getString("phone_number"));  //print the phone_number
                System.out.println("Age:" + calculateAge(LocalDate.parse(rs.getString("DateOfBirth")))+ " years old");   //print the DateOfBirth
            }
        }catch(Exception e){    //catch block
            System.out.println(e);  //print the exception
        }
    }

    public void read_data_of_clients(Connection connection){   //method to read data from the table
        Statement stmt; //creating a statement object
        ResultSet rs = null;    //creating a result set object
        try{    //try block
            String query = String.format("select * from client");  //creating a string variable to store the query
            stmt = connection.createStatement();    //creating a statement object
            rs = stmt.executeQuery(query);  //executing the query
            while (rs.next()) {
                System.out.println("ID: " + rs.getString("id"));  //print the client_id
                System.out.print(rs.getString("firstname")+ " ");   //print the firstname
                System.out.println(rs.getString("lastname"));  //print the lastname
                System.out.println("Phone Number: " + rs.getString("phone_number"));  //print the phone_number
                System.out.println("Age:" + calculateAge(LocalDate.parse(rs.getString("DateOfBirth")))+ " years old\n");   //print the DateOfBirth
            }
        }catch(Exception e){    //catch block
            System.out.println(e);  //print the exception
        }
    }
    public boolean checkClient(Connection connection,String phone_number, String password) throws SQLException {
        String query = String.format("select password from client where phone_number = '%s'",phone_number);
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        if(rs.next()){
            return Objects.equals(rs.getString("password"), password);
        }else{
            return false;
        }
    }

    public boolean checkAdmin(Connection connection,String phone_number, String password) throws SQLException {
        String query = String.format("select password from admin where phone_number = '%s'",phone_number);
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        if(rs.next()){
            return Objects.equals(rs.getString("password"), password);
        }else{
            return false;
        }
    }
    public void delete_row_by_id(Connection connection, int id){
        Statement stmt;
        try{
            String query = String.format("delete from client where id = '%s'", id);
            stmt = connection.createStatement();
            stmt.executeUpdate(query);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public int calculateAge(LocalDate dob) {    //method to calculate the age of the client
        LocalDate currentDate = LocalDate.now();    //getting the current date
        if (dob != null) {  //if the date of birth is not null
            return Period.between(dob, currentDate).getYears();     //return the age of the client
        } else {    //if the date of birth is null
            return 0;   //return 0
        }
    }
}