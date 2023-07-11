package com.example.crpypst.ScheduleSync.model.dto;

import com.example.crpypst.ScheduleSync.utils.enums.Role;

public class UserDTO{

    private long id;
    private String username;
    private CourseDTO course;
    private Role role;
    private boolean active;
    
    public UserDTO() {
    }

    public UserDTO(long id, String username, CourseDTO course,
            Role role, boolean active, boolean isLoggedIn) {
        this.id = id;
        this.username = username;
        this.course = course;
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

    public CourseDTO getCourse() {
        return course;
    }

    public void setCourse(CourseDTO course) {
        this.course = course;
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
        return "UserDTO [id=" + id + ", username=" + username + ", course=" + course
                + ", role=" + role + ", active=" + active + "]";
    }



    
    
}
