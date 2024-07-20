package com.flipkart.dao;


import com.flipkart.bean.GymCentre;
import com.flipkart.bean.GymOwner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import com.flipkart.bean.Role;
import com.flipkart.constants.SQLConstants;
import com.flipkart.utils.DBConnection;

public class GymOwnerDAOImpl implements GymOwnerDAO {

    private Connection conn = null;
    private PreparedStatement statement = null;

    private List<GymOwner> gymOwnerList = new ArrayList<>();
    public List<GymOwner> getGymOwnerList(){
        return gymOwnerList;
    }
    public void setGymOwnerList(List<GymOwner> gymOwnerList){
        this.gymOwnerList = gymOwnerList;

    }
    public static String generateRandomString(int length) {
        // Character set from which to generate the random string
        String charset = "0123456789";

        // Random object to select characters from the charset
        Random random = new Random();

        // StringBuilder to build the resulting random string
        StringBuilder sb = new StringBuilder();

        // Generate random characters
        for (int i = 0; i < length; i++) {
            // Generate a random index between 0 and charset.length()-1
            int randomIndex = random.nextInt(charset.length());

            // Append the character at the random index to the string builder
            sb.append(charset.charAt(randomIndex));
        }

        // Convert StringBuilder to String and return the generated random string
        return sb.toString();
    }
    public GymOwner registerGymOwner(String userName,String password,String email,String panNumber,String cardNumber){
        GymOwner gymOwner = new GymOwner();
        try{
            conn  = DBConnection.connect();
            statement = conn.prepareStatement(SQLConstants.ADD_USER);
            String userid = generateRandomString(8);
            statement.setString(1,userid);
            statement.setString(2,userName);
            statement.setString(3, email);
            statement.setString(4,password);
            String role = "roleId3";
            statement.setString(5,role);

            System.out.println(statement);

            statement.execute();
            statement = null;
            statement = conn.prepareStatement(SQLConstants.REGISTER_GYM_OWNER);

            statement.setString(1,panNumber);
            statement.setBoolean(2,false);
            statement.setString(3, cardNumber);
            statement.setString(4,userid);

            System.out.println(statement);

            statement.execute();

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
            }
        }catch (SQLException e){
            System.out.println("SQL Exception\n");
        }
        return false;
    }
    public List<GymOwner> getPendingGymOwnerList(){
        List<GymOwner>pendingGymOwner = new ArrayList<>();

        for(GymOwner gymowner:gymOwnerList){
            if(!gymowner.isApproved()){
                pendingGymOwner.add(gymowner);
            }

        }
        return pendingGymOwner;
    }
    @Override
    public List<GymOwner> getGymOwnersList() {
        List<GymOwner> gymOwnerList = new ArrayList<>();

        GymCenterDAOImpl gymCenterDAOImpl = new GymCenterDAOImpl();
        List<GymCentre> gymCentreList = gymCenterDAOImpl.getGymCentersList();

        List<String> list1 = new ArrayList<>();
        list1.add(gymCentreList.get(0).getCentreName());
        list1.add(gymCentreList.get(1).getCentreName());

        List<String> list2 = new ArrayList<>();
        list2.add(gymCentreList.get(2).getCentreName());
        list2.add(gymCentreList.get(3).getCentreName());

        List<String> list3 = new ArrayList<>();
        list3.add(gymCentreList.get(4).getCentreName());

        GymOwner owner1 = new GymOwner();
        owner1.setUserID("G001");
        owner1.setUserName("GymOwner1");
        owner1.setEmail("owner1@gmail.com");
        owner1.setPassword("own1");
        owner1.setRole(Role.GYMOWNER);
        owner1.setPanNumber("BQRPH0014");
        owner1.setApproved(true);
        owner1.setGymCentreLists(list1);
        owner1.setCardDetails("1234");
        gymOwnerList.add(owner1);

        GymOwner owner2 = new GymOwner();
        owner2.setUserID("G002");
        owner2.setUserName("GymOwner2");
        owner2.setEmail("owner2@gmail.com");
        owner2.setPassword("own2");
        owner2.setRole(Role.GYMOWNER);
        owner2.setPanNumber("BQRPH00142");
        owner2.setApproved(false);
        owner2.setGymCentreLists(list2);
        owner2.setCardDetails("12345");
        gymOwnerList.add(owner2);

        GymOwner owner3 = new GymOwner();
        owner3.setUserID("G003");
        owner3.setUserName("GymOwner3");
        owner3.setEmail("owner3@gmail.com");
        owner3.setPassword("own3");
        owner3.setRole(Role.GYMOWNER);
        owner3.setPanNumber("BQRPH00143");
        owner3.setApproved(false);
        owner3.setGymCentreLists(list3);
        owner3.setCardDetails("123456");
        gymOwnerList.add(owner3);

        return gymOwnerList;
    }

    @Override
    public void validateAllGymOwners() {
        List<GymOwner> gymOwnerList = getGymOwnersList();
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-10s | %-20s | %-15s | %-15s | %-8s | %-30s | %-15s |\n",
                "User ID", "User Name", "Email", "Role", "PAN", "Approved", "GymCentre List", "Card Details");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
        for(GymOwner gymOwner : gymOwnerList) {
            if(gymOwner!=null) {
                gymOwner.setApproved(true);
            }

            System.out.printf("| %-10s | %-10s | %-20s | %-15s | %-15s | %-8b | %-30s | %-15s |\n",
                    gymOwner.getUserID(), gymOwner.getUserName(), gymOwner.getEmail(), gymOwner.getRole(), gymOwner.getPanNumber(), gymOwner.isApproved(), gymOwner.getGymCentreLists(), gymOwner.getCardDetails());

            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");

        }
    }

    @Override
    public void validateGymOwnerByID(String ownerId, boolean isApproved) {
        List<GymOwner> gymOwnerList = getGymOwnersList();
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-10s | %-20s | %-15s | %-15s | %-8s | %-30s | %-15s |\n",
                "User ID", "User Name", "Email", "Role", "PAN", "Approved", "GymCentre List", "Card Details");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
        for (GymOwner gymOwner : gymOwnerList) {
            if (gymOwner.getUserID().equals(ownerId)) {
                gymOwner.setApproved(isApproved);
            }

            System.out.printf("| %-10s | %-10s | %-20s | %-15s | %-15s | %-8b | %-30s | %-15s |\n",
                    gymOwner.getUserID(), gymOwner.getUserName(), gymOwner.getEmail(), gymOwner.getRole(), gymOwner.getPanNumber(), gymOwner.isApproved(), gymOwner.getGymCentreLists(), gymOwner.getCardDetails());

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
    }
}
