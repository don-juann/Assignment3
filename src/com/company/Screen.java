package com.company;

import java.util.Scanner;

public class Screen {
    public void MainScreen(){
        Scanner input = new Scanner(System.in);
        System.out.println("TAZA - ONLINE BANK\n1)SIGN IN\n2)SIGN UP");
        System.out.print("Choose option: ");
        int choice = input.nextInt();
        switch(choice){
            case 1:
                caseOne();
            case 2:
                caseTwo();
            default:
                System.out.println("UNKNOWN COMMAND");
                MainScreen();
        }
    }

    public void caseOne(){
        Scanner input = new Scanner(System.in);
        System.out.println("\nTAZA - ONLINE BANK\n1)SIGN IN as Client\n2)SIGN IN as Administrator");
        System.out.print("Choose option: ");
        int choice = input.nextInt();
        switch(choice){
            case 1:
                //sign in as client

            case 2:
                //sign in as admin

            default:
                System.out.println("UNKNOWN COMMAND\n");
                MainScreen();
        }
    }

    public void caseTwo(){
        SignUp signUp = new SignUp();
        signUp.user_input();
    }
}
