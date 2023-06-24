package com.example.crpypst.ScheduleSync.service.interfaces;

import java.util.List;

import com.example.crpypst.ScheduleSync.model.Course;

public interface ICourseservice {
    
    public List<Course> getCourses();
    
    public Course getCourseById(long id);

    public Course createCourse(Course course);

    public Course updateCourse(long id, Course course);

    public boolean deleteCourseById(long id);

    public List<Course> getCoursesByLanguage(String language);
}
