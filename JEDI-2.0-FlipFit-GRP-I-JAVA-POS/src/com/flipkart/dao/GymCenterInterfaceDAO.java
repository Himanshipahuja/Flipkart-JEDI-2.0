package com.flipkart.dao;

import com.flipkart.bean.GymCentre;

import java.util.List;

public interface GymCenterInterfaceDAO {

    List<GymCentre> getGymCentersList();
    List<GymCentre> getAllCentresByOwmerId(String gymOwnerId) ;

}
