package com.example.crpypst.ScheduleSync.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crpypst.ScheduleSync.model.StudentSession;

public interface IStudentSessionRepository extends JpaRepository<StudentSession,Long>{
    
    public List<StudentSession> findByStudentUsername(String username);

    public List<StudentSession> findByScheduledSessionId(long id);
}
