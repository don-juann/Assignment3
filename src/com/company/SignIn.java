package com.company;

import java.util.Scanner;
public class SignIn {
    public void user_input(){   //method to get user input
        try {
            Scanner input = new Scanner(System.in); //scanner object
            System.out.print("Phone number: "); //prompt user to enter phone number
            String phone_number = input.next(); //read user input
            System.out.print("Password: "); //prompt user to enter password
            String password1 = input.next();    //read user input
            Client client = new Client();   //create client object
            Screen screen = new Screen();       //create screen object

            if(client.signin_check(phone_number, password1)) {  //check if the user is signed in
                System.out.println("***************************");
                System.out.println("USER SUCCESSFULLY SIGNED IN");    //print message
                System.out.println("***************************");
                screen.UserScreen(phone_number);
            } else{ //if the user is not signed in
                System.out.println("************************************************");
                System.out.println("PHONE NUMBER OR PASSWORD IS INCORRECT, TRY AGAIN");   //print message
                System.out.println("************************************************");
                screen.caseOne();   //call the caseOne method of the Screen class
            }
        }catch(Exception e){
            System.out.println(e);  //print error message
        }
    }

    public void admin_input(){   //method to get user input
        try {
            Scanner input = new Scanner(System.in); //scanner object
            System.out.print("Phone number: "); //prompt admin to enter phone number
            String phone_number = input.next(); //read admin input
            System.out.print("Password: "); //prompt admin to enter password
            String password1 = input.next();    //read admin input
            Admin admin = new Admin();   //create client object
            Screen screen = new Screen();       //create screen object

            if(admin.signin_check(phone_number, password1)) {  //check if the admin is signed in
                System.out.println("****************************");
                System.out.println("ADMIN SUCCESSFULLY SIGNED IN");    //print message
                System.out.println("****************************");
                screen.AdminScreen();
            } else{ //if the user is not signed in
                System.out.println("************************************************");
                System.out.println("PHONE NUMBER OR PASSWORD IS INCORRECT, TRY AGAIN");   //print message
                System.out.println("************************************************");
                screen.caseOne();   //call the caseOne method of the Screen class
            }
        }catch(Exception e){
            System.out.println(e);  //print error message
        }
    }
}