package com.flipkart.dao;

import com.flipkart.bean.Slot;

import java.sql.Timestamp;
import java.util.List;

    /**
     * @author JEDI-09
     * Interface for slot DAO operations
     */
public interface SlotDAO {
    /**
     * Retrieves a list of all slots available.
     *
     * @return   	list of Slot objects representing all available slots
     */
    public List<Slot> getSlotList();
    public List<Slot> getSlotByCentreId(String gymCentreId);
    public void addSlot(Slot slot);
    public Slot getSlotById(String slotID);
    public Slot getSlotByIdAndCentreId(String slotID,String gymCentreId);
    public String getSlotbyCentreIdAndTimeStamp(String gymCentreId, Timestamp timestamp);
}
