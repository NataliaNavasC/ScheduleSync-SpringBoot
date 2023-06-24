package com.example.crpypst.ScheduleSync.model.dto;

public class CourseDTO {
    
    private long id;
    private String language;
    private String level;
    private boolean isCertified;

    public CourseDTO(long id, String language, String level, boolean isCertified) {
        this.id = id;
        this.language = language;
        this.level = level;
        this.isCertified = isCertified;
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
    
}
