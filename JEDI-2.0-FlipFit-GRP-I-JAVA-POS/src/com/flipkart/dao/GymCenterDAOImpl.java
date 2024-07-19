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

public class GymCenterDAOImpl implements GymCenterDAO {
    private Connection conn=null;
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


//    public void addGymCentre(String gymId,String userName,String gymCentreName, String gstin, String city,int capacity,boolean isapproved,float price) {
//        GymCentre curr= new GymCentre();
//
//        curr.setApproved(isapproved);
//        curr.setAmountPerSlot(price);
//        curr.setCentreId(gymId);
//        curr.setCity(city);
//        curr.setOwnerId(userName);
//        curr.setGstNo(gstin);
//
//        curr.setCentreName(gymCentreName);
//        curr.setCapacity(capacity);
//        GymCentersList.add(curr);
//    }

}
