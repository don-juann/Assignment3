package com.company;
import java.util.Objects;
import java.util.Scanner;
public class SignIn {
    public void user_input(){
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("Phone number: ");
            String phone_number = input.next();
            System.out.print("Password: ");
            String password1 = input.next();
            Client client = new Client();
            if(client.signin_check(phone_number, password1)) {
                System.out.println("\nUSER SUCCESSFULLY SIGNED IN");
                Screen screen = new Screen();
                screen.UserScreen();
            } else{
                System.out.println("\nPHONE NUMBER OR PASSWORD IS INCORRECT, TRY AGAIN");
                Screen screen = new Screen();
                screen.caseOne();
            }

        }catch(Exception e){
            System.out.println(e);
        }
    }

}