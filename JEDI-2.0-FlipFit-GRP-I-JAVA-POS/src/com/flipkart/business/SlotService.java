package com.flipkart.business;

import com.flipkart.bean.Slot;
import com.flipkart.dao.SlotDAOImpl;

import java.util.List;

public class SlotService implements SlotServiceInterface{

    private static SlotDAOImpl slotDAO = new SlotDAOImpl();

    @Override
    public List<Slot> getAllSlotsByCentre(String centreID) {
        return List.of();
    }

    @Override
    public Slot getSlotByID(String slotID) {
        return null;
    }

    @Override
    public List<Slot> getSlotList() {
        return List.of();
    }

    @Override
    public void addSlotsForGym(String gymCentreId, List<Slot> slotList) {
        System.out.println("Adding all slots to gym: " + gymCentreId);
        for(Slot slot : slotList) {
            slot.setCentreId(gymCentreId);
            slotDAO.addSlot(slot);
        }
    }

    @Override
    public boolean isSlotValid(String slotID, String centreId) {
        return false;
    }
}
