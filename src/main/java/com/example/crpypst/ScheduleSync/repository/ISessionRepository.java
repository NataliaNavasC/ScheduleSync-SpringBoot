package com.example.crpypst.ScheduleSync.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.crpypst.ScheduleSync.model.Session;

public interface ISessionRepository extends JpaRepository<Session,Long>{
    
    public List<Session> getSessionsByCourseId(long id);
}
