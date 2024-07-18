package com.flipkart.client;


import com.flipkart.bean.Customer;
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
            customerClientMainPage(userName);
        }
        else{
            System.out.println("Login failed, sorry bro");
        }
    }

    public void register() {
        String username = customerService.register();
        customerClientMainPage(username);
    }

    public void printCustomerProfile(Customer customer) {
        System.out.println("------------------------------------------------------------------------");
        System.out.println("USER ID: "+ customer.getUserID());
        System.out.println("USER NAME: "+ customer.getUserName());
        System.out.println("EMAIL: "+  customer.getEmail());
        System.out.println("CONTACT: "+  customer.getCustomerPhone());
        System.out.println("CARD DETAILS: "+  customer.getCardDetails());

    }

    public void customerClientMainPage(String username) {
        System.out.println("Welcome to customer main page!!");
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("WELCOME"+" !!\nWhat you what to do\nLogin TIME: "+currentTime);

        while(true) {
            System.out.println("1. View My Profile \n2. Book a slot in a Gym \n3. View Bookings\n4. Cancel Bookings\n5. Go Back to previous menu");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:

                    System.out.println("Hi "+username);
                    Customer customer= customerService.viewMyProfile(username);
                    printCustomerProfile(customer);
                    break;
                case 2:
                    System.out.println("AVAILABLE SLOTS ARE SHOWN");

                    break;
                case 3:

                    System.out.println("CUSTOMER BOOKINGS ARE SHOWN");
                    break;
                case 4:
                    System.out.println("BOOKINGS ARE SHOWN");

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
