package com.flipkart.business;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.flipkart.dao.ScheduleDAO;
import com.flipkart.bean.Schedule;
import com.flipkart.bean.Slot;

public class ScheduleServiceImpl implements ScheduleServiceInterface{


    @Override
    public Schedule createSchedule(Date date, String slotId) {
        return null;
    }

    @Override
    public Schedule getScheduleByDateAndSlotId(String SlotId, Date date) {
        return null;
    }

    @Override
    public boolean modifySchedule(String scheduleId, int action) {
        return false;
    }

    @Override
    public List<Schedule> checkAvailability(String centreID, Date date) {
        return List.of();
    }

    @Override
    public List<Slot> getAllAvailableSlotsByDate(String centreID, Date date) {
        return List.of();
    }

    @Override
    public Schedule getOrCreateSchedule(String slotId, Date date) {
        return null;
    }
}
