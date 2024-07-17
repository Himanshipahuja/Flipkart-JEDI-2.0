package com.flipkart.client;

import java.util.Scanner;

public class GymOwnerFlipfitMenu {

    public static Scanner scanner = new Scanner(System.in); // has to be imported from main client

    public boolean gymOwnerLogin(String userName, String password) {
        System.out.println("Successfully logged in as Gym Owner");
        gymOwnerClientMainPage();
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
        while(true) {
            System.out.println("" +
                    "0. View all my Gym Centres\n" +
                    "1. Sending Gym Owner Approval Request\n" +
                    "2. Add a new Gym Center\n" +
                    "3. Send a Gym Centre Approval Request to Admin\n" +
                    "4. Add Slots to a Gym Centre\n" +
                    "5. Go Back to Previous Menu"
            );
            int choice = scanner.nextInt();
            switch(choice){
                case 0:
                    System.out.println("Viewing all gym centers");
                    break;

                case 1:
                    System.out.println("Gym owner request sent");
                    break;

                case 2:
                    System.out.println("New Gym center added");
                    break;

                case 3:
                    System.out.println("Gym Centre Approval Request sent to Admin");
                    break;

                case 4:
                    System.out.println("Slots added in the Gym centre");
                    break;

                case 5:
                    System.out.println("Inside previous menu");
                    break;
                default:
                    System.out.println("Enter valid choice");
            }
        }

    }
}