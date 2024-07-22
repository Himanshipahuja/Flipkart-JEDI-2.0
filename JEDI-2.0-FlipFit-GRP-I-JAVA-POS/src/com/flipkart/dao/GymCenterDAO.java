package com.flipkart.dao;

import com.flipkart.bean.GymCentre;

import java.util.List;

public interface GymCenterDAO {



    List<GymCentre> getAllCentresByOwmerId(String gymOwnerId) ;

    public List<GymCentre> getGymCentreListByCity(String city);
    public Integer getCapacityFromCenterId(String centerId);
    public void addGymCentre(String gymId,String ownerId,String gymCentreName, String gstin, String city,int capacity,boolean isapproved,float price);
    public float getCostFromCenterId(String centerId);
}
