package com.example.crpypst.ScheduleSync.model.dto;

import com.example.crpypst.ScheduleSync.utils.enums.ScheduleSessionStatus;

public class StudentSessionDTO {

    private long id;

    private ScheduleSessionStatus scheduleSessionStatus;

    public StudentSessionDTO() {
    }

    public StudentSessionDTO(long id, ScheduleSessionStatus scheduleSessionStatus) {
        this.id = id;
        this.scheduleSessionStatus = scheduleSessionStatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ScheduleSessionStatus getScheduleSessionStatus() {
        return scheduleSessionStatus;
    }

    public void setScheduleSessionStatus(ScheduleSessionStatus scheduleSessionStatus) {
        this.scheduleSessionStatus = scheduleSessionStatus;
    }

    

}
