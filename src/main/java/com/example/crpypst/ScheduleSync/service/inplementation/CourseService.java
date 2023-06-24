package com.example.crpypst.ScheduleSync.service.inplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crpypst.ScheduleSync.model.Course;
import com.example.crpypst.ScheduleSync.repository.ICourseRepository;
import com.example.crpypst.ScheduleSync.service.interfaces.ICourseService;

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
        return this.courseRepository.findById(id).get(); // TODO: implement Exception
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
        }).get();
    }

    @Override
    public boolean deleteCourseById(long id) {
        Course course = getCourseById(id);
        if(course!=null){
            this.courseRepository.delete(course);
            return true;
        }
        return false;
    }

    @Override
    public List<Course> getCoursesByLanguage(String language) {
        return courseRepository.findByLanguageIgnoreCase(language);   
    }
    
}
