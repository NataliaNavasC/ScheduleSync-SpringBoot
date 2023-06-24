package com.example.crpypst.ScheduleSync.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.crpypst.ScheduleSync.model.Session;

public interface ISessionRepository extends JpaRepository<Session,Long>{
    
}
