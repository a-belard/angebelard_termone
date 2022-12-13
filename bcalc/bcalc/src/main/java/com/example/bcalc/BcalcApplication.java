package com.example.bcalc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
@RestController
public class BcalcApplication {

	public static void main(String[] args) {
		SpringApplication.run(BcalcApplication.class, args);
	}

	@GetMapping("/")
	public String helloWorld(){
		return "Hello world";
	}

}
