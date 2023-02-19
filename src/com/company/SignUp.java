package com.company;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;
import java.util.Scanner;
public class SignUp {
    String thepassword; //global variable
    public void user_input(){   //method to get user input
        Scanner input = new Scanner(System.in); //scanner object
        System.out.print("First and Last name: ");  //prompt user to enter first and last name
        String line = input.nextLine(); //read user input
        String[] names = line.split(" ");   //split the user input into an array
        String firstname = names[0];    //get the first name
        String lastname = names[1]; //get the last name

        System.out.print("Date of Birth (YYYY-MM-DD): ");   //prompt user to enter date of birth
        String DateOfBirth = input.next();  //read user input

        Screen scr = new Screen();  //create screen object

        try{
            LocalDate currentDate = LocalDate.now();
            if(Period.between(LocalDate.parse(DateOfBirth), currentDate).getYears() <= 16){
                System.out.println("\n*********************************");
                System.out.println("USER IS NOT OLD ENOUGH TO SIGN UP");
                System.out.println("*********************************\n");
                scr.MainScreen();
            }
        }catch(Exception e){
            System.out.println("\n**************************");
            System.out.println("INCORRECT INPUT, TRY AGAIN");
            System.out.println("**************************\n");
            user_input();
        }

        System.out.print("Phone number(starting with 8): ");    //prompt user to enter phone number
        String phone_number= input.next();  //read user input

        try{
            if(phone_number.charAt(0)==8 && phone_number.length()==11) {
                if (phone_number_exists(phone_number)) {
                    System.out.println("************************************");
                    System.out.println("USER WITH THIS NUMBER ALREADY EXISTS");
                    System.out.println("************************************\n");
                    scr.MainScreen();
                } else {
                    password_check();   //call the password_check method

                    Client cl = new Client(firstname, lastname, phone_number, DateOfBirth, thepassword);    //create client object
                    cl.setFields(); //call the setFields method of the Client class
                    scr.MainScreen();   //call the MainScreen method of the Screen class
                }
            }
        }catch(Exception e){
            System.out.println("\n**************************");
            System.out.println("INCORRECT INPUT, TRY AGAIN");
            System.out.println("**************************\n");
            user_input();
        }
    }

    public boolean phone_number_exists(String phone_number) {
        DBMethods db = new DBMethods();
        Connection connection = db.connect_to_DB();
            try{
                String query = String.format("select * from client where phone_number = '%s'", phone_number);
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                if(rs.next()){
                    return true;
                }
            }catch(Exception e){
                System.out.println(e);
            }
        return false;
    }

    public void password_check(){   //method to check if the passwords match
        Scanner input = new Scanner(System.in); //scanner object
        System.out.print("Enter your new password: ");  //prompt user to enter password.
        String password1 = input.nextLine();    //read user input
        System.out.print("Enter your new password again: ");    //prompt user to enter password again
        String password2 = input.next();    //read user input

        if(Objects.equals(password1, password2)){           //check if the passwords match
            thepassword = password2;    //assign the password to the global variable
            System.out.println("\n*******************************");
            System.out.println("NEW USER SUCCESSFULLY SIGNED UP");  //print message
            System.out.println("*******************************");
        }else{  //if the passwords do not match
            System.out.println("PASSWORDS DO NOT MATCH, TRY AGAIN");    //print message
            password_check();   //call the password_check method
        }
    }
}