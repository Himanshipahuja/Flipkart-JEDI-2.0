package com.flipkart.business;

import com.flipkart.bean.BookingDetails;

import java.util.Date;
import java.util.List;

public interface BookingServiceInterface {
    List<BookingDetails> getBookingByCustomerId(String username);
    void cancelBooking(String bookingID);

}
