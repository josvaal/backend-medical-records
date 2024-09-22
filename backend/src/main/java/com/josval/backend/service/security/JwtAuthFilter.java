package com.josval.backend.service.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class JwtAuthFilter extends OncePerRequestFilter {
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private UserAuthService userAuthService;

	@Override
	protected void doFilterInternal(
			HttpServletRequest request, HttpServletResponse response, FilterChain filterChain
	)
			throws ServletException, IOException {
		
		try {
            String bearerToken = request.getHeader("Authorization");
            if(bearerToken == null || !bearerToken.startsWith("Bearer ")) {
            	throw new Exception("Authorization Bearer not found");
            }
            
            String jwt = bearerToken.substring(7);
            Claims claims = jwtService.getTokenClaims(jwt);
            
            if(claims == null) {
            	throw new Exception("Token not valid");
            }
            
            String email = claims.getSubject();
            UserDetails userDetails = userAuthService.loadUserByUsername(email);
            
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
            		userDetails, null, null
    		);
            SecurityContextHolder.getContext().setAuthentication(authentication);
			
		} catch (Exception e) {
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			response.setContentType("application/json");
			
			Map<String, String> responseMap = new HashMap<String, String>();
			responseMap.put("message", e.getMessage());
			responseMap.put("object", null);
			
			ObjectMapper objectMapper = new ObjectMapper();
            String jsonResponse = objectMapper.writeValueAsString(responseMap);
			
			response.getWriter().write(jsonResponse);

			return;
		}
		
		filterChain.doFilter(request, response);
	}

}
