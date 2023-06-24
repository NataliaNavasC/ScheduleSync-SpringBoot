package com.example.crpypst.ScheduleSync.utils.general;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DTOConverter<DTO, ENTITY> {

    @Autowired
    private ModelMapper modelMApper;

    public DTO entityToDTO(ENTITY entity, Class<DTO> dtoClass){
        return modelMApper.map(entity,dtoClass);
    }

    public ENTITY dtoToEntity(DTO dto, Class<ENTITY> entityClass){
        return modelMApper.map(dto,entityClass);
    }

    public List<DTO> convertEntitiesToDTOs(List<ENTITY> entities, Class<DTO> dtoClass){
        return entities.stream().map(entity -> entityToDTO(entity, dtoClass)).collect(Collectors.toList());
    }

    public List<ENTITY> convertDTOSToEntities(List<DTO> dtos, Class<ENTITY> entityClass){
        return dtos.stream().map(dto -> dtoToEntity(dto, entityClass)).collect(Collectors.toList());
    }
    
}


