package com.example.crpypst.ScheduleSync.model.dto;

import java.util.List;

import com.example.crpypst.ScheduleSync.utils.enums.SessionType;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class SessionDTO {

    private long id;
    private String topic;
    private SessionType sessionType;
    private CourseDTO course;
    @JsonIgnore
    private List<ScheduledSessionDTO> scheduledSessions;
    
    
    public SessionDTO() {
    }

    public SessionDTO(long id, String topic, SessionType sessionType, CourseDTO course,
            List<ScheduledSessionDTO> scheduledSessions) {
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

    public CourseDTO getCourse() {
        return course;
    }

    public void setCourse(CourseDTO course) {
        this.course = course;
    }

    public List<ScheduledSessionDTO> getScheduledSessions() {
        return scheduledSessions;
    }

    public void setScheduledSessions(List<ScheduledSessionDTO> scheduledSessions) {
        this.scheduledSessions = scheduledSessions;
    }

}
