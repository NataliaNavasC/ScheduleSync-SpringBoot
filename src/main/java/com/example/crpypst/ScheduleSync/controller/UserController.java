package com.example.crpypst.ScheduleSync.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.crpypst.ScheduleSync.model.dto.UserDTO;
import com.example.crpypst.ScheduleSync.service.interfaces.IUserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;
    
    @GetMapping
    public List<UserDTO> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable long id){
        return this.userService.getUserById(id);
    }

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDto){
        return userService.createUser(userDto);
    }

    @DeleteMapping
    public boolean deleteUser(@RequestParam String username){
        return this.userService.deleteUserByUsername(username);
    }

    @GetMapping("/students")
    public List<UserDTO> getStudents(){
        return this.userService.getStudents();
    }

    
    // @PostMapping("/login")
    // public UserDTO login(@RequestBody UserDTO user){
    //     return this.userService.login(user);
    // }

}
