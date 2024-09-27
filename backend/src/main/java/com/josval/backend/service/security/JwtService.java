package com.josval.backend.service.security;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.josval.backend.model.dto.UserDTO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	@Value("${JWT_SECRET_KEY}")
	private String secretKey;
	
	@Value("${JWT_EXPRIATION_TIME}")
	private Long expirationTime;
	
	@Value("${JWT_TOKEN_ISSUER}")
	private String issuer;
	
	public String createJwtToken(UserDTO userDTO) {
		SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
		return Jwts.builder()
				.subject(userDTO.getEmail())
				.issuedAt(new Date(System.currentTimeMillis()))
				.issuer(issuer)
				.expiration(new Date(System.currentTimeMillis() + expirationTime))
				.signWith(key)
				.compact();
	}
	
	public Claims getTokenClaims(String token) {
		SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
		try {
			Claims claims = Jwts.parser()
					.verifyWith(key)
					.build()
					.parseSignedClaims(token)
					.getPayload();
			
			Date expDate = claims.getExpiration();
			Date currentDate = new Date();
			if(currentDate.before(expDate)) {
				return claims;
			}
		} catch (Exception e) {
		}
		
		return null;
	}
}
