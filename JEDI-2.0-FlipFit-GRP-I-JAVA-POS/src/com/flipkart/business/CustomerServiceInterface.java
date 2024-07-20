package com.flipkart.business;

import com.flipkart.bean.BookingDetails;
import com.flipkart.bean.Customer;
import com.flipkart.bean.GymCentre;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

public interface CustomerServiceInterface {
    void CustomerLogin();
    List<GymCentre> getAllGymCenterDetailsByCity(String city);
    List<BookingDetails> getCustomerBookings(String customerId);
    boolean bookSlot(String userID,Date date, String slotId,String centreId);
    void cancelBooking(String bookingID);
    public Customer registerCustomer(String userName, String password, String email,
                                     String phoneNumber, String cardNumber);
    public boolean customerLogin(String userName, String password);
    public Customer register();
    public Customer viewMyProfile(String username);
    public void customerChangePassword(String userName,String old_password,String new_password);
    public String getSlotIdFromGymCentreAndTimestamp(String gymOwner, Timestamp timestamp);
    public String getCustomerIdFromNameAndPass(String userName, String password);
    public Integer getBookingCountFromSlotId(String slotId);
    public Integer getGymCentreCapacityFromCentreId(String centerId);
    public String addSchedule(Timestamp timestamp, String slotId);
}
