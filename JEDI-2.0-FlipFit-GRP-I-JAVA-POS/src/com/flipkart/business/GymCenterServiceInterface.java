package com.flipkart.business;

import com.flipkart.bean.GymCentre;

import java.util.List;

public interface GymCenterServiceInterface {
//    List<GymCentre> getCentersByCity(String city);
    List<GymCentre> getAllCentresByOwmerId(String gymOwnerId);
    void addCenter(String gymId,String userName,String gymCentreName, String gstin, String city,int capacity,boolean isapproved,float price);

//    void requestGymCenterApproval(String gymCenterId);
//    void addCenter(GymCentre gymCenter);
//    GymCentre getGymCenterById(String centerID);
}
