package com.flipkart.dao;

import com.flipkart.bean.GymCentre;
import com.flipkart.bean.Slot;
import com.flipkart.constants.SQLConstants;
import com.flipkart.utils.DBConnection;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class SlotDAOImpl implements SlotDAO {

    private Connection conn = null;
    private PreparedStatement statement = null;


    public SlotDAOImpl() {}

    public List<Slot> getSlotList() {
        List<Slot> slotList = new ArrayList<>();

        String query = "SELECT slotId, centreId, time FROM slot"; // Adjust query according to your table schema

        try (Connection connection = DBConnection.connect()) {
            assert connection != null;
            try (PreparedStatement stmt = connection.prepareStatement(query);
                 ResultSet resultSet = stmt.executeQuery()) {

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                while (resultSet.next()) {
                    String slotId = resultSet.getString("slotId");
                    String centreId = resultSet.getString("centreId");
                    Date slotTime = resultSet.getDate("time");

                    slotList.add(new Slot(slotId, centreId, slotTime));
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return slotList;
    }

    @Override
    public List<Slot> getSlotByCentreId(String gymCentreId) {
        List<Slot> filteredSlotList = new ArrayList<>();
        String query = "SELECT slotId, centreId, time FROM slot WHERE centreId = ?"; // Adjust query according to your table schema

        try (Connection connection = DBConnection.connect();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, gymCentreId);
            try (ResultSet resultSet = stmt.executeQuery()) {
                while (resultSet.next()) {
                    String slotId = resultSet.getString("slotId");
                    String centreName = resultSet.getString("centreId");
                    Date slotTime = resultSet.getDate("time");

                    filteredSlotList.add(new Slot(slotId, centreName, slotTime));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return filteredSlotList;
    }

    public void addSlot(Slot slot) {
        String query = "INSERT INTO slot (slotId, centreId, time) VALUES (?, ?, ?)"; // Adjust query according to your table schema

        try (Connection connection = DBConnection.connect();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, slot.getSlotId());
            stmt.setString(2, slot.getCentreId());
            stmt.setTimestamp(3, new java.sql.Timestamp(slot.getTime().getTime()));

            int rowsInserted = stmt.executeUpdate();
            System.out.println(rowsInserted + " record(s) inserted");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Slot getSlotById(String slotID) {
        Slot foundSlot = null;
        String query = "SELECT slotId, centreId, time FROM slot WHERE slotId = ?"; // Adjust query according to your table schema

        try (Connection connection = DBConnection.connect();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, slotID);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    String slotId = resultSet.getString("slotId");
                    String centreName = resultSet.getString("centreId");
                    Date slotTime = resultSet.getDate("time");

                    foundSlot = new Slot(slotId, centreName, slotTime);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return foundSlot;
    }

    public Slot getSlotByIdAndCentreId(String slotID, String gymCentreId) {
        Slot foundSlot = null;
        String query = "SELECT slotId, centreId, time FROM slot WHERE slotId = ? AND centreId = ?";

        try (Connection connection = DBConnection.connect();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, slotID);
            stmt.setString(2, gymCentreId);

            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    String slotId = resultSet.getString("slotId");
                    String centreId = resultSet.getString("centreId");
                    Date slotTime = resultSet.getDate("time");

                    foundSlot = new Slot(slotId, centreId, slotTime);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return foundSlot;
    }

    @Override
    public String getSlotbyCentreIdAndTimeStamp(String gymCentreId, Timestamp timestamp) {
        String slotId=null;
        try {
            conn = DBConnection.connect();
            assert conn != null;
            statement = conn.prepareStatement(SQLConstants.GET_SLOT_FROM_GYMOWNER_AND_TIMESTAMP);
            statement.setString(1,gymCentreId);
            statement.setTimestamp(2,timestamp);

            ResultSet rs = statement.executeQuery();
            System.out.print(rs);
            while(rs.next()) {
                slotId = rs.getString("slotId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return slotId;
    }

}


