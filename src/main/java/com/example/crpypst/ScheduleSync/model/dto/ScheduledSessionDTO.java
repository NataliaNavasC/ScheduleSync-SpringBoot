package com.example.crpypst.ScheduleSync.model.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.example.crpypst.ScheduleSync.model.Session;
import com.example.crpypst.ScheduleSync.model.user.Student;
import com.example.crpypst.ScheduleSync.model.user.Teacher;


public class ScheduledSessionDTO {
    
    private long id;
    private LocalDateTime date;
    private Teacher teacher;
    private List<Student> students;
    private Session session;
    
    public ScheduledSessionDTO() {
    }

    public ScheduledSessionDTO(long id, LocalDateTime date, Teacher teacher, List<Student> students, Session session) {
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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

}
