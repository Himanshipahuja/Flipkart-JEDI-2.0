package com.flipkart.business;

import com.flipkart.bean.Booking;
import com.flipkart.bean.GymCentre;

import java.sql.Date;
import java.util.List;

public interface CustomerServiceInterface {
    void CustomerLogin();
    List<GymCentre> getAllGymCenterDetailsByCity(String city);
    List<Booking> getCustomerBookings(String customerId);
    boolean bookSlot(String userID,Date date, String slotId,String centreId);
    void cancelBooking(String bookingID);
    void registerCustomer(String userName, String password, String email, String phoneNumber, String cardNumber);


}
