package com.flipkart.client;

import java.util.Scanner;

public class GymOwnerClient {

    public static Scanner scanner = new Scanner(System.in); // has to be imported from main client

    public boolean gymOwnerLogin(String userName, String password) {
        gymOwnerClientMainPage();
        System.out.println("Successfully logged in as Gym Owner");
        return true;
    }

    public void register() {
        gymOwnerClientMainPage();
        System.out.println("Enter your UserName");
        String userName = scanner.next();

        System.out.println("Enter your Passkey");
        String password = scanner.next();

        System.out.println("Enter your Email");
        String email = scanner.next();

        System.out.println("Enter your PAN Number");
        String panNumber = scanner.next();

        System.out.println("Enter your Card Number");
        String cardNumber = scanner.next();

        System.out.println("Registered successfully with: ");
        System.out.println("\t User Name: " + userName);
        System.out.println("\t email: " + email);
        System.out.println("\t PAN Number: " + panNumber);
        System.out.println("\t Card Number: " + cardNumber);
    }

    public void gymOwnerChangePassword(String userName,String old_password,String new_password){
        System.out.println("Successfully changed the password");
    }

    public void gymOwnerClientMainPage() {
        System.out.println("Welcome to gym owner main page!!");
    }
}