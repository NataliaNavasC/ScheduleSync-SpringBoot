package com.example.crpypst.ScheduleSync.model.user;

import jakarta.persistence.Entity;

@Entity
public class Teacher extends User{

    public Teacher(){
    }

    public Teacher(long id, String username, String password, boolean isActive) {
        super(id, username, password, isActive);
    }

}
