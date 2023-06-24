package com.example.crpypst.ScheduleSync.service.inplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crpypst.ScheduleSync.model.Session;
import com.example.crpypst.ScheduleSync.repository.ISessionRepository;
import com.example.crpypst.ScheduleSync.service.interfaces.ISessionService;

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
        return this.sessionRepository.findById(id).get();
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
        }).get();
    }

    @Override
    public boolean deteleSessionById(long id) {
    Session session = getSessionById(id);
        if(session!=null){
            this.sessionRepository.delete(session);
            return true;
        }
        return false;
    }

   
    
}
