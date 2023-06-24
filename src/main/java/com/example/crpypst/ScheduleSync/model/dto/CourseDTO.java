package com.example.crpypst.ScheduleSync.model.dto;

import java.util.List;

import com.example.crpypst.ScheduleSync.model.Session;
import com.example.crpypst.ScheduleSync.model.user.Student;

public class CourseDTO {
    
    private long id;
    private String language;
    private String level;
    private boolean isCertified;
    private List<Student> students;
    private List<Session> sessions;
    
    public CourseDTO() {
    }

    public CourseDTO(long id, String language, String level, boolean isCertified, List<Student> students,
            List<Session> sessions) {
        this.id = id;
        this.language = language;
        this.level = level;
        this.isCertified = isCertified;
        this.students = students;
        this.sessions = sessions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public boolean isCertified() {
        return isCertified;
    }

    public void setCertified(boolean isCertified) {
        this.isCertified = isCertified;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    
    
}
