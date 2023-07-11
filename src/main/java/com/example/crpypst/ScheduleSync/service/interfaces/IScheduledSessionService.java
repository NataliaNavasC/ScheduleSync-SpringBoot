package com.example.crpypst.ScheduleSync.service.interfaces;

import java.util.List;

import com.example.crpypst.ScheduleSync.model.ScheduledSession;

public interface IScheduledSessionService {
    
    public List<ScheduledSession> getScheduledSessions();

    public ScheduledSession getScheduledSessionById(long id);

    public ScheduledSession createScheduledSession(ScheduledSession scheduledSession);

    public ScheduledSession updateScheduledSession(long id, ScheduledSession scheduledSession);

    public boolean deteleSessionById(long id);

    public List<ScheduledSession> getScheduledSessionBySessionId(long id, boolean future);

    public List<ScheduledSession> getScheduledSessionByTeacherUsername(String username);
}
