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
import org.springframework.web.bind.annotation.RestController;

import com.example.crpypst.ScheduleSync.model.Session;
import com.example.crpypst.ScheduleSync.model.dto.SessionDTO;
import com.example.crpypst.ScheduleSync.service.interfaces.ISessionService;
import com.example.crpypst.ScheduleSync.utils.general.DTOConverter;

@RestController
@RequestMapping("/sessions")
public class SessionController {
    
    @Autowired
    private ISessionService sessionService;

    @Autowired
    private DTOConverter dtoConverter;

    @GetMapping
    public List<SessionDTO> getSessions(){
        return dtoConverter.convertListType(sessionService.getSessions(),SessionDTO.class);
    }

    @GetMapping("/{id}")
    public SessionDTO getSessionById(@PathVariable long id){
        return dtoConverter.convertType(sessionService.getSessionById(id), SessionDTO.class);
    }

    @PostMapping
    public SessionDTO createSession(@RequestBody SessionDTO sessionDto){
        Session session = dtoConverter.convertType(sessionDto, Session.class);
        return dtoConverter.convertType(sessionService.createSession(session), SessionDTO.class);
    }

    @PutMapping("/{id}")
    public SessionDTO updateSession(@PathVariable long id, @RequestBody SessionDTO sessionDto){
        Session session = dtoConverter.convertType(sessionDto, Session.class);
        return dtoConverter.convertType(sessionService.updateSession(id, session), SessionDTO.class);
    }

    @DeleteMapping("/{id}")
    public boolean deleteSession(@PathVariable long id){
        return sessionService.deteleSessionById(id);
    }
}
