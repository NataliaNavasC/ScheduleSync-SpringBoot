package com.example.crpypst.ScheduleSync.utils.config;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.crpypst.ScheduleSync.model.Course;
import com.example.crpypst.ScheduleSync.model.ScheduledSession;
import com.example.crpypst.ScheduleSync.model.Session;
import com.example.crpypst.ScheduleSync.model.user.Admin;
import com.example.crpypst.ScheduleSync.model.user.Student;
import com.example.crpypst.ScheduleSync.model.user.Teacher;
import com.example.crpypst.ScheduleSync.repository.ICourseRepository;
import com.example.crpypst.ScheduleSync.repository.IScheduledSessionRepository;
import com.example.crpypst.ScheduleSync.repository.ISessionRepository;
import com.example.crpypst.ScheduleSync.repository.IUserRepository;
import com.example.crpypst.ScheduleSync.utils.enums.CEFRLevel;
import com.example.crpypst.ScheduleSync.utils.enums.SessionType;

@Configuration
public class ScheduleSyncConfig {

    @Autowired
    private Environment env;
    
    @Bean
    CommandLineRunner loadData(ICourseRepository courseRepository, ISessionRepository sessionRepository,
     IScheduledSessionRepository scheduledSessionRepository, IUserRepository userRepository){
        return args -> {
            
            Course c1 = new Course(1, "English", CEFRLevel.B2, true);
            Course c2 = new Course(3, "French", CEFRLevel.A2, true);
            c1 = courseRepository.save(c1);
            c2 = courseRepository.save(c2);

            Session s1 = new Session(1, "Verbs followed by gerunds", SessionType.CLASS, c1);
            Session s2 = new Session(2, "Verb To Be", SessionType.CLASS, c1);
            Session s3 = new Session(3, "Present continous", SessionType.QUIZ, c1);
            Session s4 = new Session(4, "Passé Composé", SessionType.CLASS, c2);
            Session s5 = new Session(5, "Les couleurs", SessionType.REVIEW, c2);
            s1 = sessionRepository.save(s1);
            s2 = sessionRepository.save(s2);
            s3 = sessionRepository.save(s3);
            s4 = sessionRepository.save(s4);
            s5 = sessionRepository.save(s5);
            
            ScheduledSession ss1 = new ScheduledSession(1, LocalDateTime.now(), null, new ArrayList<Student>(), s1);
            ScheduledSession ss2 = new ScheduledSession(2, LocalDateTime.now(), null, new ArrayList<Student>(), s2);
            ScheduledSession ss3 = new ScheduledSession(3, LocalDateTime.now(), null, new ArrayList<Student>(), s1);
            ScheduledSession ss4 = new ScheduledSession(4, LocalDateTime.now(), null, new ArrayList<Student>(), s3);
            ScheduledSession ss5 = new ScheduledSession(5, LocalDateTime.now(), null, new ArrayList<Student>(), s4);
            ScheduledSession ss6 = new ScheduledSession(6, LocalDateTime.now(), null, new ArrayList<Student>(), s5);
            ss1 = scheduledSessionRepository.save(ss1);
            ss2 = scheduledSessionRepository.save(ss2);
            ss3 = scheduledSessionRepository.save(ss3);
            ss4 = scheduledSessionRepository.save(ss4);
            ss5 = scheduledSessionRepository.save(ss5);
            ss6 = scheduledSessionRepository.save(ss6);
            
            // Student st1 = new Student(1, "lostvayne", "dummy", true,c1,Arrays.asList(ss1,ss2));
            Student st1 = new Student(1, "lostvayne", "dummy", true,c1,new ArrayList<ScheduledSession>(Arrays.asList(ss1,ss2)));
            Student st2 = new Student(2, "crpypst", "dummy", true,c1,new ArrayList<ScheduledSession>(Arrays.asList(ss1,ss2)));
            Student st3 = new Student(3, "test", "dummy", false,c2,new ArrayList<ScheduledSession>(Arrays.asList(ss1,ss3)));
            st1 = userRepository.save(st1);
            st2 = userRepository.save(st2);
            st3 = userRepository.save(st3);

            ss1.getStudents().add(st1);
            ss1.getStudents().add(st2);
            ss1.getStudents().add(st3);
            ss2.getStudents().add(st1);
            ss2.getStudents().add(st2);
            ss3.getStudents().add(st3);
            scheduledSessionRepository.save(ss1);
            scheduledSessionRepository.save(ss2);
            scheduledSessionRepository.save(ss3);
      
            Teacher t1 = new Teacher(1, "profe1", "dummy", true);
            Teacher t2 = new Teacher(2, "profe2", "dummy", true);
            Teacher t3 = new Teacher(3, "profe3", "dummy", true);
            userRepository.save(t1);
            userRepository.save(t2);
            userRepository.save(t3);
        
            Admin a1 = new Admin(1, "crispy", "dummy", true);
            Admin a2 = new Admin(2, "lost", "dummy", true);
            userRepository.save(a1);
            userRepository.save(a2);

            
        };
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }



    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/greeting-javaconfig").allowedOrigins(getListProperty("cors.allowed.origins"));
				registry.addMapping("/greeting-javaconfig").allowedMethods(getListProperty("cors.allowed.methods"));
				registry.addMapping("/greeting-javaconfig").allowedHeaders(getListProperty("cors.allowed.headers"));
				registry.addMapping("/greeting-javaconfig").exposedHeaders(getListProperty("cors.allowed.headers"));
				registry.addMapping("/greeting-javaconfig").allowCredentials(getBooleanProperty("cors.allow.credentials"));
				registry.addMapping("/greeting-javaconfig").maxAge(getLongProperty("cors.maxage"));
			}
        };
    }

    private String[] getListProperty(String key){
        return env.getProperty(key).split(",");
    }

    private Boolean getBooleanProperty(String key){
        return Boolean.valueOf(env.getProperty(key));
    }

    private Long getLongProperty(String key){
        return Long.valueOf(env.getProperty(key));
    }

}
