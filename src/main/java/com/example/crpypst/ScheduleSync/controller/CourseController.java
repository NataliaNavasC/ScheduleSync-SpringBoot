package com.example.crpypst.ScheduleSync.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.domain.Sort.Direction;
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
import com.example.crpypst.ScheduleSync.service.interfaces.ICourseservice;
import com.example.crpypst.ScheduleSync.utils.general.DTOConverter;

@RestController
@RequestMapping("/courses")
public class CourseController {
    
    @Autowired
    private ICourseservice courseservice;

    @Autowired
    private DTOConverter<CourseDTO,Course> dtoConverter;

    @GetMapping
    public List<CourseDTO> getCourses(){
        return dtoConverter.convertEntitiesToDTOs(courseservice.getCourses(), CourseDTO.class);
    }

    @GetMapping("/{id}")
    public CourseDTO getCourseById(@PathVariable long id){
        return dtoConverter.entityToDTO(courseservice.getCourseById(id),CourseDTO.class);
    }

    @PostMapping
    public CourseDTO createCourse(@RequestBody CourseDTO courseDto){
        Course course = dtoConverter.dtoToEntity(courseDto, Course.class);
        return dtoConverter.entityToDTO(courseservice.createCourse(course), CourseDTO.class);
    }

    @PutMapping("/{id}")
    public CourseDTO updateCourse(@PathVariable long id, @RequestBody CourseDTO courseDto){
        Course course = dtoConverter.dtoToEntity(courseDto, Course.class);
        return dtoConverter.entityToDTO(courseservice.updateCourse(id, course), CourseDTO.class);
    }

    @DeleteMapping("/{id}")
    public boolean deleteCourseById(@PathVariable long id){
        return courseservice.deleteCourseById(id);
    }

    @GetMapping("/search")
    public List<CourseDTO> getCoursesByLanguage(@RequestParam String language){
        return dtoConverter.convertEntitiesToDTOs(courseservice.getCoursesByLanguage(language), CourseDTO.class);
    }
    
}
