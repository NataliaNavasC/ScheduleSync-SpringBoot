package com.example.crpypst.ScheduleSync.service.inplementation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crpypst.ScheduleSync.model.ScheduledSession;
import com.example.crpypst.ScheduleSync.repository.IScheduledSessionRepository;
import com.example.crpypst.ScheduleSync.service.interfaces.IScheduledSessionService;
import com.example.crpypst.ScheduleSync.utils.enums.EntityType;
import com.example.crpypst.ScheduleSync.utils.exceptions.entitynotfound.EntityNotFoundException;

@Service
public class ScheduledSessionService implements IScheduledSessionService{
    
    @Autowired
    private IScheduledSessionRepository scheduledSessionRepository;

    @Override
    public List<ScheduledSession> getScheduledSessions() {
        return this.scheduledSessionRepository.findAll();
    }

    @Override
    public ScheduledSession getScheduledSessionById(long id) {
        return this.scheduledSessionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id, EntityType.SCHEDULED_SESSION));
    }

    @Override
    public ScheduledSession createScheduledSession(ScheduledSession scheduledSession) {
        return this.scheduledSessionRepository.save(scheduledSession);
    }

    @Override
    public ScheduledSession updateScheduledSession(long id, ScheduledSession scheduledSessionToUpdate) {
        return this.scheduledSessionRepository.findById(id).map(  scheduledSession ->{
            scheduledSession.setDate(scheduledSessionToUpdate.getDate());
            scheduledSession.setTeacher(scheduledSessionToUpdate.getTeacher());
            return scheduledSessionRepository.save(scheduledSession);
        }).orElseThrow(() -> new EntityNotFoundException(id, EntityType.SCHEDULED_SESSION));
    }

    @Override
    public boolean deteleSessionById(long id) {
        ScheduledSession scheduledSession = this.scheduledSessionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id, EntityType.SCHEDULED_SESSION));
        this.scheduledSessionRepository.delete(scheduledSession);
        return true;
    }

    @Override
    public List<ScheduledSession> getScheduledSessionBySessionId(long id, boolean future) {
        List<ScheduledSession> scheduledSessions = this.scheduledSessionRepository.findBySessionId(id);
        if(future){
            scheduledSessions.stream().filter(ss -> ss.getDate().compareTo(LocalDateTime.now())>0).toList();
        }
        return scheduledSessions;
    }

    @Override
    public List<ScheduledSession> getScheduledSessionByTeacherUsername(String username) {
        return this.scheduledSessionRepository.findByTeacherUsername(username);
    }



}
