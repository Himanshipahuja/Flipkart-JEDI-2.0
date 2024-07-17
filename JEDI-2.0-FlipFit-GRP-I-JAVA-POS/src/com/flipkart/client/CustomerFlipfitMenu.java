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
            System.out.println("Login failed, sorry bro");
        }
    }

    public void register() {
        customerService.register();
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
        customerService.customerChangePassword(userName, old_password, new_password);
    }

}
