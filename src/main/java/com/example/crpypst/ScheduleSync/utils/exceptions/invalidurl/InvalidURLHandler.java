package com.example.crpypst.ScheduleSync.utils.exceptions.invalidurl;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class InvalidURLHandler {
    
    @ResponseBody
    @ExceptionHandler(InvalidURLException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String invalidURLHandler(InvalidURLException ex){
        return ex.getMessage();
    }
    
}
