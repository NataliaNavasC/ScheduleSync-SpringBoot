package com.example.crpypst.ScheduleSync.model;

import java.time.LocalDateTime;
import java.util.List;

import com.example.crpypst.ScheduleSync.model.user.Student;
import com.example.crpypst.ScheduleSync.model.user.Teacher;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "student_session",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "scheduled_session_id")
    )
    private List<Student> students;

    public ScheduledSession() {
    }

    public ScheduledSession(long id, LocalDateTime date, Teacher teacher, List<Student> students, Session session) {
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
