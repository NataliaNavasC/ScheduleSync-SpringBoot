package com.example.crpypst.ScheduleSync.service.inplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crpypst.ScheduleSync.model.Session;
import com.example.crpypst.ScheduleSync.repository.ISessionRepository;
import com.example.crpypst.ScheduleSync.service.interfaces.ISessionService;
import com.example.crpypst.ScheduleSync.utils.enums.EntityType;
import com.example.crpypst.ScheduleSync.utils.exceptions.entitynotfound.EntityNotFoundException;

@Service
public class SessionService implements ISessionService{

    @Autowired
    private ISessionRepository sessionRepository;

    @Override
    public List<Session> getSessions() {
        return sessionRepository.findAll();
    }

    @Override
    public Session getSessionById(long id) {
        return this.sessionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id, EntityType.SESSION));
    }

    @Override
    public Session createSession(Session session) {
        return this.sessionRepository.save(session);
    }

    @Override
    public Session updateSession(long id, Session sessionToUpdate) {
        return this.sessionRepository.findById(id).map( session ->{
            session.setSessionType(sessionToUpdate.getSessionType());
            session.setTopic(sessionToUpdate.getTopic());
            return this.sessionRepository.save(session);
        }).orElseThrow(() -> new EntityNotFoundException(id, EntityType.SESSION));
    }

    @Override
    public boolean deteleSessionById(long id) {
        Session session = this.sessionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id, EntityType.SESSION));
        this.sessionRepository.delete(session);
        return true;
    }

   
    
}
