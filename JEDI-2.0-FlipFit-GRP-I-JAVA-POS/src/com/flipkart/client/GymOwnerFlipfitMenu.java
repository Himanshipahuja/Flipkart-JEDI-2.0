package com.flipkart.client;

import com.flipkart.business.GymOwnerServiceImpl;

import java.util.Scanner;

import static com.flipkart.constants.Constants.INVALID_CHOICE_ERROR;
import static com.flipkart.constants.Constants.PREVIOUS_MENU_MESSAGE;
public class GymOwnerFlipfitMenu {

    public static Scanner scanner = new Scanner(System.in); // has to be imported from main client

    GymOwnerServiceImpl gymOwnerService = new GymOwnerServiceImpl();

    public boolean gymOwnerLogin(String userName, String password) {
        gymOwnerService.gymOwnerLogin(userName, password);
        gymOwnerClientMainPage();
        return true;
    }

    public void register() {
        gymOwnerService.register();
        gymOwnerClientMainPage();
    }

    public void gymOwnerChangePassword(String userName,String old_password,String new_password){
        gymOwnerService.gymOwnerChangePassword(userName, old_password, new_password);
    }

    public void gymOwnerClientMainPage() {
        System.out.println("Welcome to gym owner main page!!");
        while(true) {
            System.out.println("" +
                    "0. View all Gym Centres\n" +
                    "1. Send Gym Owner Approval Request\n" +
                    "2. Add new Gym Center\n" +
                    "3. Request Gym Centre Approval\n" +
                    "4. Add Slots to Gym Centre\n" +
                    "5. Go Back to Previous Menu"
            );
            int choice = scanner.nextInt();
            switch(choice){
                case 0:
                    System.out.println("Viewing all gym centers\n");
                    break;

                case 1:
                    System.out.println("Gym owner request sent to Admin\n");
                    break;

                case 2:
                    System.out.println("New Gym center added\n");
                    break;

                case 3:
                    System.out.println("Gym Centre Approval Request sent to Admin\n");
                    break;

                case 4:
                    System.out.println("Slots added in the Gym centre\n");
                    break;

                case 5:
                    System.out.println(PREVIOUS_MENU_MESSAGE);
                    return;
                default:
                    System.out.println(INVALID_CHOICE_ERROR);
            }
        }

    }
}