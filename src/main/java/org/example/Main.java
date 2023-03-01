package org.example;

import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static Map<String, String> login = new HashMap<>();

    final static String outputFilePath = "src/main/resources/data.txt";

    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/data.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                String email = parts[0];
                String password = parts[1];
                login.put(email, password);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error has occurred!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        run();

    }

    public static void run() {

        Scanner sc = new Scanner(System.in);

        login.put("admin@login.com", "adminpassword");

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
            System.out.println("This email does not exist in our database! Type 'register' to register an email or type 'back' to try it again");

            String after = sc.nextLine();

            if(after.equals("register")) {
                System.out.println("What is your email that you want to use");

                String email1 = sc.nextLine();

                System.out.println("What password do you want to use");

                String password1 = sc.nextLine();

                login.put(email1, password1);

                File file = new File(outputFilePath);

                BufferedWriter bf = null;

                try {
                    bf = new BufferedWriter(new FileWriter(file));

                    for(Map.Entry<String, String> entry : login.entrySet()) {
                        bf.write(entry.getKey() + ":" + entry.getValue());
                        bf.newLine();
                    }

                    bf.flush();

                } catch (IOException e) {
                    System.out.println("An error occurred!");
                    e.printStackTrace();
                }

                System.out.println("Thank you! You have been registered and you may now login! Relaunch to login!");


            } else {
                if(after.equals("back")) {
                    run();
                } else {
                    if(!after.equals("stop") || !after.equals("register")) {
                        System.out.println("That's not a valid argument. Shutting down the application!");
                        return;
                    }
                }
            }
        }
    }
}
