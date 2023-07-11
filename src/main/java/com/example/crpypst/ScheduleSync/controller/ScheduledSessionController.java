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

import com.example.crpypst.ScheduleSync.model.ScheduledSession;
import com.example.crpypst.ScheduleSync.model.dto.ScheduledSessionDTO;
import com.example.crpypst.ScheduleSync.service.interfaces.IScheduledSessionService;
import com.example.crpypst.ScheduleSync.utils.general.DTOConverter;

@RestController
@RequestMapping("/scheduledSessions")
public class ScheduledSessionController {
    
    @Autowired
    private IScheduledSessionService scheduledSessionService;

    @Autowired
    private DTOConverter dtoConverter;

    @GetMapping
    public List<ScheduledSessionDTO> getScheduledSession(){
        return dtoConverter.convertListType(scheduledSessionService.getScheduledSessions(), ScheduledSessionDTO.class);
    }

    @GetMapping("/{id}")
    public ScheduledSessionDTO getScheduledSessionById(@PathVariable long id){
        return dtoConverter.convertType(scheduledSessionService.getScheduledSessionById(id), ScheduledSessionDTO.class);
    }

    @PostMapping
    public ScheduledSessionDTO createScheduledSession(@RequestBody ScheduledSessionDTO scheduledSessionDTO){
        ScheduledSession scheduledSession = dtoConverter.convertType(scheduledSessionDTO, ScheduledSession.class);
        return dtoConverter.convertType(scheduledSessionService.createScheduledSession(scheduledSession), ScheduledSessionDTO.class);
    }

    @PutMapping("/{id}")
    public ScheduledSessionDTO updateScheduledSession(@PathVariable long id, @RequestBody ScheduledSessionDTO scheduledSessionDTO){
        ScheduledSession scheduledSession = dtoConverter.convertType(scheduledSessionDTO, ScheduledSession.class);
        return dtoConverter.convertType(scheduledSessionService.updateScheduledSession(id,scheduledSession), ScheduledSessionDTO.class);
    }

    @DeleteMapping("/{id}")
    public boolean deleteScheduledSession(@PathVariable long id){
        return scheduledSessionService.deteleSessionById(id);
    }

    @GetMapping("/session/{id}")
    public List<ScheduledSessionDTO> getScheduledSessionBySessionId(@PathVariable long id, @RequestParam(defaultValue = "true") boolean future ){
        return dtoConverter.convertListType(scheduledSessionService.getScheduledSessionBySessionId(id,future), ScheduledSessionDTO.class);
    }

    @GetMapping("/teacher/{username}")
    public List<ScheduledSessionDTO> getScheduledSessionByTeacherUsername(@PathVariable String username){
        return dtoConverter.convertListType(scheduledSessionService.getScheduledSessionByTeacherUsername(username), ScheduledSessionDTO.class);
    }
    

}
