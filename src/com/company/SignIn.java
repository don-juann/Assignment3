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
            if(client.signin_check(phone_number, password1)) {  //check if the user is signed in
                System.out.println("USER SUCCESSFULLY SIGNED IN\n");    //print message
                Screen screen = new Screen();       //create screen object
                screen.UserScreen(phone_number);
            } else{ //if the user is not signed in
                System.out.println("\nPHONE NUMBER OR PASSWORD IS INCORRECT, TRY AGAIN");   //print message
                Screen screen = new Screen();   //create screen object
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
            if(admin.signin_check(phone_number, password1)) {  //check if the admin is signed in
                System.out.println("ADMIN SUCCESSFULLY SIGNED IN\n");    //print message
                Screen screen = new Screen();       //create screen object
                screen.AdminScreen();
            } else{ //if the user is not signed in
                System.out.println("\nPHONE NUMBER OR PASSWORD IS INCORRECT, TRY AGAIN");   //print message
                Screen screen = new Screen();   //create screen object
                screen.caseOne();   //call the caseOne method of the Screen class
            }
        }catch(Exception e){
            System.out.println(e);  //print error message
        }
    }
}