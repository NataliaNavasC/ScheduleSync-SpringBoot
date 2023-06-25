package com.example.crpypst.ScheduleSync.model.dto;

import java.util.List;


public class CourseDTO {
    
    private long id;
    private String language;
    private String level;
    private boolean isCertified;
    private List<UserDTO> students;
    private List<SessionDTO> sessions;
    
    public CourseDTO() {
    }

    public CourseDTO(long id, String language, String level, boolean isCertified, List<UserDTO> students,
            List<SessionDTO> sessions) {
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

    public List<UserDTO> getStudents() {
        return students;
    }

    public void setStudents(List<UserDTO> students) {
        this.students = students;
    }

    public List<SessionDTO> getSessions() {
        return sessions;
    }

    public void setSessions(List<SessionDTO> sessions) {
        this.sessions = sessions;
    }

    
    
}
