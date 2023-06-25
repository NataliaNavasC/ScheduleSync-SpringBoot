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
        return this.dtoConverter.convertType(this.userRepository.findById(id), UserDTO.class);
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
        }
        return false;

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
