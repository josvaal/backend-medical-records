package com.josval.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class BackendApplication {
  public static void main(String[] args) {
    Dotenv dotenv = Dotenv.load();

    System.setProperty("security.jwt.secret_key", dotenv.get("JWT_SECRET_KEY"));
    System.setProperty("security.jwt.expiration_time", dotenv.get("JWT_EXPRIATION_TIME"));
    System.setProperty("security.jwt.token_issuer", dotenv.get("JWT_TOKEN_ISSUER"));
    System.setProperty("frontend.origin", dotenv.get("FRONTEND_ORIGIN"));

    SpringApplication.run(BackendApplication.class, args);
  }
}
