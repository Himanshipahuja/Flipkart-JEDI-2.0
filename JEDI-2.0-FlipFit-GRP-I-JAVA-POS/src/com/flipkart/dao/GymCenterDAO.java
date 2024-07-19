package com.flipkart.dao;

import com.flipkart.bean.GymCentre;

import java.util.List;

public interface GymCenterDAO {

    List<GymCentre> getGymCentersList();

    List<GymCentre> getAllCentresByOwmerId(String gymOwnerId) ;

    public void validateAllGymCentres();
    public void validateGymCentreByID(String gymCentreId, int isApproved);
    public List<GymCentre> getGymCentreListByCity(String city);
}
