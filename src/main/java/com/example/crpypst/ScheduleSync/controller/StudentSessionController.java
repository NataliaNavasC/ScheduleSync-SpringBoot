package com.example.crpypst.ScheduleSync.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crpypst.ScheduleSync.model.StudentSession;
import com.example.crpypst.ScheduleSync.model.dto.StudentSessionDTO;
import com.example.crpypst.ScheduleSync.service.interfaces.IStudentSessionService;
import com.example.crpypst.ScheduleSync.utils.general.DTOConverter;

@RestController
@RequestMapping("studentSessions")
public class StudentSessionController {
    
    @Autowired
    private DTOConverter dtoConverter;

    @Autowired
    private IStudentSessionService studentSessionService;

    @GetMapping
    public List<StudentSessionDTO> getStudentSessions(){
        return this.dtoConverter.convertListType(this.studentSessionService.getStudentSessions(), StudentSessionDTO.class);
    }

    @GetMapping("/{id}")
    public StudentSessionDTO getStudentSessionById(@PathVariable long id){
        return this.dtoConverter.convertType(this.studentSessionService.getStudentSessionById(id), StudentSessionDTO.class);
    }

    @GetMapping("/student/{username}")
    public List<StudentSessionDTO> getStudentSessionsByStudentUsername(@PathVariable String username){
        return this.dtoConverter.convertListType(this.studentSessionService.getStudentSessionsByUsername(username), StudentSessionDTO.class);
    }
    
    @GetMapping("/scheduledsession/{id}")
    public List<StudentSessionDTO> getStudentSessionsByScheduledSession(@PathVariable Long id){
        return this.dtoConverter.convertListType(this.studentSessionService.getStudentSessionsByScheduleSession(id), StudentSessionDTO.class);
    }

    @PostMapping
    public StudentSessionDTO CreateStudentSession(@RequestBody StudentSessionDTO studentSessionDTO){
        StudentSession studentSession = dtoConverter.convertType(studentSessionDTO,StudentSession.class);
        return dtoConverter.convertType(this.studentSessionService.createStudentSession(studentSession), StudentSessionDTO.class);
    }

    @DeleteMapping("/{id}")
    public boolean deleteStudentSessionById(@PathVariable long id){
        return this.studentSessionService.deleteStudentSessionById(id);
    }

}
