package com.company.M4Summative;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins= "http://localhost:3000/")

public class M4SummativeApplication {

	public static void main(String[] args) {
		SpringApplication.run(M4SummativeApplication.class, args);
	}
}
