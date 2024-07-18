package com.flipkart.business;

import com.flipkart.dao.GymCenterDAO;
import com.flipkart.bean.GymCentre;

import java.util.List;

public class GymCenterServiceImpl implements GymCenterServiceInterface {
    GymCenterDAO gymCenterDAO = new GymCenterDAO();



    public List<GymCentre> getAllCentresByOwmerId(String gymOwnerId) {
        return gymCenterDAO.getAllCentresByOwmerId(gymOwnerId);
    }
    public void addCenter(String gymId,String userName,String gymCentreName, String gstin, String city,int capacity,boolean isapproved,float price) {
        //takes gymCenter details

//        gymCenterDAO.addGymCentre(gymId,userName,gymCentreName,gstin,city,capacity,isapproved,price );
        return;

    }


}