package com.company;

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

        System.out.print("Phone number(starting with 8): ");    //prompt user to enter phone number
        String phone_number= input.next();  //read user input

        password_check();   //call the password_check method

        Client cl = new Client(firstname, lastname, phone_number, DateOfBirth, thepassword);    //create client object
        cl.setFields(); //call the setFields method of the Client class

        Screen scr = new Screen();  //create screen object
        scr.MainScreen();   //call the MainScreen method of the Screen class
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
            System.out.println("*******************************\n");
        }else{  //if the passwords do not match
            System.out.println("PASSWORDS DO NOT MATCH, TRY AGAIN");    //print message
            password_check();   //call the password_check method
        }
    }
}