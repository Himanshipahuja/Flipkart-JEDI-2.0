package com.flipkart.dao;

import com.flipkart.bean.GymCentre;
import com.flipkart.bean.GymOwner;

import java.util.List;

public interface GymCenterInterfaceDAO {

    List<GymCentre> getGymCentersList();

    List<GymCentre> getAllCentresByOwmerId(String gymOwnerId) ;

    public void validateAllGymCentres();
    public void validateGymCentreByID(String gymCentreId, boolean isApproved);

}
