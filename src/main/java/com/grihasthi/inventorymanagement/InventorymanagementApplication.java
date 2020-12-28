package com.grihasthi.inventorymanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class InventorymanagementApplication {

	@RequestMapping("/")
	public static void main(String[] args) {
		SpringApplication.run(InventorymanagementApplication.class, args);
		
		System.out.println("Hello world!");
	}

}
