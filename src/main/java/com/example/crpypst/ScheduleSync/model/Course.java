package com.example.crpypst.ScheduleSync.model;

import java.util.List;

import com.example.crpypst.ScheduleSync.model.user.Student;
import com.example.crpypst.ScheduleSync.utils.enums.CEFRLevel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "course")
    private List<Student> students;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "course")
    private List<Session> sessions;

    // === Constructor ===
    public Course() {
    }
    
    public Course(long id, String language, CEFRLevel level, boolean isCertified, List<Student> students,
            List<Session> sessions) {
        this.id = id;
        this.language = language;
        this.level = level;
        this.isCertified = isCertified;
        this.students = students;
        this.sessions = sessions;
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
