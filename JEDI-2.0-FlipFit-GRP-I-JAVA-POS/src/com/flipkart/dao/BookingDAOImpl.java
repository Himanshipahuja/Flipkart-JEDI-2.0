package com.flipkart.dao;

import com.flipkart.bean.Booking;
import com.flipkart.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookingDAOImpl {
    public List<Booking> getBookingByCustomerId(String customerId) {
        List<Booking> allBookingList = new ArrayList<>();
        String query = "SELECT b.bookingId, b.userId, s.slotId, s.time FROM booking b JOIN schedule s ON b.scheduleId = s.scheduleId WHERE b.userId = ?";

        try {
            Connection conn = DBConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, customerId);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                Booking booking = new Booking(
                        rs.getString("bookingId"),
                        rs.getString("userID"),
                        rs.getString("scheduleID")
                );

                allBookingList.add(booking);
            }
        }  catch(Exception e) {
            System.out.println("Oops! An error occurred. Try again later.");
        }
        return allBookingList;
    }
}
