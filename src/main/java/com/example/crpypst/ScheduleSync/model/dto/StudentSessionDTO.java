package com.example.crpypst.ScheduleSync.model.dto;

import com.example.crpypst.ScheduleSync.utils.enums.StudentSessionStatus;

public class StudentSessionDTO {

    private long id;

    private StudentSessionStatus studentSessionStatus;

    private UserDTO student;

    private ScheduledSessionDTO scheduledSession;

    public StudentSessionDTO() {
    }

    public StudentSessionDTO(long id, StudentSessionStatus studentSessionStatus, UserDTO student,
            ScheduledSessionDTO scheduledSession) {
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

    public UserDTO getStudent() {
        return student;
    }

    public void setStudent(UserDTO student) {
        this.student = student;
    }

    public ScheduledSessionDTO getScheduledSession() {
        return scheduledSession;
    }

    public void setScheduledSession(ScheduledSessionDTO scheduledSession) {
        this.scheduledSession = scheduledSession;
    }

    public StudentSessionStatus getStudentSessionStatus() {
        return studentSessionStatus;
    }

    public void setStudentSessionStatus(StudentSessionStatus studentSessionStatus) {
        this.studentSessionStatus = studentSessionStatus;
    }

}
