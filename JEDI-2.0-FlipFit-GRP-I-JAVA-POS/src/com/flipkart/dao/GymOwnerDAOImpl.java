package com.flipkart.dao;


import com.flipkart.bean.GymCentre;
import com.flipkart.bean.GymOwner;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.flipkart.bean.Role;

public class GymOwnerDAOImpl implements GymOwnerDAO {
    private List<GymOwner> gymOwnerList = new ArrayList<>();
    public List<GymOwner> getGymOwnerList(){
        return gymOwnerList;
    }
    public void setGymOwnerList(List<GymOwner> gymOwnerList){
        this.gymOwnerList = gymOwnerList;

    }

    public GymOwner registerGymOwner(String userName,String password,String email,String panNumber,String cardNumber){
        int initialSize= gymOwnerList.size();
        String userId= String.valueOf(initialSize+1);
        GymOwner curr= new GymOwner();

        curr.setUserID(userId);
        curr.setPassword(password);
        curr.setEmail(email);
        curr.setCardDetails(cardNumber);
        curr.setPanNumber(panNumber);
        curr.setApproved(false);
        curr.setUserName(userName);
        curr.setRole(Role.GYMOWNER);
        curr.setGymCentreLists(new ArrayList<>());
        gymOwnerList.add(curr);
        return curr;
    }
    public boolean loginGymOwner(String username,String password){
        List<GymOwner>currGymOwner = getGymOwnerList();
        for(GymOwner gymowner:currGymOwner){
            if(gymowner.getUserName().equals(username) && gymowner.getPassword().equals(password)){
               return true;
            }
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
        for (GymOwner gymOwner : gymOwnerList) {
            if (Objects.equals(gymOwnerId, gymOwner.getUserID())) {
                gymOwner.setApproved(false);
            }
        }
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
