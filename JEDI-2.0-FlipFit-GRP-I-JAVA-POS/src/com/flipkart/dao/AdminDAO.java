package com.flipkart.dao;

import com.flipkart.bean.GymCentre;
import com.flipkart.bean.GymOwner;

import java.util.List;

public interface AdminDAO {
    List<GymOwner> getGymOwnersList();
    public void validateAllGymOwners();
    public void validateGymOwnerByID(String ownerId, int isApproved);

    List<GymCentre> getGymCentersList();
    public void validateAllGymCentres();
    public void validateGymCentreByID(String gymCentreId, int isApproved);
}
