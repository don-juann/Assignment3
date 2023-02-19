package com.company;
import java.sql.*;
public class BankOperations {

    public void show_balance(Connection conn, String phone_number) {
        try {
            String showBalanceQuery = String.format("(SELECT balance FROM client WHERE phone_number ='%s');", phone_number);    //creating a string variable to store the query
            Statement stmt = conn.createStatement();  //creating a statement object
            ResultSet rs = stmt.executeQuery(showBalanceQuery);   //executing the query
            if (rs.next()) {    //if the result set is not null
                double balance = rs.getDouble("balance"); //creating a double variable to store the balance
                System.out.println("\nCurrent balance: " + balance + " tenge");  //print the balance
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void insert_money(Connection conn, String phone_number, double deposit) {
        if(deposit <= 300000){
            try {
                String GetBalanceQuery = String.format("SELECT balance FROM client WHERE phone_number ='%s';", phone_number);    //creating a string variable to store the query
                Statement stmt = conn.createStatement();  //creating a statement object
                ResultSet rs = stmt.executeQuery(GetBalanceQuery);   //executing the query
                if (rs.next()) {
                    double amount = rs.getDouble("balance") + deposit;    //creating a double variable to store the amount
                    String insertMoneyQuery = String.format("UPDATE client SET balance='%s' WHERE phone_number='%s'", amount, phone_number);         //creating a string variable to store the query
                    stmt = conn.createStatement();  //creating a statement object
                    stmt.executeUpdate(insertMoneyQuery); //executing the query
                    System.out.println("\nSuccessfully deposited " + deposit + " tenge");  //print a message
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }else{
            System.out.println("\n****************************************************");
            System.out.println("YOU CAN DEPOSIT NO MORE THAN 300,000 TENGE AT A TIME");
            System.out.println("****************************************************");
        }

    }
    public void withdrawBalance(Connection connection, String phone_number, double sum){
        try{    //try block
            String query = String.format("select balance from client where phone_number = '%s'", phone_number);  //creating a string variable to store the query
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            double bl = Double.parseDouble(rs.getString("balance"));
            if( bl >= sum && sum <=300000){
                bl -= sum;
                query = String.format("update client set balance='%s' where phone_number='%s'", bl, phone_number);
                stmt = connection.createStatement();
                stmt.executeUpdate(query);
                System.out.println("\nSuccessfully withdrawn " + sum + " tenge");  //print a message
            }else if(bl >= sum && sum > 300000){
                System.out.println("\n*****************************************************");
                System.out.println("YOU CAN WITHDRAW NO MORE THAN 300,000 TENGE AT A TIME");  //print the exception
                System.out.println("*****************************************************");
            }else if(bl < sum){
                System.out.println("\n******************");
                System.out.println("NOT ENOUGH BALANCE");  //print the exception
                System.out.println("******************");
            }else{
                System.out.println("\n***************");
                System.out.println("INCORRECT INPUT");  //print the exception
                System.out.println("***************");
            }
        }catch(Exception e){    //catch block
            System.out.println("\n***************");
            System.out.println("INCORRECT INPUT");  //print the exception
            System.out.println("***************");
        }
    }
}