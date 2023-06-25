package com.example.crpypst.ScheduleSync.model.user;

import jakarta.persistence.Entity;

@Entity
public class Admin extends User{
    
    public Admin(){
    }

    public Admin(long id, String username, String password, boolean isActive) {
        super(id, username, password, isActive);
    }

}
