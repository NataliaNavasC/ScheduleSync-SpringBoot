package com.example.crpypst.ScheduleSync.service.inplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crpypst.ScheduleSync.model.StudentSession;
import com.example.crpypst.ScheduleSync.repository.IStudentSessionRepository;
import com.example.crpypst.ScheduleSync.service.interfaces.IStudentSessionService;
import com.example.crpypst.ScheduleSync.utils.enums.EntityType;
import com.example.crpypst.ScheduleSync.utils.exceptions.entitynotfound.EntityNotFoundException;

@Service
public class StudentSessionService implements IStudentSessionService{
    
    @Autowired
    private IStudentSessionRepository studentSessionRepository;

    @Override
    public List<StudentSession> getStudentSessions() {
        return this.studentSessionRepository.findAll();
    }
    
    @Override
    public StudentSession getStudentSessionById(long id){
        return this.studentSessionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id, EntityType.STUDENT_SESSION));
    }

    @Override
    public List<StudentSession> getStudentSessionsByUsername(String username) {
        return this.studentSessionRepository.findByStudentUsername(username);
    }

    @Override
    public List<StudentSession> getStudentSessionsByScheduleSession(long id) {
        return this.studentSessionRepository.findByScheduledSessionId(id);
    }

    @Override
    public StudentSession createStudentSession(StudentSession studentSession) {
        return this.studentSessionRepository.save(studentSession);
    }

    @Override
    public StudentSession updateStudentSession(long id, StudentSession studentSessionToUpdate) {
        return this.studentSessionRepository.findById(id).map( studentSession -> {
            studentSession.setStudentSessionStatus(studentSessionToUpdate.getStudentSessionStatus());
            return this.studentSessionRepository.save(studentSession);
        }).orElseThrow(() -> new EntityNotFoundException(id, EntityType.STUDENT_SESSION));
    }

    @Override
    public boolean deleteStudentSessionById(long id) {
        StudentSession studentSession = this.studentSessionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id, EntityType.STUDENT_SESSION));
        this.studentSessionRepository.delete(studentSession);
        return true;
    }

}
