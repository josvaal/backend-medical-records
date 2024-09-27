package com.josval.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class BackendApplication {
  public static void main(String[] args) {
    Dotenv dotenv = Dotenv.load();

    System.setProperty("server.port", dotenv.get("PORT"));
    System.setProperty("spring.datasource.username", dotenv.get("DB_USER"));
    System.setProperty("spring.datasource.password", dotenv.get("DB_PASSWORD"));
    System.setProperty("spring.datasource.url", dotenv.get("DB_URL"));
    System.setProperty("security.jwt.secret_key", dotenv.get("JWT_SECRET_KEY"));
    System.setProperty("security.jwt.expiration_time", dotenv.get("JWT_EXPRIATION_TIME"));
    System.setProperty("security.jwt.token_issuer", dotenv.get("JWT_TOKEN_ISSUER"));
    System.setProperty("frontend.origin", dotenv.get("FRONTEND_ORIGIN"));

    SpringApplication.run(BackendApplication.class, args);
  }
}
