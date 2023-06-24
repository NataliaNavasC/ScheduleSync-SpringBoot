package com.example.crpypst.ScheduleSync.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crpypst.ScheduleSync.model.Course;

public interface ICourseRepository extends JpaRepository<Course,Long>{
    
    public List<Course> findByLanguage(String language);
}
