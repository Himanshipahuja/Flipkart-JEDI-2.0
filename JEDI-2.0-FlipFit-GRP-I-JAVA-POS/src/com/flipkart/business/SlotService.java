package com.flipkart.business;

import com.flipkart.bean.Slot;

import java.util.List;

/**
 * Interface for Slot Service
 */
public interface SlotService {

    /**
     * Adds the slot to the Gym
     *
     * @param  gymCentreId  id of gym center
     * @param  slotList     a list of slots
     */
    void addSlotsForGym(String gymCentreId, List<Slot> slotList);

}
