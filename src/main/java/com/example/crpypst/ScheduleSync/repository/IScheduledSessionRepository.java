package com.example.crpypst.ScheduleSync.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crpypst.ScheduleSync.model.ScheduledSession;

public interface IScheduledSessionRepository extends JpaRepository<ScheduledSession,Long>{
    
}
