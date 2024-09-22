package com.josval.backend.controller;

import com.josval.backend.model.dto.RegisterDTO;
import com.josval.backend.model.dto.UserDTO;
import com.josval.backend.model.entity.User;
import com.josval.backend.model.payload.MessageResponse;
import com.josval.backend.service.IUserService;
import com.josval.backend.service.JwtService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class AuthController {
	@Autowired
	private IUserService userService;

	@Autowired
	private JwtService jwtService;
	
	@PostMapping("auth/register")
	public ResponseEntity<?> register(
			@Valid @RequestBody RegisterDTO registerDTO,
			BindingResult result
	) {

		if (result.hasErrors()) {
            Map<String, String> errorsMap = new HashMap<>();
            for (ObjectError error : result.getAllErrors()) {
                FieldError fieldError = (FieldError) error;
                errorsMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return ResponseEntity.badRequest()
                    .body(MessageResponse.builder()
                    		.message("Validation error")
                    		.object(errorsMap)
                    		.build()
                		);
        }

		try {
			
			if (userService.findByEmail(registerDTO.getEmail()) != null) {
				return ResponseEntity.badRequest()
                        .body(MessageResponse.builder()
                                .message("Email address already used")
                                .object(null)
                                .build());
			}
			
			BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
			
			UserDTO user = UserDTO.builder()
					.firstname(registerDTO.getFirstname())
					.lastname(registerDTO.getLastname())
					.email(registerDTO.getEmail())
					.password(bCryptEncoder.encode(registerDTO.getPassword()))
					.userRole(registerDTO.getUserRole())
					.dateOfBirth(registerDTO.getDateOfBirth())
					.phone(registerDTO.getPhone())
					.address(registerDTO.getAddress())
					.build();
			
			String jwtToken = jwtService.createJwtToken(user);
			
			Map<String, Object> response = new HashMap<String, Object>();
			response.put("token", jwtToken);
			response.put("user", user);
			

			userService.save(user);
			
			return ResponseEntity.ok(
                    MessageResponse.builder()
                            .message("Register successfully")
                            .object(response)
                            .build());
			
		} catch (Exception e) {
			System.out.println("There is an exception: ");
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(MessageResponse.builder()
                    		.message(e.getMessage())
                    		.object(null).build());
		}
	}
	
}
