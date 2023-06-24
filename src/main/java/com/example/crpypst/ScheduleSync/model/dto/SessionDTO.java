package com.example.crpypst.ScheduleSync.model.dto;

import java.util.List;

import com.example.crpypst.ScheduleSync.model.Course;
import com.example.crpypst.ScheduleSync.model.ScheduledSession;
import com.example.crpypst.ScheduleSync.utils.enums.SessionType;

public class SessionDTO {

    private long id;
    private String topic;
    private SessionType sessionType;
    private Course course;
    private List<ScheduledSession> scheduledSessions;
    
    
    public SessionDTO() {
    }

    public SessionDTO(long id, String topic, SessionType sessionType, Course course,
            List<ScheduledSession> scheduledSessions) {
        this.id = id;
        this.topic = topic;
        this.sessionType = sessionType;
        this.course = course;
        this.scheduledSessions = scheduledSessions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public SessionType getSessionType() {
        return sessionType;
    }

    public void setSessionType(SessionType sessionType) {
        this.sessionType = sessionType;
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
