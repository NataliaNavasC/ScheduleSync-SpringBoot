package com.example.crpypst.ScheduleSync.utils.exceptions.entitynotfound;

import com.example.crpypst.ScheduleSync.utils.enums.EntityType;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(Long id, EntityType entityType){
        super(entityType.name() + " with id " + id + " could not be found.");
    }
    public EntityNotFoundException(String attribute, EntityType entityType){
        super(entityType.name() + " " + attribute + " could not be found.");
    }
}
