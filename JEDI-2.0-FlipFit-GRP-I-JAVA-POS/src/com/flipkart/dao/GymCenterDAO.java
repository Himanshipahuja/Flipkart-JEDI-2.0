package com.flipkart.dao;

import com.flipkart.bean.GymCentre;

import java.util.ArrayList;
import java.util.List;

public class GymCenterDAO implements GymCenterInterfaceDAO {

    public List<GymCentre> getGymCentersList() {
        List<GymCentre> gymCentreList = new ArrayList<>();

        GymCentre centre1 = new GymCentre();
        centre1.setCentreId("C001");
        centre1.setOwnerId("O123");
        centre1.setCentreName("Tech Hub");
        centre1.setGstNo("22AAAAA0000A1Z5");
        centre1.setCity("Bangalore");
        centre1.setCapacity(50);
        centre1.setApproved(true);
        centre1.setAmountPerSlot(500);
        gymCentreList.add(centre1);

        GymCentre centre2 = new GymCentre();
        centre2.setCentreId("C002");
        centre2.setOwnerId("O124");
        centre2.setCentreName("Innovation Center");
        centre2.setGstNo("27BBBBB1111B2Z6");
        centre2.setCity("Mumbai");
        centre2.setCapacity(100);
        centre2.setApproved(true);
        centre2.setAmountPerSlot(700);
        gymCentreList.add(centre2);

        GymCentre centre3 = new GymCentre();
        centre3.setCentreId("C003");
        centre3.setOwnerId("O125");
        centre3.setCentreName("Startup Space");
        centre3.setGstNo("07CCCCC2222C3Z7");
        centre3.setCity("Delhi");
        centre3.setCapacity(75);
        centre3.setApproved(false);
        centre3.setAmountPerSlot(600);
        gymCentreList.add(centre3);

        GymCentre centre4 = new GymCentre();
        centre4.setCentreId("C004");
        centre4.setOwnerId("O126");
        centre4.setCentreName("Techie Zone");
        centre4.setGstNo("10DDDDD3333D4Z8");
        centre4.setCity("Hyderabad");
        centre4.setCapacity(80);
        centre4.setApproved(true);
        centre4.setAmountPerSlot(550);
        gymCentreList.add(centre4);

        GymCentre centre5 = new GymCentre();
        centre5.setCentreId("C005");
        centre5.setOwnerId("O127");
        centre5.setCentreName("Innovation Hub");
        centre5.setGstNo("19EEEEE4444E5Z9");
        centre5.setCity("Kolkata");
        centre5.setCapacity(60);
        centre5.setApproved(false);
        centre5.setAmountPerSlot(400);
        gymCentreList.add(centre5);

        return gymCentreList;
    }

}
