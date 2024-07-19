package com.flipkart.client;


import com.flipkart.bean.Booking;
import com.flipkart.bean.Customer;
import com.flipkart.business.CustomerServiceImpl;

import java.time.LocalDateTime;
import java.util.List;
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
            System.out.println("Invalid Credentials!");
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
        System.out.println("---------------------------------------------------------------------------");
    }
    private void printUserPlan(String userName){
        System.out.println("Bookings : ");
//        List<UserPlan> allUserPlan= customerService.getCustomerPlan(userName);
        List<Booking> bookingList = customerService.getCustomerBookings(userName);
        if (bookingList.isEmpty()) {
            System.out.println("No bookings found for user: " + userName);
            return;
        }

        // Print header
        System.out.printf("%-15s %-10s %-10s %-20s%n", "Booking ID", "User ID", "Slot ID", "Time");
        System.out.println("---------------------------------------------------------------");

        // Iterate over the list and print each booking
        for (Booking booking : bookingList) {
            System.out.printf("%-15s %-10s %-10s %n",
                    booking.getBookingId(),
                    booking.getUserId(),
                    booking.getScheduleId());
        }
    }
    public void customerClientMainPage(String username) {
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Welcome to customer main page!!");
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("Login TIME: "+currentTime);
        System.out.println("---------------------------------------------------------------------------");

        while(true) {
            System.out.println("1. View Profile \n2. Book a slot in Gym \n3. View Bookings\n4. Cancel Bookings\n5. Go Back to previous menu");
            System.out.println("---------------------------------------------------------------------------");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:

                    System.out.println("Hi "+username);
                    Customer customer= customerService.viewMyProfile(username);
                    printCustomerProfile(customer);
                    break;
                case 2:
                    System.out.println("Viewing all Available slots");

                    break;
                case 3:

                    printUserPlan(username);

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
