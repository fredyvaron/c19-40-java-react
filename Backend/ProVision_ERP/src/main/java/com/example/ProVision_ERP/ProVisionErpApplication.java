package com.example.ProVision_ERP;

import io.github.cdimascio.dotenv.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProVisionErpApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();
        dotenv.get("DB_USERNAME");
		SpringApplication.run(ProVisionErpApplication.class, args);
	}

}
