package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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
                System.out.println("Connection established");
            }else{
                System.out.println("Connection failed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }

    public void insert_row(Connection connection, String firstname, String lastname, String phone_number,String DateOfBirth, String password){
        Statement stmt;
        String table_name = "admin";
        try{
            String query = String.format("insert into %s(firstname, lastname, phone_number, DateOfBirth, password) values('%s','%s','%s','%s','%s');", table_name, firstname, lastname, phone_number, DateOfBirth, password);
            stmt = connection.createStatement();
            stmt.executeUpdate(query);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public int search_by_phone_number(Connection connection, String phone_number){
        Statement stmt;
        String table_name = "client";
        ResultSet rs = null;
        int count = 0;
        try{
            String query = String.format("select * from %s where name = '%s'",table_name, phone_number);
            stmt = connection.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next()){
                count++;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return count;
    }

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
    public void read_data(Connection connection, String table_name){
        Statement stmt;
        ResultSet rs = null;
        try{
            String query = String.format("select * from %s", table_name);
            stmt = connection.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next()){
                System.out.print(rs.getString("id") + " ");
                System.out.print(rs.getString("name")+ " ");
                System.out.println(rs.getString("address")+ " ");
            }


        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void update_name(Connection connection, String table_name, String new_name, String old_name){
        Statement stmt;
        try{
            String query = String.format("update %s set name='%s' where name = '%s'", table_name, new_name, old_name);
            stmt = connection.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Data Updated");
        }catch(Exception e){
            System.out.println(e);
        }
    }



    public void search_by_id(Connection connection, String table_name, int id){
        Statement stmt;
        ResultSet rs = null;
        try{
            String query = String.format("select * from %s where id = '%s'",table_name, id);
            stmt = connection.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next()){
                System.out.print(rs.getString("id") + " ");
                System.out.print(rs.getString("name") + " ");
                System.out.println(rs.getString("address") + " ");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void delete_table(Connection connection, String table_name){
        Statement stmt;
        try{
            String query = String.format("drop table %s", table_name);
            stmt = connection.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Table Deleted");
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
