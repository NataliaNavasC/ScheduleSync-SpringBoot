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
    private DTOConverter<ScheduledSessionDTO,ScheduledSession>   dtoConverter;

    @GetMapping
    public List<ScheduledSessionDTO> getScheduledSession(){
        System.out.println("TESTTTTTTTTTT");
        return dtoConverter.convertEntitiesToDTOs(scheduledSessionService.getScheduledSessions(), ScheduledSessionDTO.class);
    }

    @GetMapping("/{id}")
    public ScheduledSessionDTO getScheduledSessionById(@PathVariable long id){
        return dtoConverter.entityToDTO(scheduledSessionService.getScheduledSessionById(id), ScheduledSessionDTO.class);
    }

    @PostMapping
    public ScheduledSessionDTO createScheduledSession(@RequestBody ScheduledSessionDTO scheduledSessionDTO){
        ScheduledSession scheduledSession = dtoConverter.dtoToEntity(scheduledSessionDTO, ScheduledSession.class);
        return dtoConverter.entityToDTO(scheduledSessionService.createScheduledSession(scheduledSession), ScheduledSessionDTO.class);
    }

    @PutMapping("/{id}")
    public ScheduledSessionDTO updateScheduledSession(@PathVariable long id, @RequestBody ScheduledSessionDTO scheduledSessionDTO){
        ScheduledSession scheduledSession = dtoConverter.dtoToEntity(scheduledSessionDTO, ScheduledSession.class);
        return dtoConverter.entityToDTO(scheduledSessionService.updateScheduledSession(id,scheduledSession), ScheduledSessionDTO.class);
    }

    @DeleteMapping("/{id}")
    public boolean deleteScheduledSession(@PathVariable long id){
        return scheduledSessionService.deteleSessionById(id);
    }

}
