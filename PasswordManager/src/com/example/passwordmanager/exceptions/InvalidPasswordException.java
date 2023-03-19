package com.example.passwordmanager.exceptions;

public class InvalidPasswordException extends Exception {

    public InvalidPasswordException() {
        super("Password is not strong enough!");
    }

}
