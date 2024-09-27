package com.josval.backend.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import com.josval.backend.service.security.JwtAuthFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private JwtAuthFilter filter;
	
	@Value("${FRONTEND_ORIGIN}")
	private String origin;
	
	@Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
	
	@Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
        	.cors(cors -> cors.configurationSource(request -> {
        		CorsConfiguration config = new CorsConfiguration();
                config.setAllowedOrigins(Arrays.asList(origin));
                config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
                config.setAllowedHeaders(Arrays.asList("*"));
                config.setAllowCredentials(true);
                return config;
        	}))
            .authorizeHttpRequests((requests) -> requests
                .requestMatchers("/api/v1/auth/**").permitAll()
                .requestMatchers("/swagger-ui/**").permitAll()
                .requestMatchers("/swagger-ui-custom.html").permitAll()
                .requestMatchers("/v3/api-docs/**").permitAll()
                .anyRequest().authenticated()
                
            )
            .csrf(csrf -> csrf.disable())
			.httpBasic(basic -> basic.disable())
			.sessionManagement(session -> session.sessionCreationPolicy(
					SessionCreationPolicy.STATELESS))
			.addFilterBefore(filter,
					UsernamePasswordAuthenticationFilter.class)
			.build();
    }
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
