package com.flipkart.dao;

import com.flipkart.bean.Schedule;

import java.sql.Time;
import java.sql.Timestamp;

    /**
     * @author JEDI-09
     * Interface for schedule DAO operations
     */
public interface ScheduleDAO {
    public String addSchedule(Timestamp timestamp,String slotId);
    public Integer getSlotsBookedCountFromSlotId(String slotId);
}
