package com.samsung.service;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import com.samsung.entity.User;
import com.samsung.models.UserDTO;
import com.samsung.repository.UserRepo;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TokeServiceImpl implements TokenService
{
	@Value("${jwt.token.secret}")
	private String secret;
	private final UserRepo userRepo;

	@Override
	public String generateToken(User user) {
		Instant expirationTime = Instant.now().plus(1, ChronoUnit.DAYS);
        Date expirationDate = Date.from(expirationTime);

        Key key = Keys.hmacShaKeyFor(secret.getBytes());

        String compactTokenString = Jwts.builder()
                .claim("id", user.getId())
                .claim("sub", user.getUsername())
                .claim("admin", false)
                .setExpiration(expirationDate)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        return "Bearer " + compactTokenString;
	}

	@Override
	public UserDTO parseToken(String token) {
		byte[] secretBytes = secret.getBytes();

        Jws<Claims> jwsClaims = Jwts.parserBuilder()
                .setSigningKey(secretBytes)
                .build()
                .parseClaimsJws(token);

        String username = jwsClaims.getBody()
                .getSubject();
        Integer userId = jwsClaims.getBody()
                .get("id", Integer.class);
        boolean isAdmin = jwsClaims.getBody().get("admin", Boolean.class);

        return new UserDTO(new Long(userId), username, isAdmin);
	}

}
