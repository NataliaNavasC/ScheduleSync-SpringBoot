package com.example.crpypst.ScheduleSync.utils.exceptions.invalidurl;

public class InvalidURLException extends RuntimeException{
    public InvalidURLException(String url){
        super("Invalid URL: " + url );
    }
}
