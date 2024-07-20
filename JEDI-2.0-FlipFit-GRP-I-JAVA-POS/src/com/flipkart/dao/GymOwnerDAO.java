package com.flipkart.dao;
import com.flipkart.bean.GymOwner;

import java.util.List;

public interface GymOwnerDAO {
    public List<GymOwner> getGymOwnerList();
    public void setGymOwnerList(List<GymOwner> gymOwnerList);
    public GymOwner registerGymOwner(String userName,String password,String email,String panNumber,String cardNumber);
    public List<GymOwner> getPendingGymOwnerList();
    public boolean loginGymOwner(String username,String password);
    public void sendOwnerApprovalRequest(String gymOwnerId);
    public String getGymOwnerId(String userName, String password);
    List<GymOwner> getGymOwnersList();
    public void validateAllGymOwners();
    public void validateGymOwnerByID(String ownerId, int isApproved);
}
