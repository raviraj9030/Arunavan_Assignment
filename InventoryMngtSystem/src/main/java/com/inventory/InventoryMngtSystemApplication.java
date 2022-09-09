package com.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("com.inventory")
public class InventoryMngtSystemApplication{

	public static void main(String[] args) {
		
		SpringApplication.run(InventoryMngtSystemApplication.class, args);
		
	}

	

}
