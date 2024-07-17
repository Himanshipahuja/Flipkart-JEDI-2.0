package com.flipkart.business;

import com.flipkart.bean.Booking;
import com.flipkart.bean.GymCentre;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements  CustomerServiceInterface{

    public static Scanner scanner = new Scanner(System.in);

    @Override
    public void CustomerLogin() {

    }

    @Override
    public List<GymCentre> getAllGymCenterDetailsByCity(String city) {
        return List.of();
    }

    @Override
    public List<Booking> getCustomerBookings(String customerId) {
        return List.of();
    }

    @Override
    public boolean bookSlot(String userID, Date date, String slotId, String centreId) {
        return false;
    }

    @Override
    public void cancelBooking(String bookingID) {

    }

    @Override
    public void registerCustomer(String userName, String password, String email, String phoneNumber, String cardNumber) {

    }

    @Override
    public boolean customerLogin(String userName, String password) {
        System.out.println("Successfully logged in as Customer");
        return true;
    }

    @Override
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
    }

    @Override
    public void customerChangePassword(String userName,String old_password,String new_password){
        System.out.println("Successfully changed the password");
    }
}
