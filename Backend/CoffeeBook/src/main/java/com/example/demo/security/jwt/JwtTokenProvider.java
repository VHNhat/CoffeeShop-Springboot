package com.example.demo.security.jwt;

import java.util.Date;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtTokenProvider {

	// Đoạn JWT_SECRET này là bí mật, chỉ có phía server biết
	private final String JWT_SECRET = "NhatVoDepTrai";

	// Thời gian có hiệu lực của chuỗi jwt
	private final long JWT_EXPIRATION = 604800000L;

	// Tạo ra jwt từ thông tin user
//	public String generateToken(CustomerUserDetails customerUserDetails) {
//		Date now = new Date();
//		Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);
//		// Tạo chuỗi json web token từ id của user.
//		return Jwts.builder()
//					.setSubject(Long.toString(customerUserDetails.getCustomer().getId()))
//					.setIssuedAt(now)
//					.setExpiration(expiryDate).
//					signWith(SignatureAlgorithm.HS512, JWT_SECRET)
//					.compact();
//	}
	public String generateToken(String subject, String id, String username,String email) {
		try {
			Date now = new Date();
			Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);
			// Tạo chuỗi json web token từ id của user.
			return Jwts.builder()
						.setSubject(subject)
						.claim("Id", id)
						.claim("Username", username)
						.claim("Email", email)
						.setIssuedAt(now)
						.setExpiration(expiryDate).
						signWith(SignatureAlgorithm.HS256, JWT_SECRET)
						.compact();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
			return "";
		}
		
	}
	
	public String generateTokenAdmin(String subject, String id, String username,Long roleId) {
		try {
			Date now = new Date();
			Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);
			// Tạo chuỗi json web token từ id của user.
			return Jwts.builder()
						.setSubject(subject)
						.claim("Id", id)
						.claim("Username", username)
						.claim("RoleId", roleId)
						.setIssuedAt(now)
						.setExpiration(expiryDate).
						signWith(SignatureAlgorithm.HS256, JWT_SECRET)
						.compact();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
			return "";
		}
		
	}

	// Lấy thông tin user từ jwt
	public Long getUserIdFromJWT(String token) {
		Claims claims = Jwts.parser()
				.setSigningKey(JWT_SECRET)
				.parseClaimsJws(token)
				.getBody();

		return Long.parseLong(claims.getSubject());
	}

	public boolean validateToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
			return true;
		} catch (MalformedJwtException ex) {
			System.out.println("Invalid JWT token");
		} catch (ExpiredJwtException ex) {
			System.out.println("Expired JWT token");
		} catch (UnsupportedJwtException ex) {
			System.out.println("Unsupported JWT token");
		} catch (IllegalArgumentException ex) {
			System.out.println("JWT claims string is empty.");
		}
		return false;
	}
}
