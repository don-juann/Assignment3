package com.company;

public interface IPerson {  //interface
    public boolean signin_check(String number, String password) throws Exception;   //method to check if the user is signed in
}