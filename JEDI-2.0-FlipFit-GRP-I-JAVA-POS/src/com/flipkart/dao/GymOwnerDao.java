package com.flipkart.dao;


import com.flipkart.bean.GymOwner;
import java.util.ArrayList;
import java.util.List;
import com.flipkart.bean.Role;

public class GymOwnerDao implements GymOwnerInterfaceDao {
    private List<GymOwner> gymOwnerList = new ArrayList<>();
    public List<GymOwner> getGymOwnerList(){
        return gymOwnerList;
    }
    public void setGymOwnerList(List<GymOwner> gymOwnerList){
        this.gymOwnerList = gymOwnerList;

    }

    public void registerGymOwner(String userName,String password,String email,String panNumber,String cardNumber){
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


}
