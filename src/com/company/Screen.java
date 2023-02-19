package com.company;

import java.sql.Connection;
import java.util.Scanner;

public class Screen {
    public void MainScreen(){   //main screen method
        Scanner input = new Scanner(System.in); //creating an object of the Scanner class
        System.out.println("TAZA - ONLINE BANK\n1)SIGN IN\n2)SIGN UP\n3)EXIT");   //printing the main screen
        System.out.print("Choose option: ");    //printing the option to choose
        int choice = input.nextInt();   //getting the user input
        switch(choice){ //switch statement
            case 1: //if the user chooses 1
                caseOne();    //calling the caseOne method
            case 2: //if the user chooses 2
                caseTwo();    //calling the caseTwo method
            case 3:
                System.exit(0);
            default:    //if the user chooses something else
                System.out.println("\nUNKNOWN COMMAND");  //printing the error message
                MainScreen();   //calling the MainScreen method
        }
    }

    public void caseOne(){  //method for the case 1
        Scanner input = new Scanner(System.in); //creating an object of the Scanner class
        System.out.println("\nTAZA - ONLINE BANK\n1)SIGN IN as Client\n2)SIGN IN as Administrator");    //printing the sign in screen
        System.out.print("Choose option: ");    //printing the option to choose
        int choice = input.nextInt();   //getting the user input
        SignIn signin = new SignIn();   //creating an object of the SignIn class

        switch(choice){ //switch statement
            case 1: //if the user chooses 1
                signin.user_input();    //calling the user_input method of the SignIn class
                UserScreen(null);   //calling the UserScreen method
            case 2:
                signin.admin_input();
                AdminScreen();
            default:
                System.out.println("\nUNKNOWN COMMAND");  //printing the error message
                MainScreen();
        }
    }

    public void caseTwo(){  //method for the case 2
        SignUp signUp = new SignUp();   //creating an object of the SignUp class
        signUp.user_input();    //calling the user_input method of the SignUp class
    }
    public void UserScreen(String phone_number){   //method for the user screen
        DBMethods db = new DBMethods(); //creating an object of the DBMethods class
        Connection connection = db.connect_to_DB(); //creating an object of the Connection class

        Scanner input = new Scanner(System.in); //creating an object of the Scanner class
        System.out.println("TAZA - ONLINE BANK\n1)Show Client Information\n2)Show Balance\n3)Deposit Money\n4)Withdraw Money\n5)Sign Out");    //printing the user screen
        System.out.print("Choose option: ");    //printing the option to choose
        int choice = input.nextInt();   //getting the user input
        switch(choice){ //switch statement
            case 1:
                db.read_data_of_client(connection, phone_number);
                UserScreen(phone_number);
            case 2:
                BankOperations bank = new BankOperations();
                bank.show_balance(connection, phone_number);
                UserScreen(phone_number);
            case 3:
                BankOperations bank2 = new BankOperations();
                System.out.print("\nEnter Amount To Deposit: ");
                double amount = input.nextDouble();
                bank2.insert_money(connection, phone_number, amount);
                UserScreen(phone_number);
            case 4:
                //withdraw money
                BankOperations bank3 = new BankOperations();
                System.out.print("Enter Amount To Withdraw: ");
                double sum = input.nextDouble();
                bank3.withdrawBalance(connection, phone_number, sum);
                UserScreen(phone_number);
            case 5:
                System.out.println("\n****************************");
                System.out.println("USER SUCCESSFULLY SIGNED OUT");
                System.out.println("****************************\n");
                MainScreen();
            default:
                System.out.println("\nUNKNOWN COMMAND");  //printing the error message
                UserScreen("null");   //calling the UserScreen method
        }
    }
    public void AdminScreen(){
        DBMethods db = new DBMethods();
        Connection connection = db.connect_to_DB(); //creating an object of the Connection class
        Scanner input = new Scanner(System.in); //creating an object of the Scanner class
        System.out.println("TAZA - ONLINE BANK\n1)Show All Clients Information\n2)Delete User\n3)Sign Out");    //printing the user screen
        System.out.print("Choose option: ");    //printing the option to choose
        int choice = input.nextInt();   //getting the user input
        switch(choice){ //switch statement
            case 1:
                db.read_data_of_clients(connection);
                System.out.print("\n");
                AdminScreen();
            case 2:
                System.out.print("Enter ID Of The Client To Delete: ");
                int input_id = input.nextInt();
                try{
                    db.delete_row_by_id(connection, input_id);
                    System.out.println("Client Successfully Deleted\n");
                    AdminScreen();
                }catch(Exception e){
                    System.out.println("There Is No Client With Such ID\n");
                    AdminScreen();
                }
            case 3:
                System.out.println("\n*************************************");
                System.out.println("ADMINISTRATOR SUCCESSFULLY SIGNED OUT");
                System.out.println("*************************************\n");
                MainScreen();
            default:
                System.out.println("\nUNKNOWN COMMAND");  //printing the error message
                AdminScreen();   //calling the UserScreen method
        }
    }
}