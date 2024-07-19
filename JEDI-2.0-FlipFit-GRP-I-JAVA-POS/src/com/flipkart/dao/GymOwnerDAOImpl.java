package com.flipkart.dao;


import com.flipkart.bean.GymOwner;
<<<<<<< HEAD
=======
import com.flipkart.bean.Role;
import com.flipkart.constants.SQLConstants;
import com.flipkart.utils.DBConnection;
>>>>>>> 2f16e16 (added gym owner approval for admin)

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

<<<<<<< HEAD
import com.flipkart.bean.Role;
import com.flipkart.constants.SQLConstants;
import com.flipkart.utils.DBConnection;

=======
>>>>>>> 2f16e16 (added gym owner approval for admin)
public class GymOwnerDAOImpl implements GymOwnerDAO {

    private Connection conn = null;
    private PreparedStatement statement = null;
<<<<<<< HEAD

=======
>>>>>>> 2f16e16 (added gym owner approval for admin)
    private List<GymOwner> gymOwnerList = new ArrayList<>();


<<<<<<< HEAD
    public GymOwner registerGymOwner(String userName,String password,String email,String panNumber,String cardNumber){
        GymOwner gymOwner = new GymOwner();
        try{
            conn  = DBConnection.connect();
            statement = conn.prepareStatement(SQLConstants.REGISTER_GYM_OWNER);

            statement.setString(1,panNumber);
            statement.setBoolean(2,false);
            statement.setString(3, cardNumber);
            statement.setString(4,userName);

            System.out.println(statement);

            statement.executeUpdate();

            System.out.println("Registration Success\n");
            gymOwner.setUserName(userName);
            gymOwner.setPassword(password);
            gymOwner.setEmail(email);
            gymOwner.setPanNumber(panNumber);
            gymOwner.setCardDetails(cardNumber);

            return gymOwner;

        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Try again with a different Username \n");
        }
        return gymOwner;
    }
    public boolean loginGymOwner(String username,String password){
        try {
            conn = DBConnection.connect();
            ResultSet result;
            try {
                statement = conn.prepareStatement(SQLConstants.LOGIN_GYM_OWNER);
                statement.setString(1, username);
                statement.setString(2, password);
                result = statement.executeQuery();
                while (result.next()) {
                    if (username.equals(result.getString("userName")) && password.equals(result.getString("password"))) {
                        System.out.println("Login Success\n");
                        return true;
                    } else {
                        return false;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("SQL Exception\n");
                return false;
=======
    public GymOwner registerGymOwner(String userName, String password, String email, String panNumber, String cardNumber) {
        int initialSize = gymOwnerList.size();
        String userId = String.valueOf(initialSize + 1);
        GymOwner curr = new GymOwner();

        curr.setUserID(userId);
        curr.setPassword(password);
        curr.setEmail(email);
        curr.setCardDetails(cardNumber);
        curr.setPanNumber(panNumber);
        curr.setApproved(0);
        curr.setUserName(userName);
        curr.setRole(Role.GYMOWNER);
        curr.setGymCentreLists(new ArrayList<>());
        gymOwnerList.add(curr);
        return curr;
    }

    public boolean loginGymOwner(String username, String password) {
        List<GymOwner> currGymOwner = getGymOwnersList();
        for (GymOwner gymowner : currGymOwner) {
            if (gymowner.getUserName().equals(username) && gymowner.getPassword().equals(password)) {
                return true;
>>>>>>> 2f16e16 (added gym owner approval for admin)
            }
        }catch (SQLException e){
            System.out.println("SQL Exception\n");
        }
        return false;
    }

    public List<GymOwner> getPendingGymOwnerList() {
        List<GymOwner> pendingGymOwner = new ArrayList<>();

        for (GymOwner gymowner : gymOwnerList) {
            if (gymowner.isApproved()==0) {
                pendingGymOwner.add(gymowner);
            }

        }
        return pendingGymOwner;
    }

    @Override
    public List<GymOwner> getGymOwnersList() {
        List<GymOwner> resGymOwnerList = new ArrayList<>();
        try {
            conn = DBConnection.connect();
            statement = conn.prepareStatement(SQLConstants.FETCH_ALL_GYM_OWNERS_QUERY);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                GymOwner owner = new GymOwner(
                        rs.getString("userId"),
                        rs.getString("userName"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("panNumber"),
                        rs.getInt("Approved"),
                        rs.getString("cardDetails")
                );
                //owner.setApproved(rs.getInt("isApproved"));
                resGymOwnerList.add(owner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resGymOwnerList;
    }

    @Override
    public void validateAllGymOwners() {
        try {
            conn = DBConnection.connect();
            System.out.println("Fetching gyms owners..");

            statement = conn.prepareStatement(SQLConstants.SQL_APPROVE_GYM_OWNER_ALL);
            //statement.setInt(1, isApproved);
            statement.executeUpdate();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        }
    }


@Override
public void validateGymOwnerByID(String gymOwnerId, int isApproved) {
//        List<GymOwner> gymOwnerList = getGymOwnersList();
//        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
//        System.out.printf("| %-10s | %-10s | %-20s | %-15s | %-15s | %-8s | %-30s | %-15s |\n",
//                "User ID", "User Name", "Email", "Role", "PAN", "Approved", "GymCentre List", "Card Details");
//        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
//        for (GymOwner gymOwner : gymOwnerList) {
//            if (gymOwner.getUserID().equals(ownerId)) {
//                gymOwner.setApproved(isApproved);
//            }
//
//            System.out.printf("| %-10s | %-10s | %-20s | %-15s | %-15s | %-8b | %-30s | %-15s |\n",
//                    gymOwner.getUserID(), gymOwner.getUserName(), gymOwner.getEmail(), gymOwner.getRole(), gymOwner.getPanNumber(), gymOwner.isApproved(), gymOwner.getGymCentreLists(), gymOwner.getCardDetails());
//
//            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
//
//        }
    try {
        conn = DBConnection.connect();
        System.out.println("Fetching gyms owners..");

<<<<<<< HEAD
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");

        }
    }

    @Override
    public void sendOwnerApprovalRequest(String gymOwnerId){
        try {
            conn = DBConnection.connect();
            System.out.println("Sending gym owner approval request..");
            statement = conn.prepareStatement(SQLConstants.SEND_GYM_OWNER_APPROVAL_REQ_QUERY);
            statement.setString(1,gymOwnerId);
            statement.executeUpdate();

        } catch (SQLException se) { se.printStackTrace(); }
        catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public String getGymOwnerId(String userName, String password) {
        for (GymOwner gymowner: gymOwnerList) {
            if (gymowner.getUserName().equals(userName) && gymowner.getPassword().equals(password)) {
                return gymowner.getUserID();
            }
        }
        return "";
=======
        statement = conn.prepareStatement(SQLConstants.SQL_APPROVE_GYM_OWNER_BY_ID_QUERY);
        //statement.setInt(1, isApproved);
        statement.setString(1, gymOwnerId);
        statement.executeUpdate();
    } catch (SQLException se) {
        // Handle errors for JDBC
        se.printStackTrace();
    } catch (Exception e) {
        // Handle errors for Class.forName
        e.printStackTrace();
>>>>>>> 2f16e16 (added gym owner approval for admin)
    }
}

@Override
public void sendOwnerApprovalRequest(String gymOwnerId) {
    for (GymOwner gymOwner : gymOwnerList) {
        if (Objects.equals(gymOwnerId, gymOwner.getUserID())) {
            gymOwner.setApproved(0);
        }
    }
}

@Override
public String getGymOwnerId(String userName, String password) {
    for (GymOwner gymowner : gymOwnerList) {
        if (gymowner.getUserName().equals(userName) && gymowner.getPassword().equals(password)) {
            return gymowner.getUserID();
        }
    }
    return "";
}
}
