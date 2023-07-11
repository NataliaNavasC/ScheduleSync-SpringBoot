package com.example.crpypst.ScheduleSync.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crpypst.ScheduleSync.model.ScheduledSession;

public interface IScheduledSessionRepository extends JpaRepository<ScheduledSession,Long>{
    
    public List<ScheduledSession> findBySessionId(long id);

    public List<ScheduledSession> findByTeacherUsername(String username);
}
