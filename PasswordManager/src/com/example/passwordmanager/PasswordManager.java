package com.example.passwordmanager;

import java.util.List;
import java.util.Scanner;

import com.example.passwordmanager.Password;
import com.example.passwordmanager.PasswordRepository;
import com.example.passwordmanager.exceptions.PasswordNotFoundException;
import com.example.passwordmanager.exceptions.InvalidPasswordException;
import com.example.passwordmanager.validators.PasswordValidator;

public class PasswordManager {
    
    private static PasswordRepository repository = new PasswordRepository();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Password Manager!");
        while (true) {
            System.out.println("1. Add password");
            System.out.println("2. View passwords");
            System.out.println("3. Search password");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addPassword();
                    break;
                case 2:
                    viewPasswords();
                    break;
                case 3:
                    searchPassword();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void addPassword() {
        System.out.print("Enter website or app name: ");
        String name = scanner.nextLine();
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        try {
            PasswordValidator.validate(password);
            Password p = new Password(name, username, password);
            repository.addPassword(p);
            System.out.println("Password added successfully!");
        } catch (InvalidPasswordException e) {
            System.out.println("Invalid password: " + e.getMessage());
        }
    }

    private static void viewPasswords() {
        List<Password> passwords = repository.getAllPasswords();
        if (passwords.isEmpty()) {
            System.out.println("No passwords saved yet!");
        } else {
            System.out.println("Here are your saved passwords:");
            for (Password p : passwords) {
                System.out.println(p.getName() + " | " + p.getUsername() + " | " + p.getPassword());
            }
        }
    }

    private static void searchPassword() {
        System.out.print("Enter website or app name to search: ");
        String name = scanner.nextLine();

        try {
            Password p = repository.getPasswordByName(name);
            System.out.println("Website or app name: " + p.getName());
            System.out.println("Username: " + p.getUsername());
            System.out.println("Password: " + p.getPassword());
        } catch (PasswordNotFoundException e) {
            System.out.println("Password not found for " + name);
        }
    }
}
