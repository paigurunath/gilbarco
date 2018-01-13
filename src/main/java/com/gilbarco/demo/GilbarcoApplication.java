package com.gilbarco.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.gilbarco.controller"})
public class GilbarcoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GilbarcoApplication.class, args);
	}
}
