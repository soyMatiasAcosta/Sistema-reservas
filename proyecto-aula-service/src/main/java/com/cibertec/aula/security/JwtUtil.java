package com.cibertec.aula.security;

import java.nio.charset.StandardCharsets;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;

@Component
public class JwtUtil {

	private static final String SECRET_STRING = "clave_secreta_para_probar_token_en_json";
	private SecretKey key;

	@PostConstruct
	public void init() {
		this.key = Keys.hmacShaKeyFor(SECRET_STRING.getBytes(StandardCharsets.UTF_8));
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