package com.flipkart.dao;

import com.flipkart.bean.GymCentre;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Role;

import java.util.ArrayList;
import java.util.List;

public class GymCenterDAO implements GymCenterInterfaceDAO {
//    private List<GymCentre> GymCentersList = new ArrayList<>();

    public List<GymCentre> getGymCentersList() {
        List<GymCentre> gymCentreList = new ArrayList<>();

        GymCentre centre1 = new GymCentre();
        centre1.setCentreId("C001");
        centre1.setOwnerId("O123");
        centre1.setCentreName("Tech Hub");
        centre1.setGstNo("22AAAAA0000A1Z5");
        centre1.setCity("Bangalore");
        centre1.setCapacity(50);
        centre1.setApproved(true);
        centre1.setAmountPerSlot(500);
        gymCentreList.add(centre1);

        GymCentre centre2 = new GymCentre();
        centre2.setCentreId("C002");
        centre2.setOwnerId("O124");
        centre2.setCentreName("Innovation Center");
        centre2.setGstNo("27BBBBB1111B2Z6");
        centre2.setCity("Mumbai");
        centre2.setCapacity(100);
        centre2.setApproved(true);
        centre2.setAmountPerSlot(700);
        gymCentreList.add(centre2);

        GymCentre centre3 = new GymCentre();
        centre3.setCentreId("C003");
        centre3.setOwnerId("O125");
        centre3.setCentreName("Startup Space");
        centre3.setGstNo("07CCCCC2222C3Z7");
        centre3.setCity("Delhi");
        centre3.setCapacity(75);
        centre3.setApproved(false);
        centre3.setAmountPerSlot(600);
        gymCentreList.add(centre3);

        GymCentre centre4 = new GymCentre();
        centre4.setCentreId("C004");
        centre4.setOwnerId("O126");
        centre4.setCentreName("Techie Zone");
        centre4.setGstNo("10DDDDD3333D4Z8");
        centre4.setCity("Hyderabad");
        centre4.setCapacity(80);
        centre4.setApproved(true);
        centre4.setAmountPerSlot(550);
        gymCentreList.add(centre4);

        GymCentre centre5 = new GymCentre();
        centre5.setCentreId("C005");
        centre5.setOwnerId("O127");
        centre5.setCentreName("Innovation Hub");
        centre5.setGstNo("19EEEEE4444E5Z9");
        centre5.setCity("Kolkata");
        centre5.setCapacity(60);
        centre5.setApproved(false);
        centre5.setAmountPerSlot(400);
        gymCentreList.add(centre5);

        return gymCentreList;
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
        List<GymCentre> gymCentreList = getGymCentersList();
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-10s | %-20s | %-15s | %-15s | %-8s | %-10s | %-15s |\n",
                "Centre ID", "Owner ID", "Centre Name", "GST No", "City", "Capacity", "Approved", "Amount/Slot");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        for (GymCentre gymCentre : gymCentreList) {
            if (gymCentre != null) {
                gymCentre.setApproved(true);
            }

            System.out.printf("| %-10s | %-10s | %-20s | %-15s | %-15s | %-8d | %-10b | %-15f |\n",
                    gymCentre.getCentreId(), gymCentre.getOwnerId(), gymCentre.getCentreName(), gymCentre.getGstNo(), gymCentre.getCity(), gymCentre.getCapacity(), gymCentre.isApproved(), gymCentre.getAmountPerSlot());

            System.out.println("--------------------------------------------------------------------------------------------------------------------------------");

        }
    }

    @Override
    public void validateGymCentreByID(String gymCentreId, boolean isApproved) {
        List<GymCentre> gymCentreList = getGymCentersList();
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-10s | %-20s | %-15s | %-15s | %-8s | %-10s | %-15s |\n",
                "Centre ID", "Owner ID", "Centre Name", "GST No", "City", "Capacity", "Approved", "Amount/Slot");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        for (GymCentre gymCentre : gymCentreList) {
            if (gymCentre.getCentreId().equals(gymCentreId)) {
                gymCentre.setApproved(isApproved);
            }

            System.out.printf("| %-10s | %-10s | %-20s | %-15s | %-15s | %-8d | %-10b | %-15f |\n",
                    gymCentre.getCentreId(), gymCentre.getOwnerId(), gymCentre.getCentreName(), gymCentre.getGstNo(), gymCentre.getCity(), gymCentre.getCapacity(), gymCentre.isApproved(), gymCentre.getAmountPerSlot());

            System.out.println("--------------------------------------------------------------------------------------------------------------------------------");

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
