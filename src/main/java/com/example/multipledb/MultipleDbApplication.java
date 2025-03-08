package com.example.multipledb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MultipleDbApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
            return application.sources(MultipleDbApplication.class); // Replace DemoApplication with your main class
    }



	public static void main(String[] args) {
		SpringApplication.run(MultipleDbApplication.class, args);
	}
	
	

}
