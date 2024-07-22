package com.flipkart.business;

import com.flipkart.bean.GymCentre;

import java.util.List;

public interface GymCenterServiceInterface {

    List<GymCentre> getAllCentresByOwmerId(String gymOwnerId);
    void addCenter(String gymId,String userName,String gymCentreName, String gstin, String city,int capacity,boolean isapproved,float price);

    void requestGymCentreApproval(String gymCentreName, String userName);

}
