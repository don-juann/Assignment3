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
    public Connection connect_to_DB(String DBName, String Username, String password ){
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+DBName, Username, password);
            if(connection!=null){
                System.out.println(" ");
            }else{
                System.out.println("Connection failed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }



    public void insert_row(Connection connection, String firstname, String lastname, String phone_number, String DateOfBirth, String password){
        Statement stmt;
        String table_name = "client";
        try{
            String query = String.format("insert into %s(firstname, lastname, phone_number, DateOfBirth, password) values('%s','%s','%s','%s','%s');", table_name, firstname, lastname, phone_number, DateOfBirth, password);
            stmt = connection.createStatement();
            stmt.executeUpdate(query);
        }catch(Exception e){
            System.out.println(e);
        }
    }


    public void read_data(Connection connection, String table_name){
        Statement stmt;
        ResultSet rs = null;
        try{
            String query = String.format("select * from %s", table_name);
            stmt = connection.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next()){
                System.out.print(rs.getString("client_id") + " ");
                System.out.print(rs.getString("firstname")+ " ");
                System.out.println(rs.getString("lastname")+ " ");
                System.out.println(rs.getString("phone_number")+ " ");
                System.out.println(rs.getString("DateOfBirth")+ " ");
            }


        }catch(Exception e){
            System.out.println(e);
        }
    }

    public boolean check1(Connection connection, String phone_number, String password) throws SQLException{
        Statement stmt;
        ResultSet rs = null;
        String table_name = "client";
        String query = String.format("select password from %s where phone_number = '%s'",table_name, phone_number);
        stmt = connection.createStatement();

        rs = stmt.executeQuery(query);
        if(Objects.equals(rs.getString("password"), password) ){
            System.out.println("rs equal to password");
            return true;
        }

        return false;
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