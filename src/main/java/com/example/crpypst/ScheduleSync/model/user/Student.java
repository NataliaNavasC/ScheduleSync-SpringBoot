package com.example.crpypst.ScheduleSync.model.user;

import com.example.crpypst.ScheduleSync.model.Course;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;

@Entity
public class Student extends User{
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Course course;
    
    public Student() {
    }

    public Student(long id, String username, String password, boolean isActive, Course course) {
        super(id, username, password, isActive);
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return super.toString() + " Student [course=" + course + " ]";
    }

    
        
}
