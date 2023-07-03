package com.example.crpypst.ScheduleSync.model;

import java.time.LocalDateTime;

import com.example.crpypst.ScheduleSync.model.user.Teacher;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ScheduledSession {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private LocalDateTime date;

    @ManyToOne
    private Teacher teacher;
    
    @ManyToOne
    private Session session;

    public ScheduledSession() {
    }

    public ScheduledSession(long id, LocalDateTime date, Teacher teacher, Session session) {
        this.id = id;
        this.date = date;
        this.teacher = teacher;
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

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

}
