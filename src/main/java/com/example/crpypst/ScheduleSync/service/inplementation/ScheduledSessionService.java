package com.example.crpypst.ScheduleSync.service.inplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crpypst.ScheduleSync.model.ScheduledSession;
import com.example.crpypst.ScheduleSync.repository.IScheduledSessionRepository;
import com.example.crpypst.ScheduleSync.service.interfaces.IScheduledSessionService;

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
        return this.scheduledSessionRepository.findById(id).get();
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
        }).get();
    }

    @Override
    public boolean deteleSessionById(long id) {
        ScheduledSession scheduledSession = getScheduledSessionById(id);
        if(scheduledSession!=null){
            this.scheduledSessionRepository.delete(scheduledSession);
            return true;
        }
        return false;
    }


}
