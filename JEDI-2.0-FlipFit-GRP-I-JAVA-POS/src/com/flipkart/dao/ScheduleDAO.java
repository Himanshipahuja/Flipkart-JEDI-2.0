package com.flipkart.dao;

import com.flipkart.bean.Schedule;

import java.sql.Time;
import java.sql.Timestamp;

public interface ScheduleDAO {
    public String addSchedule(Timestamp timestamp,String slotId);
    public Integer getSlotsBookedCountFromSlotId(String slotId);
}
