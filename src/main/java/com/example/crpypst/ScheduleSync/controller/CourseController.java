package com.example.crpypst.ScheduleSync.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.crpypst.ScheduleSync.model.Course;
import com.example.crpypst.ScheduleSync.model.dto.CourseDTO;
import com.example.crpypst.ScheduleSync.service.interfaces.ICourseService;
import com.example.crpypst.ScheduleSync.utils.general.DTOConverter;

@RestController
@RequestMapping("/courses")
public class CourseController {
    
    @Autowired
    private ICourseService courseservice;

    @Autowired
    private DTOConverter dtoConverter;

    @GetMapping
    public List<CourseDTO> getCourses(){
        return dtoConverter.convertListType(courseservice.getCourses(), CourseDTO.class);
    }

    @GetMapping("/{id}")
    public CourseDTO getCourseById(@PathVariable long id){
        return dtoConverter.convertType(courseservice.getCourseById(id),CourseDTO.class);
    }

    @PostMapping
    public CourseDTO createCourse(@RequestBody CourseDTO courseDto){
        Course course = dtoConverter.convertType(courseDto, Course.class);
        return dtoConverter.convertType(courseservice.createCourse(course), CourseDTO.class);
    }

    @PutMapping("/{id}")
    public CourseDTO updateCourse(@PathVariable long id, @RequestBody CourseDTO courseDto){
        Course course = dtoConverter. convertType(courseDto, Course.class);
        return dtoConverter.convertType(courseservice.updateCourse(id, course), CourseDTO.class);
    }

    @DeleteMapping("/{id}")
    public boolean deleteCourseById(@PathVariable long id){
        return courseservice.deleteCourseById(id);
    }

    @GetMapping("/search")
    public List<CourseDTO> getCoursesByLanguage(@RequestParam String language){
        return dtoConverter.convertListType(courseservice.getCoursesByLanguage(language), CourseDTO.class);
    }
    
}
