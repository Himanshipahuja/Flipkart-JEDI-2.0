package com.flipkart.client;


import com.flipkart.business.CustomerServiceImpl;

import java.time.LocalDateTime;
import java.util.Scanner;

import static com.flipkart.constants.Constants.INVALID_CHOICE_ERROR;
import static com.flipkart.constants.Constants.PREVIOUS_MENU_MESSAGE;


public class CustomerFlipfitMenu {
    public static Scanner scanner = new Scanner(System.in);

    CustomerServiceImpl customerService = new CustomerServiceImpl();

    public void customerLogin(String userName, String password) {
        if(customerService.customerLogin(userName, password)) {
            customerClientMainPage();
        }
        else{
            System.out.println("Login failed!!");
        }
    }

    public void register() {
        customerService.register();
        customerClientMainPage();
    }

    public void customerClientMainPage() {
        System.out.println("Welcome to customer main page!!");
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("WELCOME"+" !!\nWhat you what to do\nLogin TIME: "+currentTime);
        while(true) {
            System.out.println("1. View Profile \n2. Book a slot in Gym \n3. View Bookings\n4. Cancel Bookings\n5. Go Back to previous menu");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:

                    System.out.println("Viewing Customer Profile");
                    break;
                case 2:
                    System.out.println("Viewing all Available slots");

                    break;
                case 3:

                    System.out.println("Viewing all Bookings");
                    break;
                case 4:
                    System.out.println("All bookings for cancel are shown");

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
        customerService.customerChangePassword(userName, old_password, new_password);
    }

}
