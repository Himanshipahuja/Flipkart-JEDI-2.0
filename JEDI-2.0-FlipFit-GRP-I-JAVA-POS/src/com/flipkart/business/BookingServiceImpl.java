package com.flipkart.business;

import com.flipkart.bean.Booking;
import com.flipkart.bean.BookingDetails;
import com.flipkart.dao.BookingDAOImpl;

import java.util.Date;
import java.util.List;
import com.flipkart.exceptions.BookingFailedException;

public class BookingServiceImpl implements BookingServiceInterface{
    private final BookingDAOImpl bookingDAO = new BookingDAOImpl();

    @Override
    public List<BookingDetails> getBookingByCustomerId(String username){
        return bookingDAO.getBookingByCustomerId(username);
    }

    @Override
    public void cancelBooking(String bookingID) {
        try {
            Booking booking  = bookingDAO.getBookingByBookingId(bookingID);
            bookingDAO.cancelBookingById(bookingID);
//            scheduleService.modifySchedule(booking.getScheduleID(),1);
        } catch (BookingFailedException e) {
            System.out.println(e.getMessage());
        }

    }

}
