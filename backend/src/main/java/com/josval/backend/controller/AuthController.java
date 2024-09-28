package com.josval.backend.controller;

import com.josval.backend.controller.mapper.UserMapper;
import com.josval.backend.model.dto.LoginDTO;
import com.josval.backend.model.dto.RegisterDTO;
import com.josval.backend.model.dto.UserDTO;
import com.josval.backend.model.entity.User;
import com.josval.backend.model.payload.MessageResponse;
import com.josval.backend.service.IUserService;
import com.josval.backend.service.security.JwtService;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class AuthController {
	@Autowired
	private IUserService userService;

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private BCryptPasswordEncoder bCryptEncoder;
	
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
            return new ResponseEntity<>(MessageResponse.builder()
            		.message("Validation Error")
            		.object(errorsMap)
            		.build(),
            		HttpStatus.BAD_REQUEST);
        }

		try {
			
			if (userService.findByEmail(registerDTO.getEmail()) != null) {
				return new ResponseEntity<>(MessageResponse.builder()
						.message("Email address aready used")
						.object(null)
						.build(),
						HttpStatus.BAD_REQUEST);
			}
			
			
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
			
			return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("Register successfully")
                            .object(response)
                            .build(),
                            HttpStatus.OK);
			
		} catch (Exception e) {
			System.out.println("There is an exception: ");
			e.printStackTrace();
			return new ResponseEntity<>(MessageResponse.builder()
                    		.message(e.getMessage())
                    		.object(null)
                    		.build(),
                    		HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("auth/login")
	public ResponseEntity<?> login(
			@Valid @RequestBody LoginDTO loginDto,
			BindingResult result
	) {
		
		
		if (result.hasErrors()) {
            Map<String, String> errorsMap = new HashMap<>();
            for (ObjectError error : result.getAllErrors()) {
                FieldError fieldError = (FieldError) error;
                errorsMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return new ResponseEntity<>(MessageResponse.builder()
            		.message("Validation Error")
            		.object(errorsMap)
            		.build(),
            		HttpStatus.BAD_REQUEST);
        }
		
		try {			
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							loginDto.getEmail(),
							loginDto.getPassword()
					)
			);
			
			User user = userService.findByEmail(loginDto.getEmail());
			String jwtToken = jwtService.createJwtToken(userMapper.toUserDTO(user));
			
			Map<String, Object> response = new HashMap<String, Object>();
			response.put("token", jwtToken);
			response.put("user", userMapper.toUserDTO(user));
			
			
			return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("Login successfully")
                            .object(response)
                            .build(),
                            HttpStatus.OK);
			
		} catch (Exception e) {
			System.out.println("There is an exception: ");
			e.printStackTrace();
			return new ResponseEntity<>(MessageResponse.builder()
                    		.message(e.getMessage())
                    		.object(null)
                    		.build(),
                    		HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/auth/profile")
	public ResponseEntity<?> profile(
			HttpServletRequest request
	){
		try {
			
			String bearerToken = request.getHeader("Authorization");
	        if (bearerToken == null || !bearerToken.startsWith("Bearer ")) {
	            return new ResponseEntity<>(MessageResponse.builder()
	                    .message("Authorization Bearer token not found")
	                    .object(null)
	                    .build(),
	                    HttpStatus.UNAUTHORIZED);
	        }
	        
	        String token = bearerToken.substring(7);
	        
	        Claims claims = jwtService.getTokenClaims(token);
	        if (claims == null) {
	            return new ResponseEntity<>(MessageResponse.builder()
	                    .message("Invalid Token")
	                    .object(null)
	                    .build(),
	                    HttpStatus.UNAUTHORIZED);
	        }
	        
	        String email = claims.getSubject();
	        
	        UserDTO user = userMapper.toUserDTO(userService.findByEmail(email));
	        user.setPassword(null);
	        
	        return new ResponseEntity<>(MessageResponse.builder()
	                .message("Profile retrieved successfully")
	                .object(user)
	                .build(),
	                HttpStatus.OK);
	        
		} catch (Exception e) {
			return new ResponseEntity<>(MessageResponse.builder()
	                .message(e.getMessage())
	                .object(null)
	                .build(),
	                HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/auth/verifyLogin")
	public ResponseEntity<?> verifyLogin(HttpServletRequest request) {
	    try {
	        String bearerToken = request.getHeader("Authorization");
	        if (bearerToken == null || !bearerToken.startsWith("Bearer ")) {
	            return new ResponseEntity<>(MessageResponse.builder()
	                    .message("Authorization Bearer token not found")
	                    .object(null)
	                    .build(),
	                    HttpStatus.UNAUTHORIZED);
	        }

	        String token = bearerToken.substring(7);

	        Claims claims = jwtService.getTokenClaims(token);
	        if (claims == null) {
	            return new ResponseEntity<>(MessageResponse.builder()
	                    .message("Invalid Token")
	                    .object(null)
	                    .build(),
	                    HttpStatus.UNAUTHORIZED);
	        }

	        String email = claims.getSubject();

	        UserDTO user = userMapper.toUserDTO(userService.findByEmail(email));
	        user.setPassword(null);

	        return new ResponseEntity<>(MessageResponse.builder()
	                .message("Token is valid. User authenticated successfully.")
	                .object(user)
	                .build(),
	                HttpStatus.OK);

	    } catch (Exception e) {
	        return new ResponseEntity<>(MessageResponse.builder()
	                .message(e.getMessage())
	                .object(null)
	                .build(),
	                HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

}
