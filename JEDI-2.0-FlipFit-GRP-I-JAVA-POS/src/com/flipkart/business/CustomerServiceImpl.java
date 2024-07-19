package com.flipkart.business;

import com.flipkart.bean.Booking;
import com.flipkart.bean.Customer;
import com.flipkart.bean.GymCentre;
import com.flipkart.dao.CustomerDAOImpl;
import com.flipkart.dao.CustomerDAO;
import com.flipkart.dao.GymCenterDAO;
import com.flipkart.dao.GymCenterDAOImpl;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements  CustomerServiceInterface{

    public static Scanner scanner = new Scanner(System.in);
    private final CustomerDAO customerDAO = new CustomerDAOImpl();
    private final GymCenterDAO gymCenterDAO = new GymCenterDAOImpl();
    private final BookingServiceInterface bookingService = new BookingServiceImpl();

    @Override
    public void CustomerLogin() {

    }

    @Override
    public List<GymCentre> getAllGymCenterDetailsByCity(String city) {
        return gymCenterDAO.getGymCentreListByCity(city);
    }

    @Override
    public List<Booking> getCustomerBookings(String customerId){
        //takes userId and returns List<Bookings>
        return bookingService.getBookingByCustomerId(customerId);
    }
    @Override
    public boolean bookSlot(String userID, Date date, String slotId, String centreId) {
        return false;
    }

    @Override
    public void cancelBooking(String bookingID) {

    }

    @Override
    public Customer registerCustomer(String userName, String password, String email, String phoneNumber, String cardNumber) {
        return customerDAO.registerCustomer(userName, password, email, phoneNumber, cardNumber);
    }

    @Override
    public boolean customerLogin(String userName, String password) {
        if (customerDAO.checkCustomerDetails(userName, password)) {
            System.out.println("Successfully logged in as Customer");
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Customer register() {
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

        Customer registeredCustomer = registerCustomer(userName, password, email, phoneNumber, cardNumber);
        System.out.println("Successfully registered as Customer");

        return registeredCustomer;
    }

    @Override
    public String getCustomerIdFromNameAndPass(String userName, String password) {
        return customerDAO.getCustomerIdFromNameAndPass(userName, password);
    }

    @Override
    public Customer viewMyProfile(String username)
    {
        return customerDAO.getCustomerById(username);
    }

    @Override
    public void customerChangePassword(String userName,String old_password,String new_password) {
        customerDAO.changeCustomerPassword(userName, old_password, new_password);
    }
}
