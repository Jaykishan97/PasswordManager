package com.example.passwordmanager.exceptions;

public class PasswordNotFoundException extends Exception {

    public PasswordNotFoundException() {
        super("Password not found!");
    }

}
