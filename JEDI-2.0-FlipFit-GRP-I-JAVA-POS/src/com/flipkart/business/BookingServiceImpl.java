package com.flipkart.business;
import com.flipkart.bean.BookingDetails;
import com.flipkart.dao.BookingDAOImpl;

import java.util.Date;
import java.util.List;
import com.flipkart.exceptions.BookingFailedException;

public class BookingServiceImpl implements BookingServiceInterface{
    private final BookingDAOImpl bookingDAO = new BookingDAOImpl();

    public boolean checkBookingOverlap(String customerId, Date date, String slotId){
        return true;
    }

    public void addBooking(String userName, String scheduleID) {
    }

    public List<BookingDetails> getBookingByCustomerId(String username){
        return bookingDAO.getBookingByCustomerId(username);
    }

//

    public void cancelBooking(String bookingID) {
        try {
            bookingDAO.cancelBookingById(bookingID);
        } catch (BookingFailedException e) {
            System.out.println(e.getMessage());
        }

    }

}
