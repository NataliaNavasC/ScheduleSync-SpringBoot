package com.example.crpypst.ScheduleSync.model;

import com.example.crpypst.ScheduleSync.utils.enums.CEFRLevel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String language;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private CEFRLevel level;

    @Column(nullable = false)
    private boolean isCertified;

    // === Constructor ===
    public Course() {
    }
    
    public Course(long id, String language, CEFRLevel level, boolean isCertified) {
        this.id = id;
        this.language = language;
        this.level = level;
        this.isCertified = isCertified;
    }

    // === Getters and Setters ===
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

    public CEFRLevel getLevel() {
        return level;
    }

    public void setLevel(CEFRLevel level) {
        this.level = level;
    }

    public boolean isCertified() {
        return isCertified;
    }

    public void setCertified(boolean isCertified) {
        this.isCertified = isCertified;
    }

}
