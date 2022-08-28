package com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootCrudApplication {

	public static void main(String[] args) {
		
		System.out.println("We are in main class");
		SpringApplication.run(SpringBootCrudApplication.class, args);
	}

}
