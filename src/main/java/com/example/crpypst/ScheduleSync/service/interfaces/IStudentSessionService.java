package com.example.crpypst.ScheduleSync.service.interfaces;

import java.util.List;

import com.example.crpypst.ScheduleSync.model.StudentSession;
import com.example.crpypst.ScheduleSync.model.dto.SessionDTO;

public interface IStudentSessionService {
    
    public List<StudentSession> getStudentSessions();

    public StudentSession getStudentSessionById(long id);

    public List<StudentSession> getStudentSessionsByUsername(String username);
    
    public List<StudentSession> getStudentSessionsByScheduleSession(long id);

    public StudentSession createStudentSession(StudentSession studentSession);

    public StudentSession updateStudentSession(long id, StudentSession studentSession);

    public boolean deleteStudentSessionById(long id);

}
