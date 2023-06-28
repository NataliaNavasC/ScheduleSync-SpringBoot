package com.example.crpypst.ScheduleSync.service.inplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crpypst.ScheduleSync.model.Course;
import com.example.crpypst.ScheduleSync.repository.ICourseRepository;
import com.example.crpypst.ScheduleSync.service.interfaces.ICourseService;
import com.example.crpypst.ScheduleSync.utils.enums.EntityType;
import com.example.crpypst.ScheduleSync.utils.exceptions.entitynotfound.EntityNotFoundException;

@Service
public class CourseService implements ICourseService{

    @Autowired
    private ICourseRepository courseRepository;

    @Override
    public List<Course> getCourses() {
        return this.courseRepository.findAll();
    }

    @Override
    public Course getCourseById(long id) {
        return this.courseRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id, EntityType.COURSE));
    }

    @Override
    public Course createCourse(Course course) {
        return this.courseRepository.save(course);
    }

    @Override
    public Course updateCourse(long id, Course courseToUpdate) {
        return this.courseRepository.findById(id).map( course ->{
            course.setLanguage(courseToUpdate.getLanguage());
            course.setLevel(courseToUpdate.getLevel());
            course.setCertified(courseToUpdate.isCertified());
            return this.courseRepository.save(course);
        }).orElseThrow(() -> new EntityNotFoundException(id, EntityType.COURSE));
    }

    @Override
    public boolean deleteCourseById(long id) {
        Course course = this.courseRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id, EntityType.COURSE));
        this.courseRepository.delete(course);
        return true;
    }

    @Override
    public List<Course> getCoursesByLanguage(String language) {
        return courseRepository.findByLanguageIgnoreCase(language);   
    }
    
}
