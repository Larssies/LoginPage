package org.example;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        run();

    }

    public static void run() {
        Scanner sc = new Scanner(System.in);

        Map<String, String> login = new HashMap<>();

        login.put("test@test.com", "password");

        System.out.println("What's your email");

        String email = sc.nextLine();

        if(login.containsKey(email)) {
            System.out.println("What's your password");

            String password = sc.nextLine();

            if(login.get(email).equals(password)) {
                System.out.println("You have been logged in!");
            } else {
                System.out.println("Password incorrect!");
            }
        } else {
            System.out.println("This email does not exist in our database! Type 'register' to register an email or type 'back' to go back");

            String after = sc.nextLine();

            if(after.equals("register")) {
                System.out.println("What is your email that you want to use");

                String email1 = sc.nextLine();

                System.out.println("What password do you want to use");

                String password1 = sc.nextLine();

                login.put(email1, password1);

                System.out.println("Thank you! You have been registered and you may now login!");


            } else {
                if(after.equals("back")) {
                    return;
                }
            }
        }
    }
}