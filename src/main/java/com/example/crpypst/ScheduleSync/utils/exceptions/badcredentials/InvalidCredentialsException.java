package com.example.crpypst.ScheduleSync.utils.exceptions.badcredentials;

public class InvalidCredentialsException extends RuntimeException{
    public InvalidCredentialsException(){
        super("Invalid credentials");
    }
}
