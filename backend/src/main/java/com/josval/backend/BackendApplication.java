package com.josval.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class BackendApplication {
  public static void main(String[] args) {
    Dotenv dotenv = Dotenv.load();

    System.setProperty("security.password", dotenv.get("SECURITY_PASSWORD"));
    System.setProperty("security.token", dotenv.get("SECURITY_TOKEN"));
    System.setProperty("security.token_validity", dotenv.get("SECURITY_TOKEN_VALIDITY"));

    SpringApplication.run(BackendApplication.class, args);
  }
}
