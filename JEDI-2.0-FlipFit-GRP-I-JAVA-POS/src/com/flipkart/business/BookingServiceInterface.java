package com.flipkart.business;

import com.flipkart.bean.BookingDetails;

import java.util.Date;
import java.util.List;

public interface BookingServiceInterface {
    boolean checkBookingOverlap(String customerId, Date date, String slotId);
    void addBooking(String userId, String scheduleID);
    List<BookingDetails> getBookingByCustomerId(String username);
    void cancelBooking(String bookingID);

}
