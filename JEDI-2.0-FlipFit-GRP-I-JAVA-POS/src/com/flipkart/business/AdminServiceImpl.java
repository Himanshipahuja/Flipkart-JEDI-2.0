package com.flipkart.business;

import com.flipkart.bean.Admin;
import com.flipkart.bean.GymCentre;
import com.flipkart.bean.GymOwner;
import com.flipkart.dao.GymCenterDAOImpl;
import com.flipkart.dao.GymOwnerDAOImpl;
import com.flipkart.exceptions.LoginFailedException;

import java.util.List;
import java.util.Objects;

public class AdminServiceImpl implements AdminServiceInterface {

    Admin admin = new Admin();
    GymCenterDAOImpl gymCenterDAOImpl = new GymCenterDAOImpl();
    GymOwnerDAOImpl gymOwnerDAOImpl = new GymOwnerDAOImpl();

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
    public void viewAllGymOwners() {
        List<GymOwner> gymOwnerList = gymOwnerDAOImpl.getGymOwnersList();
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-10s | %-20s | %-15s | %-15s | %-8s | %-20s |\n",
                "User ID", "User Name", "Email", "Role", "PAN", "Approved", "Card Details" );
        for(GymOwner gymOwner : gymOwnerList) {
            System.out.println("--------------------------------------------------------------------------------------------------------------------");
            System.out.printf("| %-10s | %-10s | %-20s | %-15s | %-15s | %-8b | %-20s |\n",
                    gymOwner.getUserID(), gymOwner.getUserName(), gymOwner.getEmail(), gymOwner.getRole(), gymOwner.getPanNumber(), gymOwner.isApproved(),gymOwner.getCardDetails());
}
            System.out.println("----------------------------------------------------------------------------------------------------------------------");

    }

    @Override
    public void viewAllGymCentres(){
        List<GymCentre> gymCentres = gymCenterDAOImpl.getGymCentersList();

//        List<String> gymCenterNames = new ArrayList<>();
//        gymCentres.forEach(gymCentre -> {gymCenterNames.add(gymCentre.getCentreName());});
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-10s | %-20s | %-15s | %-15s | %-8s | %-10s | %-15s |\n",
                "Centre ID", "Owner ID", "Centre Name", "GST No", "City", "Capacity", "Approved", "Amount/Slot");

        for (GymCentre gymCentre : gymCentres) {
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("| %-10s | %-10s | %-20s | %-15s | %-15s | %-8d | %-10b | %-15f |\n",
                    gymCentre.getCentreId(), gymCentre.getOwnerId(), gymCentre.getCentreName(), gymCentre.getGstNo(), gymCentre.getCity(), gymCentre.getCapacity(), gymCentre.isApproved(), gymCentre.getAmountPerSlot());
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");

//        System.out.println(gymCenterNames);

    }
    @Override
    public void validateAllGymCentres() {
        gymCenterDAOImpl.validateAllGymCentres();
    }

    @Override
    public void validateGymCentreByID(String gymCentreId, int isApproved) {
        gymCenterDAOImpl.validateGymCentreByID(gymCentreId,isApproved);
    }

    @Override
    public void validateAllGymOwners() {
        gymOwnerDAOImpl.validateAllGymOwners();
    }

    @Override
    public void validateGymOwnerByID(String ownerId, int isApproved) {
        gymOwnerDAOImpl.validateGymOwnerByID(ownerId,isApproved);
    }
}

