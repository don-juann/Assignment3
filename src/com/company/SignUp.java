package com.company;
import java.util.Objects;
import java.util.Scanner;
public class SignUp {
    String thepassword;
    public void user_input(){
        Scanner input = new Scanner(System.in);
        System.out.print("First and Last name: ");
        String line = input.nextLine();
        String[] names = line.split(" ");
        String firstname = names[0];
        String lastname = names[1];

        System.out.print("Date of Birth (YYYY-MM-DD): ");
        String DateOfBirth = input.next();

        System.out.print("Phone number(starting with 8): ");
        String phone_number= input.next();

        password_check();

        Client cl = new Client(firstname, lastname, phone_number, DateOfBirth, thepassword);
        cl.setFields();

        Screen scr = new Screen();
        scr.MainScreen();
    }
    public void password_check(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your new password: ");
        String password1 = input.nextLine();
        System.out.print("Enter your new password again: ");
        String password2 = input.next();

        if(Objects.equals(password1, password2)){
            thepassword = password2;
            System.out.println("*******************************");
            System.out.println("NEW USER SUCCESSFULLY SIGNED UP");
            System.out.println("*******************************\n");
        }else{
            System.out.println("PASSWORDS DO NOT MATCH, TRY AGAIN");
            password_check();
        }
    }
}
