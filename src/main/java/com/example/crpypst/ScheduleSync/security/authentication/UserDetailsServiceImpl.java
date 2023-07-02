package com.example.crpypst.ScheduleSync.security.authentication;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.example.crpypst.ScheduleSync.model.user.Student;
import com.example.crpypst.ScheduleSync.model.user.User;
import com.example.crpypst.ScheduleSync.repository.IUserRepository;
import com.example.crpypst.ScheduleSync.utils.enums.EntityType;
import com.example.crpypst.ScheduleSync.utils.exceptions.entitynotfound.EntityNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    
    @Autowired
    private IUserRepository userRepository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username){
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAA");
        Student userFound = (Student)userRepository.findByUsername(username).orElseThrow(()-> new EntityNotFoundException(username,EntityType.USER));
        try {
            List<SimpleGrantedAuthority> roles = getAuthorities(userFound);
            return new org.springframework.security.core.userdetails.User
            (userFound.getUsername(), userFound.getPassword(), roles);
        }
        catch(Exception e){
            throw new EntityNotFoundException(username,EntityType.USER);
        }
    }

    private List<SimpleGrantedAuthority> getAuthorities(User user){
        List<SimpleGrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ROLE_"+user.getClass().getName().toUpperCase()));
        return roles;
    }
}
