package com.flipkart.dao;

import com.flipkart.bean.Schedule;

import java.sql.Time;
import java.sql.Timestamp;

    /**
     * @author JEDI-09
     * Interface for schedule DAO operations
     */
public interface ScheduleDAO {
        /**
         * A description of the entire Java function.
         *
         * @param  timestamp description of parameter
         * @param  slotId	description of parameter
         * @return description of return value
         */
    public String addSchedule(Timestamp timestamp,String slotId);
        /**
         * Retrieves the count of booked slots for a given slot ID.
         *
         * @param slotId the ID of the slot for which to retrieve the count
         * @return the count of booked slots for the given slot ID
         */
    public Integer getSlotsBookedCountFromSlotId(String slotId);
}
