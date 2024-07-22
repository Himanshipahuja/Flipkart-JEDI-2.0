package com.flipkart.dao;

import com.flipkart.bean.BookingDetails;
import com.flipkart.exceptions.BookingFailedException;
import com.flipkart.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingDAOImpl {
    public List<BookingDetails> getBookingByCustomerId(String username) throws BookingFailedException {
        List<BookingDetails> allBookingDetailsList = new ArrayList<>();
        String getUserIdQuery = "SELECT userId FROM user WHERE userName = ?";
        String getBookingsQuery = "SELECT b.bookingId, b.userId, b.scheduleId, s.slotId, slot.centreId, gym_center.centerName, gym_center.city, s.date FROM booking b JOIN schedule s ON b.scheduleId = s.scheduleId JOIN slot ON s.slotId = slot.slotId JOIN gym_center ON slot.centreId = gym_center.centerId WHERE b.userId = ?";


        try {
            Connection conn = DBConnection.connect();

            // Step 1: Get userId using username
            PreparedStatement getUserIdStmt = conn.prepareStatement(getUserIdQuery);
            getUserIdStmt.setString(1, username);
            ResultSet userIdRs = getUserIdStmt.executeQuery();

            String userId = null;
            if (userIdRs.next()) {
                userId = userIdRs.getString("userId");
            } else {
                return allBookingDetailsList; // Return empty list if no user found
            }

            // Step 2: Get bookings using userId
            PreparedStatement getBookingsStmt = conn.prepareStatement(getBookingsQuery);
            getBookingsStmt.setString(1, userId);
            ResultSet bookingsRs = getBookingsStmt.executeQuery();


            while (bookingsRs.next()) {
//                System.out.println("Result set has data");
                BookingDetails bookingDetails = new BookingDetails(
                        bookingsRs.getString("bookingId"),
                        bookingsRs.getDate("date"),
                        bookingsRs.getString("centerName"),
                        bookingsRs.getString("city")
                );
                allBookingDetailsList.add(bookingDetails);
            }

        }catch(SQLException sql) {
            throw new BookingFailedException("Could not retrieve Bookings by customer id:  " + username);
        }  catch (Exception e) {
            System.out.println("Oops! An error occurred. Try again later.");
            e.printStackTrace();
        }
        return allBookingDetailsList;
    }

    public String addBooking(String username, String scheduleId) {
        return username;
    }
}
