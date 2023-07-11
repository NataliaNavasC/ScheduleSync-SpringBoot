package com.example.crpypst.ScheduleSync.service.inplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crpypst.ScheduleSync.model.dto.UserDTO;
import com.example.crpypst.ScheduleSync.model.user.Admin;
import com.example.crpypst.ScheduleSync.model.user.Student;
import com.example.crpypst.ScheduleSync.model.user.Teacher;
import com.example.crpypst.ScheduleSync.model.user.User;
import com.example.crpypst.ScheduleSync.repository.IUserRepository;
import com.example.crpypst.ScheduleSync.service.interfaces.IUserService;
import com.example.crpypst.ScheduleSync.utils.enums.EntityType;
import com.example.crpypst.ScheduleSync.utils.enums.Role;
import com.example.crpypst.ScheduleSync.utils.exceptions.entitynotfound.EntityNotFoundException;
import com.example.crpypst.ScheduleSync.utils.general.DTOConverter;


@Service
public class UserService implements IUserService{

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private DTOConverter dtoConverter;

    @Override
    public List<UserDTO> getUsers() {
        return this.dtoConverter.convertListType(userRepository.findAll(), UserDTO.class);
    }

    @Override
    public UserDTO getUserById(long id){
        return dtoConverter.convertType(this.userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id, EntityType.USER)),UserDTO.class);
    }

    @Override
    public UserDTO getUserByUsername(String username){
        User user = this.userRepository.findByUsername(username).orElseThrow(()-> new EntityNotFoundException(username, EntityType.USER));
        UserDTO userDTO = dtoConverter.convertType(user,UserDTO.class);
        userDTO.setRole(Role.valueOf(user.getClass().getSimpleName().toUpperCase()));
        return userDTO;
    }

    @Override
    public UserDTO createUser(UserDTO userDto) {
        return switch(userDto.getRole()){
            case ADMIN -> dtoConverter.convertType(this.userRepository.save(dtoConverter.convertType(userDto,Admin.class)),UserDTO.class);
            case STUDENT -> dtoConverter.convertType(this.userRepository.save(dtoConverter.convertType(userDto, Student.class)),UserDTO.class);
            case TEACHER -> dtoConverter.convertType(this.userRepository.save(dtoConverter.convertType(userDto, Teacher.class)),UserDTO.class);
            default -> null;  
        };
        
    }

    @Override
    public boolean deleteUserByUsername(String username) {

        Optional<User> user = this.userRepository.findByUsername(username);
        if(user.isPresent()){
            user.get().setActive(false);
            this.userRepository.save(user.get());
            return true;
        }else{
            throw new EntityNotFoundException(username, EntityType.USER);
        }

    }
    
    @Override
    public List<UserDTO> getStudents() {
        return this.dtoConverter.convertListType(this.userRepository.findAllStudents(),UserDTO.class);
    }

    @Override
    public List<UserDTO> getTeachers() {
        return this.dtoConverter.convertListType(this.userRepository.findAllTeachers(), UserDTO.class);
    }

}
