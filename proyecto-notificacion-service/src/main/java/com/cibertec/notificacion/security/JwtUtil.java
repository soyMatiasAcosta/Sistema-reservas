package com.cibertec.notificacion.security;

import java.nio.charset.StandardCharsets;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;

@Component
public class JwtUtil {

	@Value("${jwt.secret:Ni2vMl6cc6Zop38ghg73vEp5rorkz4RhXQIqTiJQOvY}")
	private String llave;
	
	private SecretKey key;

	@PostConstruct
	public void init() {
		this.key = Keys.hmacShaKeyFor(llave.getBytes(StandardCharsets.UTF_8));
	}

	public Claims getClaims(String token) {
		return Jwts.parserBuilder()
				.setSigningKey(key).build()
				.parseClaimsJws(token).getBody();
	}

	public boolean validateToken(String token, String username) {
		try {
			return getClaims(token).getSubject().equals(username);
		} catch (JwtException | IllegalArgumentException e) {
			return false;
		}
	}
}