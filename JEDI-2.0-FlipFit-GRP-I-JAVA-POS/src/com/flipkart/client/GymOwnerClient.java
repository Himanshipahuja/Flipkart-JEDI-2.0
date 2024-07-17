package com.flipkart.client;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static com.flipkart.constants.ColourConstants.RESET_COLOR;
import static com.flipkart.constants.ColourConstants.YELLOW_COLOR;
import static com.flipkart.constants.ErrorConstants.INVALID_CHOICE_ERROR;
import static com.flipkart.constants.PromptConstants.PREVIOUS_MENU_MESSAGE;

public class GymOwnerClient {

    public static Scanner scanner = new Scanner(System.in); // has to be imported from main client

    public boolean gymOwnerLogin(String userName, String password) {
        System.out.println("Successfully logged in");
        return true;
    }

    public void register() {
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
        gymOwnerClientMainPage(userName);
    }



    public void gymOwnerClientMainPage(String gymOwnerId) {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = currentTime.format(myFormat);
        System.out.println(YELLOW_COLOR+"WELCOME "+gymOwnerId+" !!\nWhat you what to do\nLogin TIME: "+currentTime+RESET_COLOR);
        while(true){
            System.out.println("" +
                    "0. View all my Gym Centres\n" +
                    "1. Sending Gym Owner Approval Request\n" +
                    "2. Add a new Gym Center\n" +
                    "3. Send a Gym Centre Approval Request to Admin\n" +
                    "4. Add Slots to a Gym Centre\n" +
                    "5. Go Back to Previous Menu"
            );
            int choice = scanner.nextInt();
            switch (choice){
                /* Take input from user for all service parameters ( Make the menu ) */

                case 0:
                    break;

                case 1:
                    break;

                case 2:

                    System.out.println("Enter gym centre id: ");
                    String gymId = scanner.next();

                    System.out.println("Enter Gym Centre name: ");
                    String gymCentreName = scanner.next();

                    System.out.println("Enter Gym Centre GSTIN: ");
                    String gstin = scanner.next();

                    System.out.println("Enter Gym Centre city: ");
                    String city = scanner.next();

                    System.out.println("Enter Gym Centre capacity: ");
                    int capacity = scanner.nextInt();

                    System.out.println("Enter price: : ");
                    int price = scanner.nextInt();

                    break;

                case 3:

                    System.out.println("Enter Gym Centre Id: ");
                    String gymCentreId = scanner.next();
                    break;

                case 4:

                    boolean isAdding = true;
                    String centreId = null;

                    while (isAdding) {
                        System.out.println("Enter new slot id: ");
                        String slotId = scanner.next();

                        System.out.println("Enter Gym Centre Id: ");
                        centreId = scanner.next();

                        System.out.println("Enter time in 24h format (hh:mm:ss) : ");
                        String time = scanner.next();

                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                        LocalTime localTime = LocalTime.parse(time, formatter);

                        System.out.println("Do you want to enter more slots (y/n)?: ");
                        String addChoice = scanner.next();
                        addChoice = addChoice.toLowerCase();

                        if(addChoice.equals("n") || addChoice.equals("no")) {
                            isAdding = false;
                        }
                    }
                case 5:
                    System.out.println(PREVIOUS_MENU_MESSAGE);
                    return;
                default:
                    System.out.println(INVALID_CHOICE_ERROR);
                    break;
            }
        }
    }
}