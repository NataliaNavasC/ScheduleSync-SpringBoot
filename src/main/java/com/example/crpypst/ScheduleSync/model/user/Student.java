package com.example.crpypst.ScheduleSync.model.user;

import java.util.List;

import com.example.crpypst.ScheduleSync.model.Course;
import com.example.crpypst.ScheduleSync.model.ScheduledSession;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Student extends User{
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Course course;

    @ManyToMany(mappedBy = "students")
    private List<ScheduledSession> scheduledSessions;
}
