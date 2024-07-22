package com.flipkart.business;

import com.flipkart.bean.BookingDetails;
import com.flipkart.bean.Customer;
import com.flipkart.bean.GymCentre;
import com.flipkart.dao.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

import com.flipkart.exceptions.BookingFailedException;
import com.flipkart.exceptions.RegistrationFailedException;
import com.flipkart.exceptions.UserInvalidException;
import com.flipkart.exceptions.WrongCredentialsException;


public class CustomerServiceImpl implements  CustomerServiceInterface{

    public static Scanner scanner = new Scanner(System.in);
    private final CustomerDAO customerDAO = new CustomerDAOImpl();
    private final GymCenterDAO gymCenterDAO = new GymCenterDAOImpl();
    private final SlotDAO slotDAO = new SlotDAOImpl();
    private final ScheduleDAO scheduleDAO = new ScheduleDAOImpl();
    private final BookingServiceInterface bookingService = new BookingServiceImpl();

    @Override
    public List<GymCentre> getAllGymCenterDetailsByCity(String city) {
        return gymCenterDAO.getGymCentreListByCity(city);
    }

    @Override
    public List<BookingDetails> getCustomerBookings(String username){
        //takes userId and returns List<Bookings>
        return bookingService.getBookingByCustomerId(username);
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
        try {
            return customerDAO.registerCustomer(userName, password, email, phoneNumber, cardNumber);
        } catch (RegistrationFailedException e) {
            e.getMessage();
        }
        return null;


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

        try {
            Customer registeredCustomer= customerDAO.registerCustomer(userName, password, email, phoneNumber, cardNumber);
            System.out.println("Successfully registered as Customer");
            return registeredCustomer;

        } catch (RegistrationFailedException e) {
            e.getMessage();
        }
        return null;
    }

    @Override
    public String getCustomerIdFromNameAndPass(String userName, String password) throws WrongCredentialsException {
        return customerDAO.getCustomerIdFromNameAndPass(userName, password);
    }

    @Override
    public Integer getBookingCountFromSlotId(String slotId) {
        return scheduleDAO.getSlotsBookedCountFromSlotId(slotId);
    }

    @Override
    public Integer getGymCentreCapacityFromCentreId(String centerId) {
        return gymCenterDAO.getCapacityFromCenterId(centerId);
    }

    @Override
    public String addSchedule(Timestamp timestamp, String slotId) {
        return scheduleDAO.addSchedule(timestamp,slotId);
    }

    @Override
    public String getSlotIdFromGymCentreAndTimestamp(String gymOwner, Timestamp timestamp) {
        return slotDAO.getSlotbyCentreIdAndTimeStamp(gymOwner,timestamp);
    }

    public Customer viewMyProfile(String username)
    {
        return customerDAO.getCustomerById(username);
    }

    @Override
    public void customerChangePassword(String userName,String old_password,String new_password) throws WrongCredentialsException {
        customerDAO.changeCustomerPassword(userName, old_password, new_password);
    }

}
