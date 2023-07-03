package com.example.crpypst.ScheduleSync.utils.exceptions.badcredentials;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class InvalidCredentialsHandler {
    
    @ResponseBody
    @ExceptionHandler(InvalidCredentialsException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    String invalidCredentialsHandler(InvalidCredentialsException ex){
        return ex.getMessage();
    }
     
}
