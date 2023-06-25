package com.example.crpypst.ScheduleSync.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.crpypst.ScheduleSync.model.user.Student;
import com.example.crpypst.ScheduleSync.model.user.User;

public interface IUserRepository extends JpaRepository<User,Long>{
    
    @Query("SELECT s FROM Student AS s")
    public List<Student> findAllStudents();

    @Query("SELECT s FROM Teacher AS s")
    public List<Student> findAllTeachers();

    public Optional<User> findByUsername(String username);

}
