package com.example.crpypst.ScheduleSync.service.interfaces;

import java.util.List;

import com.example.crpypst.ScheduleSync.model.Session;

public interface ISessionService {

    public List<Session> getSessions();
    
    public Session getSessionById(long id);

    public Session createSession(Session session);

    public Session updateSession(long id, Session session);

    public boolean deteleSessionById(long id);

    public List<Session> getSessionsByCourseId(long id);

}
