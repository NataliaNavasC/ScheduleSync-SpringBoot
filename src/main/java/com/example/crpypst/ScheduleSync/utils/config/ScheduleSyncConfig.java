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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.example.crpypst.ScheduleSync.model.Course;
import com.example.crpypst.ScheduleSync.model.ScheduledSession;
import com.example.crpypst.ScheduleSync.model.Session;
import com.example.crpypst.ScheduleSync.model.StudentSession;
import com.example.crpypst.ScheduleSync.model.user.Admin;
import com.example.crpypst.ScheduleSync.model.user.Student;
import com.example.crpypst.ScheduleSync.model.user.Teacher;
import com.example.crpypst.ScheduleSync.repository.ICourseRepository;
import com.example.crpypst.ScheduleSync.repository.IScheduledSessionRepository;
import com.example.crpypst.ScheduleSync.repository.ISessionRepository;
import com.example.crpypst.ScheduleSync.repository.IStudentSessionRepository;
import com.example.crpypst.ScheduleSync.repository.IUserRepository;
import com.example.crpypst.ScheduleSync.utils.enums.CEFRLevel;
import com.example.crpypst.ScheduleSync.utils.enums.SessionType;
import com.example.crpypst.ScheduleSync.utils.enums.StudentSessionStatus;

@Configuration
public class ScheduleSyncConfig {

    @Autowired
    private Environment env;
    
    @Bean
    CommandLineRunner loadData(ICourseRepository courseRepository, ISessionRepository sessionRepository,
     IScheduledSessionRepository scheduledSessionRepository, IUserRepository userRepository, 
     BCryptPasswordEncoder bCryptPasswordEncoder, IStudentSessionRepository studentSessionRepository){
        return args -> {

            Teacher t1 = new Teacher(1, "teacher1", bCryptPasswordEncoder.encode("dummy"), true);
            Teacher t2 = new Teacher(2, "teacher2", bCryptPasswordEncoder.encode("dummy"), true);
            Teacher t3 = new Teacher(3, "teacher3", bCryptPasswordEncoder.encode("dummy"), true);
            t1 = userRepository.save(t1);
            t2 = userRepository.save(t2);
            t3 = userRepository.save(t3);
            
            Course c1 = new Course(1, "English", CEFRLevel.B2, true);
            Course c2 = new Course(3, "French", CEFRLevel.A2, true);
            c1 = courseRepository.save(c1);
            c2 = courseRepository.save(c2);

            Session s1 = new Session(1, "Verbs followed by gerunds", SessionType.CLASS, c1);
            Session s2 = new Session(2, "Verb To Be", SessionType.CLASS, c1);
            Session s3 = new Session(3, "Present continous", SessionType.QUIZ, c1);
            Session s4 = new Session(4, "Passé Composé", SessionType.CLASS, c2);
            Session s5 = new Session(5, "Les couleurs", SessionType.REVIEW, c2);
            Session s6 = new Session(6, "Past simple", SessionType.CLASS, c1);
            Session s7 = new Session(7, "Present perfect continous", SessionType.CLASS, c1);
            Session s8 = new Session(8, "Conditionals", SessionType.CLASS, c1);
            s1 = sessionRepository.save(s1);
            s2 = sessionRepository.save(s2);
            s3 = sessionRepository.save(s3);
            s4 = sessionRepository.save(s4);
            s5 = sessionRepository.save(s5);
            s5 = sessionRepository.save(s6);
            s5 = sessionRepository.save(s7);
            s5 = sessionRepository.save(s8);
            
            ScheduledSession ss1 = new ScheduledSession(1, LocalDateTime.now().plusDays(1), t1, s1);
            ScheduledSession ss2 = new ScheduledSession(2, LocalDateTime.now().plusDays(2), t2, s2);
            ScheduledSession ss3 = new ScheduledSession(3, LocalDateTime.now().plusDays(3), t3, s2);
            ScheduledSession ss4 = new ScheduledSession(4, LocalDateTime.now().plusDays(4), t1, s3);
            ScheduledSession ss5 = new ScheduledSession(5, LocalDateTime.now().plusDays(5), t2, s4);
            ScheduledSession ss6 = new ScheduledSession(6, LocalDateTime.now().plusDays(6), t1, s3);
            ScheduledSession ss7 = new ScheduledSession(7, LocalDateTime.now().plusDays(7), t2, s6);
            ScheduledSession ss8 = new ScheduledSession(8, LocalDateTime.now().plusDays(8), t2, s8);
            ScheduledSession ss9 = new ScheduledSession(9, LocalDateTime.now().plusDays(9), t1, s2);
            ScheduledSession ss10 = new ScheduledSession(10, LocalDateTime.now().plusDays(10), t2, s1);
            ScheduledSession ss11 = new ScheduledSession(11, LocalDateTime.now().plusDays(11), t1, s1);
            ScheduledSession ss12 = new ScheduledSession(12, LocalDateTime.now().plusDays(12), t2, s3);
            ScheduledSession ss13 = new ScheduledSession(13, LocalDateTime.now().plusDays(13), t2, s6);
            ScheduledSession ss14 = new ScheduledSession(14, LocalDateTime.now().plusDays(14), t1, s7);
            ScheduledSession ss15 = new ScheduledSession(15, LocalDateTime.now().plusDays(15), t2, s8);
            ScheduledSession ss16 = new ScheduledSession(16, LocalDateTime.now().plusDays(16), t1, s1);
            ScheduledSession ss17 = new ScheduledSession(17, LocalDateTime.now().plusDays(17), t2, s2);
            ScheduledSession ss18 = new ScheduledSession(18, LocalDateTime.now().plusDays(18), t2, s1);
            ScheduledSession ss19 = new ScheduledSession(19, LocalDateTime.now().plusDays(19), t1, s2);
            ss1 = scheduledSessionRepository.save(ss1);
            ss2 = scheduledSessionRepository.save(ss2);
            ss3 = scheduledSessionRepository.save(ss3);
            ss4 = scheduledSessionRepository.save(ss4);
            ss5 = scheduledSessionRepository.save(ss5);
            ss6 = scheduledSessionRepository.save(ss6);
            ss7 = scheduledSessionRepository.save(ss7);
            ss8 = scheduledSessionRepository.save(ss8);
            ss9 = scheduledSessionRepository.save(ss9);
            ss10 = scheduledSessionRepository.save(ss10);
            ss11 = scheduledSessionRepository.save(ss11);
            ss12 = scheduledSessionRepository.save(ss12);
            ss13 = scheduledSessionRepository.save(ss13);
            ss14 = scheduledSessionRepository.save(ss14);
            ss15 = scheduledSessionRepository.save(ss15);
            ss16 = scheduledSessionRepository.save(ss16);
            ss17 = scheduledSessionRepository.save(ss17);
            ss18 = scheduledSessionRepository.save(ss18);
            ss19 = scheduledSessionRepository.save(ss19);
            
            Student st1 = new Student(1, "lostvayne", bCryptPasswordEncoder.encode("dummy"), true,c1);
            Student st2 = new Student(2, "crpypst", bCryptPasswordEncoder.encode("dummy"), true,c1);
            Student st3 = new Student(3, "test", bCryptPasswordEncoder.encode("dummy"), false,c2);
            st1 = userRepository.save(st1);
            st2 = userRepository.save(st2);
            st3 = userRepository.save(st3);

            StudentSession sts1 = new StudentSession(1, StudentSessionStatus.TAKEN, st1, ss1);
            StudentSession sts2 = new StudentSession(2, StudentSessionStatus.PENDING, st1, ss2);
            StudentSession sts3 = new StudentSession(3, StudentSessionStatus.TAKEN, st2, ss1);
            StudentSession sts4 = new StudentSession(4, StudentSessionStatus.PENDING, st2, ss2);
            StudentSession sts5 = new StudentSession(5, StudentSessionStatus.TAKEN, st3, ss5);
            StudentSession sts6 = new StudentSession(6, StudentSessionStatus.CANCELLED, st3, ss6);
            StudentSession sts7 = new StudentSession(7, StudentSessionStatus.PENDING, st1, ss7);
            // StudentSession sts8 = new StudentSession(8, StudentSessionStatus.PENDING, st1, ss8);
            // StudentSession sts9 = new StudentSession(9, StudentSessionStatus.PENDING, st1, ss9);
            sts1 = studentSessionRepository.save(sts1);
            sts2 = studentSessionRepository.save(sts2);
            sts3 = studentSessionRepository.save(sts3);
            sts4 = studentSessionRepository.save(sts4);
            sts5 = studentSessionRepository.save(sts5);
            sts6 = studentSessionRepository.save(sts6);
            sts7 = studentSessionRepository.save(sts7);
            // sts8 = studentSessionRepository.save(sts8);
            // sts9 = studentSessionRepository.save(sts9);
      
            Admin a1 = new Admin(1, "crispy", bCryptPasswordEncoder.encode("dummy"), true);
            Admin a2 = new Admin(2, "lost", bCryptPasswordEncoder.encode("dummy"), true);
            userRepository.save(a1);
            userRepository.save(a2);

            
        };
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    // @Bean
    // public WebMvcConfigurer corsConfigurer(){
    //     return new WebMvcConfigurer() {
    //         public void addCorsMappings(CorsRegistry registry) {
	// 			registry.addMapping("/**")
    //             .allowedOrigins(getListProperty("cors.allowed.origins"))
	// 			.allowedMethods(getListProperty("cors.allowed.methods"))
	// 			.allowedHeaders(getListProperty("cors.allowed.headers"))
	// 			.exposedHeaders(getListProperty("cors.allowed.headers"))
	// 			.allowCredentials(getBooleanProperty("cors.allow.credentials"))
	// 			.maxAge(getLongProperty("cors.maxage"));
	// 		}
    //     };
    // }

    @Bean
    public CorsConfigurationSource corsConfigurationSource(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(getListProperty("cors.allowed.origins"));
        config.setAllowedMethods(getListProperty("cors.allowed.methods"));
        config.setAllowedHeaders(getListProperty("cors.allowed.headers"));
        config.setExposedHeaders(getListProperty("cors.exposed.headers"));
        config.setAllowCredentials(getBooleanProperty("cors.allow.credentials"));
        config.setMaxAge(getLongProperty("cors.maxage"));
        source.registerCorsConfiguration("/**", config);
        return source;
    }

    

    // private String[] getListProperty(String key){
    //     return env.getProperty(key).split(",");
    // }

    private List<String> getListProperty(String key){
        return Arrays.asList(env.getProperty(key).split(","));
    }

    private Boolean getBooleanProperty(String key){
        return Boolean.valueOf(env.getProperty(key));
    }

    private Long getLongProperty(String key){
        return Long.valueOf(env.getProperty(key));
    }

}
