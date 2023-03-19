package com.example.passwordmanager.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.passwordmanager.exceptions.InvalidPasswordException;

public class PasswordValidator {

    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{" + MIN_PASSWORD_LENGTH + ",}$");

    public static void validate(String password) throws InvalidPasswordException {
        Matcher matcher = PASSWORD_PATTERN.matcher(password);
        if (!matcher.matches()) {
            throw new InvalidPasswordException();
        }
    }

}
