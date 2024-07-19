package com.flipkart.business;

import com.flipkart.bean.GymCentre;
import com.flipkart.bean.Slot;
import com.flipkart.dao.GymOwnerDAOImpl;
import com.flipkart.bean.GymOwner;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class GymOwnerServiceImpl implements GymOwnerServiceInterface{
    private static GymOwnerDAOImpl gymOwnerDAOImpl = new GymOwnerDAOImpl();
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

        gymOwnerDAOImpl.registerGymOwner(userName,password,email,panNumber,cardNumber);
//        List<GymOwner>gymOwnerList=gymOwnerDAO.getGymOwnerList();
        System.out.println("Registered successfully!! ");

//        for(GymOwner gymowner:gymOwnerList){
//            System.out.println("\t User Name: " + gymowner.getUserName());
//            System.out.println("\t email: " + gymowner.getEmail());
//            System.out.println("\t PAN Number: " +  gymowner.getPanNumber());
//            System.out.println("\t Card Number: " +  gymowner.getCardDetails());
//        }


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
        return gymOwnerDAOImpl.loginGymOwner(userName, password);
    }
    @Override
    public void gymOwnerChangePassword(String userName, String old_password, String new_password) {
        System.out.println("Successfully changed the password");
    }

    @Override
    public void viewAllGymOwners() {
        List<GymOwner> gymOwners = gymOwnerDAOImpl.getGymOwnerList();

        System.out.println("--------------------------------------------------------------------");
        System.out.printf("| %-10s | %-10s | %-20s | %-15s |\n",
                "Username", "Email", "Card Details", "Pan Number");

        for (GymOwner gymOwner : gymOwners) {
            System.out.println("--------------------------------------------------------------------");
            System.out.printf("| %-10s | %-10s | %-20s | %-15s |\n",
                    gymOwner.getUserName(), gymOwner.getEmail(), gymOwner.getCardDetails(), gymOwner.getPanNumber());
        }
        System.out.println("--------------------------------------------------------------------");


    }

}
