package com.example.crpypst.ScheduleSync.utils.general;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DTOConverter {

    @Autowired
    private ModelMapper modelMApper;

    public <FROM, TO>TO convertType(FROM from, Class<TO> toClass){
        return modelMApper.map(from,toClass);
    }

    public <FROM, TO>List<TO> convertListType(List<FROM> entities, Class<TO> dtoClass){
        return entities.stream().map(entity -> convertType(entity, dtoClass)).collect(Collectors.toList());
    }
    
}


