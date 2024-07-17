package com.flipkart.business;

import com.flipkart.bean.GymCentre;
import com.flipkart.bean.Slot;

import java.sql.Date;
import java.util.List;

public interface GymOwnerServiceInterface {
    public void login();

    public void register();

    public List<GymCentre> getAllCentresByOwnerId(String gymOwnerId);

    public List<Slot> getSlotsByCentre(String centreID, Date date);

    public void addCenter(GymCentre gymCentre);

    public void requestGymCentreApproval(String gymCentreId);

}
