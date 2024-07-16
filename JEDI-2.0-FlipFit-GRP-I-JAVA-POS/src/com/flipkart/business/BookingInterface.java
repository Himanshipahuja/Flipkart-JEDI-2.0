package com.flipkart.business;

import com.flipkart.bean.Booking;

import java.util.Date;
import java.util.List;

public interface BookingInterface {
    boolean checkBookingOverlap(String customerId, Date date, String slotId);
    void addBooking(String userId, String scheduleID);
    List<Booking> getBookingByCustomerId(String customerId);
    void cancelBooking(String bookingID);

}
