package com.company;
import java.util.Objects;
import java.util.Scanner;
public class SignUp {
    public void user_input(){
        Scanner input = new Scanner(System.in); //create scanner object
        System.out.print("First and Last name: ");  //ask for first and last name
        String line = input.nextLine(); //read line
        String[] names = line.split(" ");
        String firstname = names[0];
        String lastname = names[1];
        String phone_number_str = input.next();
        int phone_number = Integer.parseInt(phone_number_str);
        System.out.print("Date of Birth (YYYY-MM-DD): ");
        String DateOfBirth = input.nextLine();
        password_check();
    }
    public void password_check(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your new password: ");
        String password1 = input.nextLine();
        System.out.print("Enter your new password again: ");
        String password2 = input.next();

        if(Objects.equals(password1, password2)){
            System.out.println("*******************************");
            System.out.println("NEW USER SUCCESSFULLY SIGNED UP");
            System.out.println("*******************************\n");
            Screen scr = new Screen();
            scr.MainScreen();
        }else{
            password_check();
        }
    }
}
