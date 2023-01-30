package com.company;

public class Main {
    public static void main(String[] args) {
        DBMethods test = new DBMethods();
        test.connect_to_DB("DatabaseOne", "postgres", "0311");

        /*
        database connection, signing in, signing up as customer - Zhan
        signing in, signing up as administrator - Akdaulet
        checking balance and user information - Tolegen
        making deposit and withdrawing money - Aitbek
         */
    }
}