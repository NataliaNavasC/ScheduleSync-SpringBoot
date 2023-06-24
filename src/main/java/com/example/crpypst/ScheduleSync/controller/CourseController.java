package com.example.crpypst.ScheduleSync.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crpypst.ScheduleSync.model.Course;
import com.example.crpypst.ScheduleSync.service.interfaces.ICourseservice;

@RestController
@RequestMapping("/courses")
public class CourseController {
    
    @Autowired
    private ICourseservice courseservice;

    @GetMapping
    public List<Course> getCourses(){
        return courseservice.getCourses();
    }
    
}
