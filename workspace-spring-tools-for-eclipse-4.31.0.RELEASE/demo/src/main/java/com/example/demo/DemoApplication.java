package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {
public static int visitas=0;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
	}
	
	@GetMapping("/holaMundo")
	public String holaMundo() {
		visitas++;
		return "<b>Hola mundo cruel </b>" + visitas;
	}

}
