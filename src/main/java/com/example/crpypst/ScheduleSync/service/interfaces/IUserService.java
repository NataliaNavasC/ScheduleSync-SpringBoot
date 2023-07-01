package com.example.crpypst.ScheduleSync.service.interfaces;

import java.util.List;

import com.example.crpypst.ScheduleSync.model.dto.UserDTO;

public interface IUserService {
    
    public List<UserDTO> getUsers();

    public UserDTO getUserById(long id);

    public UserDTO createUser(UserDTO userDto);

    public boolean deleteUserByUsername(String username);

    public List<UserDTO> getStudents();
    
    public List<UserDTO> getTeachers();

    // Temp login
    public UserDTO login(UserDTO userDTO);

}
