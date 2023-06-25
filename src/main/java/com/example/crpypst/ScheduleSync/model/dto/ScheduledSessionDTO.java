package com.example.crpypst.ScheduleSync.model.dto;

import java.time.LocalDateTime;
import java.util.List;


public class ScheduledSessionDTO {
    
    private long id;
    private LocalDateTime date;
    private UserDTO teacher;
    private List<UserDTO> students;
    private SessionDTO session;
    
    public ScheduledSessionDTO() {
    }

    public ScheduledSessionDTO(long id, LocalDateTime date, UserDTO teacher, List<UserDTO> students, SessionDTO session) {
        this.id = id;
        this.date = date;
        this.teacher = teacher;
        this.students = students;
        this.session = session;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public UserDTO getTeacher() {
        return teacher;
    }

    public void setTeacher(UserDTO teacher) {
        this.teacher = teacher;
    }

    public List<UserDTO> getStudents() {
        return students;
    }

    public void setStudents(List<UserDTO> students) {
        this.students = students;
    }

    public SessionDTO getSession() {
        return session;
    }

    public void setSession(SessionDTO session) {
        this.session = session;
    }

}
