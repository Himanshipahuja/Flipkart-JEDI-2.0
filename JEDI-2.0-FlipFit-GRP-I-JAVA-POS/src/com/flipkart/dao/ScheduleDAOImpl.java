package com.flipkart.dao;

import com.flipkart.bean.GymCentre;
import com.flipkart.constants.SQLConstants;
import com.flipkart.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ScheduleDAOImpl implements ScheduleDAO{

    private Connection conn = null;
    private PreparedStatement statement = null;

    @Override
    public Integer getSlotsBookedCountFromSlotId(String slotId) {
        Integer bookingCount = 0;
        try {
            conn = DBConnection.connect();
            System.out.println("Fetching count of booked slots");

            statement = conn.prepareStatement(SQLConstants.GET_BOOKED_SLOT_COUNT_FROM_SLOTID);
            statement.setString(1, slotId);
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                bookingCount = rs.getInt("count(*)");
            }

        } catch (SQLException e) {
            System.out.println("SQL error");
            throw new RuntimeException(e);
        }
        return bookingCount;
    }
}
