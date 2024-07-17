package com.flipkart.client;


import java.time.LocalDateTime;
import java.util.Scanner;

import static com.flipkart.constants.Constants.INVALID_CHOICE_ERROR;
import static com.flipkart.constants.Constants.PREVIOUS_MENU_MESSAGE;


public class CustomerFlipfitMenu {
    public static Scanner scanner = new Scanner(System.in);

    public boolean customerLogin(String userName, String password) {
        System.out.println("Successfully logged in as Customer");
        customerClientMainPage();
        return true;
    }

    public void register() {
        System.out.println("Enter your UserName");
        String userName = scanner.next();

        System.out.println("Enter your Passkey");
        String password = scanner.next();

        System.out.println("Enter your Email");
        String email = scanner.next();

        System.out.println("Enter your Phone Number");
        String phoneNumber = scanner.next();

        System.out.println("Enter your Card Number");
        String cardNumber = scanner.next();

        System.out.println("Successfully REGISTERED as Customer");

        System.out.println("\t User Name: " + userName);
        System.out.println("\t email: " + email);
        System.out.println("\t PAN Number: " + phoneNumber);
        System.out.println("\t Card Number: " + cardNumber);
        customerClientMainPage();

    }

    public void customerClientMainPage() {
        System.out.println("Welcome to customer main page!!");
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("WELCOME <USERNAME>"+" !!\nWhat you what to do\nLogin TIME: "+currentTime);
        while(true) {
            System.out.println("1. View My Profile \n2. Book a slot in a Gym \n3. View Bookings\n4. Cancel Bookings\n5. Go Back to previous menu");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
//                    printCustomerProfile(customer);
                    System.out.println("CUSTOMER PROFILE");
                    break;
                case 2:
                    System.out.println("AVAILABLE SLOTS ARE SHOWN");
//                    bookSlotSubMenu(userName);
                    break;
                case 3:
//                    printUserPlan(userName);
                    System.out.println("CUSTOMER BOOKINGS ARE SHOWN");
                    break;
                case 4:
                    System.out.println("BOOKINGS ARE SHOWN");
//                    cancelBookingSubMenu(userName);
                    break;
                case 5:
                    System.out.println(PREVIOUS_MENU_MESSAGE);
                    return;
                default:
                    System.out.println(INVALID_CHOICE_ERROR);
                    break;
            }
        }
    }

    public void customerChangePassword(String userName,String old_password,String new_password){
        System.out.println("Successfully changed the password");
    }

}
