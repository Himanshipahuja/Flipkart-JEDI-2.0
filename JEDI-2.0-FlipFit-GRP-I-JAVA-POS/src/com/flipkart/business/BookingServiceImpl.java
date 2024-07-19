package com.flipkart.business;

import com.flipkart.bean.Booking;
import com.flipkart.dao.BookingDAOImpl;

import java.util.Date;
import java.util.List;

public class BookingServiceImpl implements BookingServiceInterface{
    private final BookingDAOImpl bookingDAO = new BookingDAOImpl();
//    private final SlotServiceImpl slotService = new SlotServiceImpl();

    public boolean checkBookingOverlap(String customerId, Date date, String slotId){
        return true;
    }

    public void addBooking(String userName, String scheduleID) {
    }

    public List<Booking> getBookingByCustomerId(String customerId){
        return bookingDAO.getBookingByCustomerId(customerId);
    }

//

    public void cancelBooking(String bookingID) {
    }

}
