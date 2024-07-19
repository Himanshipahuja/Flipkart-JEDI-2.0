package com.flipkart.constants;

public class SQLConstants {
    public static final String FETCH_GYM_CENTRES_BY_OWNER_ID = "SELECT * FROM `FlipFit-Schema`.gym_center where ownerId = ?";
    public static final String SQL_APPROVE_GYM_CENTRE_BY_ID_QUERY = "Update gym_center Set approved=? WHERE centerId=?";
    public static final String ADD_GYM_CENTRE_QUERY = "INSERT INTO `FlipFit-Schema`.gym_center (centreId, ownerId, centerName, gstNumber, city, capacity, amountPerSlot, approved) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
}