package com.flipkart.constants;

public class SQLConstants {
    public static final String FETCH_GYM_CENTRES_BY_OWNER_ID = "SELECT * FROM `FlipFit-Schema`.gym_center where ownerId = ?";
    public static final String SQL_APPROVE_GYM_CENTRE_BY_ID_QUERY="Update gym_center Set approved=? WHERE centerId=?";

}
