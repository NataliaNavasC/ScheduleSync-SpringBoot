package com.example.crpypst.ScheduleSync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ScheduleSyncApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(ScheduleSyncApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(ScheduleSyncApplication.class);
	}

}
