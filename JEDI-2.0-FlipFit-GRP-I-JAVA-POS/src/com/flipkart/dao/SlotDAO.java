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

    /**
     * Retrieves a list of slots for a given gym centre ID.
     *
     * @param  gymCentreId the ID of the gym centre for which to retrieve the slots
     * @return            a list of Slot objects representing the slots for the given gym centre
     */
    public List<Slot> getSlotByCentreId(String gymCentreId);

    /**
     * Adds a new slot to the database.
     *
     * @param  slot the slot to be added
     * @return the ID of the newly added slot
     */
    public void addSlot(Slot slot);


    /**
     * Retrieves a Slot object from the database based on the provided gymCentreId and timestamp.
     *
     * @param  gymCentreId the unique identifier of the gym centre
     * @param  timestamp the timestamp of the slot
     * @return the Slot object associated with the gymCentreId and timestamp, or null if not found
     */
    public String getSlotbyCentreIdAndTimeStamp(String gymCentreId, Timestamp timestamp);
}
