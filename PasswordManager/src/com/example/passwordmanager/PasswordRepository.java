package com.example.passwordmanager;

import java.util.ArrayList;
import java.util.List;

import com.example.passwordmanager.exceptions.PasswordNotFoundException;

public class PasswordRepository {

    private List<Password> passwords;

    public PasswordRepository() {
        passwords = new ArrayList<Password>();
    }

    public void addPassword(Password password) {
        passwords.add(password);
    }

    public List<Password> getAllPasswords() {
        return passwords;
    }

    public Password getPasswordByName(String name) throws PasswordNotFoundException {
        for (Password p : passwords) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        throw new PasswordNotFoundException();
    }

}
