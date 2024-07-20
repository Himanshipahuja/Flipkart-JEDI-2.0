package com.flipkart.constants;

public class SQLConstants {

    // -------------------------------------- GYM CENTRE ------------------------------------------------------------
    public static final String SQL_APPROVE_GYM_CENTRE_BY_ID_QUERY="Update gym_center Set approved=1 WHERE centerId=?";
    public static final String SQL_APPROVE_ALL_GYM_CENTRES="Update gym_center Set approved=1";
    public static final String SQL_VIEW_ALL_GYM_CENTRES="Select * from gym_center";
    public static final String FETCH_GYM_CENTRES_BY_OWNER_ID = "SELECT * FROM `FlipFit-Schema`.gym_center where ownerId = ?";
    public static final String ADD_GYM_CENTRE_QUERY = "INSERT INTO `FlipFit-Schema`.gym_center VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    public static final String FETCH_GYM_CENTRES_BY_CITY = "SELECT * FROM gym_center where city = ?";
    public static final String FETCH_GYM_CENTRE_CAPACITY =  "SELECT capacity FROM gym_center WHERE centerId = ?";

    // -------------------------------------- USER ------------------------------------------------------------
    public static final String GET_USER_BY_ID = "SELECT * FROM `flipfit-schema`.`user` WHERE userId = ?;";
    public static final String ADD_USER = "INSERT INTO `flipfit-schema`.`user` values (?,?,?,?,?);";
    public static final String GET_USER_ID_FRROM_USER = "select userId from `FlipFit-Schema`.user where userName=? AND role = (select roleId from `FlipFit-Schema`.role where roleName='gymowner');";


    // -------------------------------------- GYM OWNER ------------------------------------------------------------
    public static final String SEND_GYM_OWNER_APPROVAL_REQ_QUERY = "UPDATE gym_owner SET approved = 2 WHERE ownerId=?;";
    public static final String REGISTER_GYM_OWNER = "INSERT INTO `FlipFit-Schema`.gym_owner (panNumber, Approved, cardDetails, ownerId) VALUES (?, ?, ?, ?)";
    public static final String LOGIN_GYM_OWNER = "Select * from `FlipFit-Schema`.user where userName=? and password=?";

    // -------------------------------------- CUSTOMER ------------------------------------------------------------
    public static final String GET_CUSTOMER_ID_BY_USERNAME_PASSWORD = "SELECT * FROM `flipfit-schema`.`user` WHERE userName = ? AND password = ?;";
    public static final String GET_CUSTOMER_BY_ID = "SELECT * FROM `flipfit-schema`.`customer` WHERE customerId = ?;";
    public static final String ADD_NEW_CUSTOMER = "INSERT INTO `flipfit-schema`.`customer` (customerPhone,cardDetails,customerId) VALUES (?, ?, ?);";
    public static final String ADD_NEW_USER = "INSERT INTO `flipfit-schema`.`user` (userId,userName,email,password,role) VALUES (?, ?, ?, ?, ?);";
    public static final String CUSTOMER_LOGIN_QUERY = "SELECT * FROM `flipfit-schema`.`user` WHERE userName = ? AND password = ? AND role = ?";
    public static final String UPDATE_CUSTOMER_PASSWORD = "UPDATE `flipfit-schema`.`user` SET password = ? WHERE userId = ? AND role = ?;";

    // -----------------------------------GYM OWNER -----------------------------------------------------------------------
    public static final String SQL_APPROVE_GYM_OWNER_BY_ID_QUERY="Update gym_owner Set Approved=1 WHERE ownerId=?";
    public static final String SQL_APPROVE_GYM_OWNER_ALL="Update gym_owner Set Approved=1";
    public static final String FETCH_ALL_GYM_OWNERS_QUERY = "SELECT * FROM user u JOIN gym_owner g on u.userID=g.ownerID";


    // -------------------------------------- SLOT ------------------------------------------------------------
    public static final String GET_SLOT_FROM_GYMOWNER_AND_TIMESTAMP = "SELECT slotId from slot where centreId = ? and time = ?";


    // -------------------------------------- SCHEDULE ------------------------------------------------------------
    public static final  String GET_BOOKED_SLOT_COUNT_FROM_SLOTID = "SELECT count(*) FROM schedule where slotId = ?";
    public static final String ADD_SCHEDULE = "INSERT INTO schedule (scheduleId,date,slotid) VALUES (?,?,?)";



}
