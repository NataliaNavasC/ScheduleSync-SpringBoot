package com.example.crpypst.ScheduleSync.utils.config;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.crpypst.ScheduleSync.model.Course;
import com.example.crpypst.ScheduleSync.model.ScheduledSession;
import com.example.crpypst.ScheduleSync.model.Session;
import com.example.crpypst.ScheduleSync.model.user.Student;
import com.example.crpypst.ScheduleSync.repository.ICourseRepository;
import com.example.crpypst.ScheduleSync.repository.IScheduledSessionRepository;
import com.example.crpypst.ScheduleSync.repository.ISessionRepository;
import com.example.crpypst.ScheduleSync.utils.enums.CEFRLevel;
import com.example.crpypst.ScheduleSync.utils.enums.SessionType;

@Configuration
public class ScheduleSyncConfig {
    
    @Bean
    CommandLineRunner loadData(ICourseRepository courseRepository, ISessionRepository sessionRepository, IScheduledSessionRepository scheduledSessionRepository){
        return args -> {
            
            Session s1 = new Session(1, "Verbs followed by gerunds", SessionType.CLASS, null);
            Session s2 = new Session(2, "Verb To Be", SessionType.CLASS, null);
            Session s3 = new Session(3, "Present continous", SessionType.QUIZ, null);
            Session s4 = new Session(4, "Passé Composé", SessionType.CLASS, null);
            Session s5 = new Session(5, "Les couleurs", SessionType.REVIEW, null);
            sessionRepository.save(s1);
            sessionRepository.save(s2);
            sessionRepository.save(s3);
            sessionRepository.save(s4);
            sessionRepository.save(s5);

            Course c1 = new Course(1, "English", CEFRLevel.B2, true, new ArrayList<Student>());
            Course c2 = new Course(2, "English", CEFRLevel.B1, false, new ArrayList<Student>());
            Course c3 = new Course(3, "French", CEFRLevel.A2, true, new ArrayList<Student>());
            courseRepository.save(c1);
            courseRepository.save(c2);
            courseRepository.save(c3);

            ScheduledSession ss1 = new ScheduledSession(1, LocalDateTime.now(), null, null, s1);
            ScheduledSession ss2 = new ScheduledSession(2, LocalDateTime.now(), null, null, s2);
            ScheduledSession ss3 = new ScheduledSession(3, LocalDateTime.now(), null, null, s1);
            ScheduledSession ss4 = new ScheduledSession(4, LocalDateTime.now(), null, null, s3);
            ScheduledSession ss5 = new ScheduledSession(5, LocalDateTime.now(), null, null, s4);
            ScheduledSession ss6 = new ScheduledSession(6, LocalDateTime.now(), null, null, s5);
            scheduledSessionRepository.save(ss1);
            scheduledSessionRepository.save(ss2);
            scheduledSessionRepository.save(ss3);
            scheduledSessionRepository.save(ss4);
            scheduledSessionRepository.save(ss5);
            scheduledSessionRepository.save(ss6);
        };
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
