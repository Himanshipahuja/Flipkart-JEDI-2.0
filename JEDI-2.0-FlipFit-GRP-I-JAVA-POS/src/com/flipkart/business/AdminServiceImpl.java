package com.flipkart.business;

import com.flipkart.bean.Admin;
import com.flipkart.bean.GymCentre;
import com.flipkart.client.AdminFlipfitMenu;
import com.flipkart.dao.GymCenterDAO;
import com.flipkart.exceptions.LoginFailedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AdminServiceImpl implements AdminServiceInterface {

    Admin admin = new Admin();
    GymCenterDAO gymCenterDAO = new GymCenterDAO();

    @Override
    public void viewGymOwner(String gymOwnerId) {
    }

    @Override
    public void removeGymOwner(String gymOwnerId) {
    }

    @Override
    public boolean approveRequest(String requestId) {
        return false;
    }

    @Override
    public boolean cancelRequest(String requestId) {
        return false;
    }

    @Override
    public void viewPendingRequest(String requestId) {

    }

    @Override
    public boolean isUserValid(String userName, String password) {
        return userName.equals(admin.getUserName()) && password.equals(admin.getPassword());
    }

    @Override
    public boolean adminLogin(String userName, String password) {
        if (isUserValid(userName, password)) {
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("Successfully logged in as admin");
            System.out.println("---------------------------------------------------------------------------");
        } else {
            System.out.println("---------------------------------------------------------------------------");
            new LoginFailedException("Admin Login Failed");
            return false;
        }
        return true;
    }

    @Override
    public void adminChangePassword(String userName, String old_password, String new_password) {
        if (Objects.equals(old_password, admin.getPassword())) {
            admin.setPassword(new_password);
            System.out.println("Successfully changed the password");
        } else {
            System.out.println("Entered wrong password");
        }
    }

    @Override
    public void viewAllGymCentres(){
        List<GymCentre> gymCentres = gymCenterDAO.getGymCentersList();

//        List<String> gymCenterNames = new ArrayList<>();
//        gymCentres.forEach(gymCentre -> {gymCenterNames.add(gymCentre.getCentreName());});
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-10s | %-20s | %-15s | %-15s | %-8s | %-10s | %-15s |\n",
                "Centre ID", "Owner ID", "Centre Name", "GST No", "City", "Capacity", "Approved", "Amount/Slot");

        for (GymCentre gymCentre : gymCentres) {
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("| %-10s | %-10s | %-20s | %-15s | %-15s | %-8d | %-10b | %-15d |\n",
                    gymCentre.getCentreId(), gymCentre.getOwnerId(), gymCentre.getCentreName(), gymCentre.getGstNo(), gymCentre.getCity(), gymCentre.getCapacity(), gymCentre.isApproved(), gymCentre.getAmountPerSlot());
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");

//        System.out.println(gymCenterNames);

    }
}
