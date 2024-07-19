package com.flipkart.constants;

public class SQLConstants {

    // -------------------------------------- GYM CENTRE ------------------------------------------------------------
    public static final String SQL_APPROVE_GYM_CENTRE_BY_ID_QUERY="Update gym_center Set approved=1 WHERE centerId=?";
    public static final String SQL_APPROVE_ALL_GYM_CENTRES="Update gym_center Set approved=1";
    public static final String SQL_VIEW_ALL_GYM_CENTRES="Select * from gym_center";
    public static final String FETCH_GYM_CENTRES_BY_OWNER_ID = "SELECT * FROM `FlipFit-Schema`.gym_center where ownerId = ?";
    public static final String ADD_GYM_CENTRE_QUERY = "INSERT INTO `FlipFit-Schema`.gym_center (centreId, ownerId, centerName, gstNumber, city, capacity, amountPerSlot, approved) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

    // -------------------------------------- GYM OWNER ------------------------------------------------------------
    public static final String SEND_GYM_OWNER_APPROVAL_REQ_QUERY = "UPDATE gym_owner SET approved = 2 WHERE ownerId=?;";

    // -------------------------------------- CUSTOMER ------------------------------------------------------------

}
