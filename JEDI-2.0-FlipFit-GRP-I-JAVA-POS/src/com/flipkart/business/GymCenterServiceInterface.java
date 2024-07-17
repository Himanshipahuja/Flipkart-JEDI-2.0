package com.flipkart.business;

import com.flipkart.bean.GymCentre;

import java.util.List;

public interface GymCenterServiceInterface {
    List<GymCentre> getCentersByCity(String city);
    List<GymCentre> getAllCentersByOwnerId(String gymOwnerId);
    void requestGymCenterApproval(String gymCenterId);
    void addCenter(GymCentre gymCenter);
    GymCentre getGymCenterById(String centerID);
}
