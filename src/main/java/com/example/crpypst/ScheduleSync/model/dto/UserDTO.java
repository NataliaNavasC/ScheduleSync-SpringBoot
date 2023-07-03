package com.example.crpypst.ScheduleSync.model.dto;

import java.util.List;

import com.example.crpypst.ScheduleSync.utils.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDTO{

    private long id;
    private String username;
    private String password;
    private CourseDTO course;
    @JsonIgnore
    private List<ScheduledSessionDTO> scheduledSessions;
    private Role role;
    private boolean active;
    
    public UserDTO() {
    }

    public UserDTO(long id, String username, String password, CourseDTO course, List<ScheduledSessionDTO> scheduledSessions,
            Role role, boolean active, boolean isLoggedIn) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.course = course;
        this.scheduledSessions = scheduledSessions;
        this.role = role;
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    

    @Override
    public String toString() {
        return "UserDTO [id=" + id + ", username=" + username + ", password=" + password + ", course=" + course
                + ", scheduledSessions=" + scheduledSessions + ", role=" + role + ", active=" + active + "]";
    }



    
    
}
