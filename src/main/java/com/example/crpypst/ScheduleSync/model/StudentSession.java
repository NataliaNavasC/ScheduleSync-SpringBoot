package com.example.crpypst.ScheduleSync.model;

import com.example.crpypst.ScheduleSync.model.user.Student;
import com.example.crpypst.ScheduleSync.utils.enums.StudentSessionStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class StudentSession {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Enumerated(value = EnumType.STRING)
    private StudentSessionStatus studentSessionStatus;

    @ManyToOne
    private Student student;

    @ManyToOne
    @JoinColumn(nullable = false)
    ScheduledSession scheduledSession;

    public StudentSession() {
    }

    public StudentSession(long id, StudentSessionStatus studentSessionStatus, Student student,
            ScheduledSession scheduledSession) {
        this.id = id;
        this.studentSessionStatus = studentSessionStatus;
        this.student = student;
        this.scheduledSession = scheduledSession;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public ScheduledSession getScheduledSession() {
        return scheduledSession;
    }

    public void setScheduledSession(ScheduledSession scheduledSession) {
        this.scheduledSession = scheduledSession;
    }

    public StudentSessionStatus getStudentSessionStatus() {
        return studentSessionStatus;
    }

    public void setStudentSessionStatus(StudentSessionStatus studentSessionStatus) {
        this.studentSessionStatus = studentSessionStatus;
    }

}
