package com.josval.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {

		System.setProperty("server.port", System.getenv("PORT"));
		System.setProperty("spring.datasource.username", System.getenv("DB_USER"));
		System.setProperty("spring.datasource.password", System.getenv("DB_PASSWORD"));
		System.setProperty("spring.datasource.url", System.getenv("DB_URL"));

		SpringApplication.run(BackendApplication.class, args);
	}
}
