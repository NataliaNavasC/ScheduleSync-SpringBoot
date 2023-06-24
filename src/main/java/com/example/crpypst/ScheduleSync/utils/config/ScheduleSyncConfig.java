package com.example.crpypst.ScheduleSync.utils.config;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.crpypst.ScheduleSync.model.Course;
import com.example.crpypst.ScheduleSync.model.Session;
import com.example.crpypst.ScheduleSync.model.user.Student;
import com.example.crpypst.ScheduleSync.repository.ICourseRepository;
import com.example.crpypst.ScheduleSync.utils.enums.CEFRLevel;

@Configuration
public class ScheduleSyncConfig {
    
    @Bean
    CommandLineRunner loadData(ICourseRepository courseRepository){
        return args -> {
            Course c1 = new Course(1, "English", CEFRLevel.B2, true, new ArrayList<Student>(), new ArrayList<Session>());
            Course c2 = new Course(2, "English", CEFRLevel.B1, false, new ArrayList<Student>(), new ArrayList<Session>());
            Course c3 = new Course(3, "French", CEFRLevel.A2, true, new ArrayList<Student>(), new ArrayList<Session>());
            courseRepository.save(c1);
            courseRepository.save(c2);
            courseRepository.save(c3);
        };
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
