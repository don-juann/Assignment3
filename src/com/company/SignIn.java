package com.company;
import java.util.Objects;
import java.util.Scanner;
public class SignIn {
    public void user_input(){
        Scanner input = new Scanner(System.in);     //create scanner object
        System.out.print("Phone number: ");  //ask for first and last name
        String phone_number = input.nextLine(); //read line
        System.out.print("Password: ");      //ask for password
        String password = input.nextLine();    //read line
        //sign in as client
    }
}
