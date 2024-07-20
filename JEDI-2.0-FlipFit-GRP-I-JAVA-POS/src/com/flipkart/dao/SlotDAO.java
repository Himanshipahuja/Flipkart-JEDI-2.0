package com.flipkart.dao;

import com.flipkart.bean.Slot;

import java.sql.Timestamp;
import java.util.List;

public interface SlotDAO {
    public List<Slot> getSlotList();
    public List<Slot> getSlotByCentreId(String gymCentreId);
    public void addSlot(Slot slot);
    public Slot getSlotById(String slotID);
    public Slot getSlotByIdAndCentreId(String slotID,String gymCentreId);
    public String getSlotbyCentreIdAndTimeStamp(String gymCentreId, Timestamp timestamp);
}
