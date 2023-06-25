package com.example.crpypst.ScheduleSync.model.user;

import java.util.List;

import com.example.crpypst.ScheduleSync.model.Course;
import com.example.crpypst.ScheduleSync.model.ScheduledSession;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Student extends User{
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Course course;
    
    @ManyToMany(mappedBy = "students", fetch = FetchType.LAZY)
    private List<ScheduledSession> scheduledSessions;

    public Student() {
    }

    public Student(long id, String username, String password, boolean isActive, Course course, List<ScheduledSession> sessions) {
        super(id, username, password, isActive);
        this.course = course;
        this.scheduledSessions = sessions;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<ScheduledSession> getScheduledSessions() {
        return scheduledSessions;
    }

    public void setScheduledSessions(List<ScheduledSession> scheduledSessions) {
        this.scheduledSessions = scheduledSessions;
    }

        
}
