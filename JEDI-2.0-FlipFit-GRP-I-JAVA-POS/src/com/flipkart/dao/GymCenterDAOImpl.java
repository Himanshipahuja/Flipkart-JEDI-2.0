package com.flipkart.dao;

import com.flipkart.bean.GymCentre;
import com.flipkart.constants.SQLConstants;
import com.flipkart.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GymCenterDAOImpl implements GymCenterDAO {
    private Connection conn = null;
    private PreparedStatement statement = null;
    public List<GymCentre> getGymCentersList() {
        try {
            conn = DBConnection.connect();
            System.out.println("Fetching gyms centres..");

            statement = conn.prepareStatement(SQLConstants.SQL_VIEW_ALL_GYM_CENTRES);
            ResultSet rs = statement.executeQuery();

            List<GymCentre> gymCentres = new ArrayList<>();
            while(rs.next()) {
                GymCentre gymCentre = new GymCentre(
                        rs.getString("centerId"),
                        rs.getString("ownerId"),
                        rs.getString("centerName"),
                        rs.getString("gstNumber"),
                        rs.getString("city"),
                        rs.getInt("capacity"),
                        rs.getInt("approved"),
                        rs.getFloat("amountPerSlot")
                );
                gymCentres.add(gymCentre);
            }
            return gymCentres;
        }
        catch (SQLException se)
        {
            se.printStackTrace();
            return null;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }

    }


        public List<GymCentre> getAllCentresByOwmerId(String gymOwnerId) {
        List<GymCentre> gymCentreListofOwner = new ArrayList<>();
//        System.out.println("@@ "+gymOwnerId);

        List<GymCentre> allGymCentres = getGymCentersList();
        for (GymCentre gymcentre : allGymCentres) {
//            System.out.println("****((((**** "+gymcentre.getOwnerId());
            String id = gymcentre.getOwnerId();
            if (id.equalsIgnoreCase(gymOwnerId)) {
                gymCentreListofOwner.add(gymcentre);
            }
        }
//        System.out.println("***^^**** "+gymCentreListofOwner.size());

        return gymCentreListofOwner;
    }
    public static String generateRandomString(int length) {
        // Character set from which to generate the random string
        String charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

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

    @Override
    public void validateAllGymCentres() {
        try {
            conn = DBConnection.connect();
            System.out.println("Fetching gyms centres..");

            statement = conn.prepareStatement(SQLConstants.SQL_APPROVE_ALL_GYM_CENTRES);
            statement.executeUpdate();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void validateGymCentreByID(String gymCentreId, int isApproved) {
//        List<GymCentre> gymCentreList = getGymCentersList();
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        System.out.printf("| %-10s | %-10s | %-20s | %-15s | %-15s | %-8s | %-10s | %-15s |\n",
//                "Centre ID", "Owner ID", "Centre Name", "GST No", "City", "Capacity", "Approved", "Amount/Slot");
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//        for (GymCentre gymCentre : gymCentreList) {
//            if (gymCentre.getCentreId().equals(gymCentreId)) {
//                gymCentre.setApproved(isApproved);
//            }
//
//            System.out.printf("| %-10s | %-10s | %-20s | %-15s | %-15s | %-8d | %-10b | %-15f |\n",
//                    gymCentre.getCentreId(), gymCentre.getOwnerId(), gymCentre.getCentreName(), gymCentre.getGstNo(), gymCentre.getCity(), gymCentre.getCapacity(), gymCentre.isApproved(), gymCentre.getAmountPerSlot());
//
//            System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//
//        }
        try {
            conn = DBConnection.connect();
            System.out.println("Fetching gyms centres..");

            statement = conn.prepareStatement(SQLConstants.SQL_APPROVE_GYM_CENTRE_BY_ID_QUERY);
            statement.setString(1, gymCentreId);
            statement.executeUpdate();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<GymCentre> getGymCentreListByCity(String city) {
        List<GymCentre> allCentreByCity = new ArrayList<>();

        try {
            conn = DBConnection.connect();
            System.out.println("Fetching gyms centres by City..");
            statement = conn.prepareStatement(SQLConstants.FETCH_GYM_CENTRES_BY_CITY);
            statement.setString(1, city);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                GymCentre gymCentre = new GymCentre(
                        rs.getString("centerId"),
                        rs.getString("ownerId"),
                        rs.getString("centerName"),
                        rs.getString("gstNumber"),
                        rs.getString("city"),
                        rs.getInt("capacity"),
                        rs.getInt("approved"),
                        rs.getInt("amountPerSlot")
                );
                allCentreByCity.add(gymCentre);
            }
            //System.out.println("The gym centre has been approved!");
        } catch (SQLException se) {
            System.out.println("Error in SQL statement");
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        }
        return allCentreByCity;
    }

    @Override
    public Integer getCapacityFromCenterId(String centerId) {
        Integer gymCentreCapacity = 0;
        try {
            conn = DBConnection.connect();
            System.out.println("Fetching gyms centre capacity");
            statement = conn.prepareStatement(SQLConstants.FETCH_GYM_CENTRE_CAPACITY);
            statement.setString(1, centerId);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                gymCentreCapacity = rs.getInt("capacity");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return gymCentreCapacity;
    }

    public void addGymCentre(String gymId,String ownerId,String gymCentreName, String gstin, String city,int capacity,boolean isapproved,float price) {
        try{
            System.out.println("Heyy%%%%%");
            String priceee = Float.toString(price);
            conn = DBConnection.connect();
            statement = conn.prepareStatement(SQLConstants.ADD_GYM_CENTRE_QUERY);
            statement.setString(1, generateRandomString(6));
            statement.setString(2, ownerId);
            statement.setString(3, gymCentreName);
            statement.setString(4, gstin);
            statement.setString(5, city);
            statement.setInt(6, capacity);
            statement.setInt(7,(isapproved==true?1:0));
            statement.setString(8,priceee );
            boolean i=statement.execute();
            System.out.println("&&&&&"+i);
            if (i) {
                System.out.println("ROW INSERTED");
            } else {
                System.out.println("ROW NOT INSERTED");
            }

        } catch (SQLException e) {
            System.out.println("Heyy%%%%%");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
