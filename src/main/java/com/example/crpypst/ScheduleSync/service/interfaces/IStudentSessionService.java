package com.example.crpypst.ScheduleSync.service.interfaces;

import java.util.List;

import com.example.crpypst.ScheduleSync.model.StudentSession;

public interface IStudentSessionService {
    
    public List<StudentSession> getStudentSessions();

    public List<StudentSession> getStudentSessionsByUsername(String username);
    
    public List<StudentSession> getStudentSessionsByScheduleSession(long id);

    public StudentSession createStudentSession(StudentSession studentSession);

    public StudentSession updateStudentSession(long id, StudentSession studentSession);
}
