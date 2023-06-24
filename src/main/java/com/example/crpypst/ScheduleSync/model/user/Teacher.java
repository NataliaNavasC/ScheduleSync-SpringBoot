package com.example.crpypst.ScheduleSync.model.user;

import java.util.List;

import com.example.crpypst.ScheduleSync.model.ScheduledSession;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Teacher extends User{
    
    @Column(nullable = true)
    private double salary;

    @OneToMany(mappedBy = "teacher")
    private List<ScheduledSession> scheduledSessions;
}
