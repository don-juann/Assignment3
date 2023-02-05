package com.company;
import java.util.Objects;
import java.util.Scanner;
public class SignIn {
    public void signIn(){
        Scanner input = new Scanner(System.in);     //create scanner object
        System.out.print("Enter your phone number: ");  //ask for first and last name
        String phone_number_str = input.nextLine(); //read line
        int phone_number = Integer.parseInt(phone_number_str);  //convert string to int
        System.out.print("Enter your password: ");      //ask for password
        String password = input.nextLine();    //read line
        //sign in as client
    }
}
