package com.flipkart.dao;

import com.flipkart.bean.Slot;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class SlotDAOImpl implements SlotDAO {

    public SlotDAOImpl() {}

    public List<Slot> getSlotList() {
        List<Slot> slotList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            slotList.add(new Slot("slot1", "centre1", sdf.parse("2024-07-17 09:00:00")));
            slotList.add(new Slot("slot2", "centre1", sdf.parse("2024-07-17 10:00:00")));
            slotList.add(new Slot("slot3", "centre2", sdf.parse("2024-07-17 11:00:00")));
            slotList.add(new Slot("slot4", "centre2", sdf.parse("2024-07-17 12:00:00")));
            slotList.add(new Slot("slot5", "centre3", sdf.parse("2024-07-17 13:00:00")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return slotList;
    }

    @Override
    public List<Slot> getSlotByCentreId(String gymCentreId) {
        List<Slot> slotList = getSlotList();
        List<Slot> filteredSlotList = getSlotList();
        for (Slot slot : slotList) {
            if (slot.getCentreId().equals(gymCentreId)) {
                filteredSlotList.add(slot);
            }
        }
        return filteredSlotList;
    }

    public void addSlot(Slot slot){
    }
    public Slot getSlotById(String slotID) {
        List<Slot> slotList = getSlotList();
        for (Slot slot : slotList) {
            if (slot.getSlotId().equals(slotID)) {
                return slot;
            }
        }
        return null;
    }

    public Slot getSlotByIdAndCentreId(String slotID, String gymCentreId) {
        List<Slot> slotList = getSlotList();
        for (Slot slot : slotList) {
            if (slot.getCentreId().equals(gymCentreId)) {
                if (slot.getSlotId().equals(slotID)) {
                    return slot;
                }
            }
        }
        return null;
    }

}


