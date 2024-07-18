package com.flipkart.business;

import com.flipkart.bean.GymCentre;
import com.flipkart.bean.Slot;
import com.flipkart.dao.GymOwnerDao;
import com.flipkart.bean.GymOwner;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class GymOwnerServiceImpl implements GymOwnerServiceInterface{
    private static GymOwnerDao gymOwnerDAO = new GymOwnerDao();
    public static Scanner scanner = new Scanner(System.in); // has to be imported from main client

    @Override
    public void login() {

    }

    @Override
    public void register() {
        System.out.println("Enter your UserName");
        String userName = scanner.next();

        System.out.println("Enter your Passkey");
        String password = scanner.next();

        System.out.println("Enter your Email");
        String email = scanner.next();

        System.out.println("Enter your PAN Number");
        String panNumber = scanner.next();

        System.out.println("Enter your Card Number");
        String cardNumber = scanner.next();

        gymOwnerDAO.registerGymOwner(userName,password,email,panNumber,cardNumber);
        List<GymOwner>gymOwnerList=gymOwnerDAO.getGymOwnerList();
        System.out.println("Registered successfully with: ");

        for(GymOwner gymowner:gymOwnerList){
            System.out.println("\t User Name: " + gymowner.getUserName());
            System.out.println("\t email: " + gymowner.getEmail());
            System.out.println("\t PAN Number: " +  gymowner.getPanNumber());
            System.out.println("\t Card Number: " +  gymowner.getCardDetails());
        }



    }

    @Override
    public List<GymCentre> getAllCentresByOwnerId(String gymOwnerId) {
        return List.of();
    }

    @Override
    public List<Slot> getSlotsByCentre(String centreID, Date date) {
        return List.of();
    }

    @Override
    public void addCenter(GymCentre gymCentre) {

    }

    @Override
    public void requestGymCentreApproval(String gymCentreId) {

    }

    @Override
    public boolean gymOwnerLogin(String userName, String password) {
        System.out.println("Successfully logged in as Gym Owner");
        return true;
    }
    @Override
    public void gymOwnerChangePassword(String userName, String old_password, String new_password) {
        System.out.println("Successfully changed the password");
    }
}
