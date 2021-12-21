//package com.example.demo.security.jwt;
//
//import javax.crypto.spec.SecretKeySpec;
//import javax.xml.bind.DatatypeConverter;
//import java.security.Key;
//
//import io.jsonwebtoken.*;
//
//import java.util.Date;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.Claims;
//
//public class Jwt {
//
//	// The secret key. This should be in a property file NOT under source
//	// control and not hard coded in real life. We're putting it here for
//	// simplicity.
//	private static String SECRET_KEY = "NhatDepTrai";
//	private static Long jwtDuration = 604800000L;
//
//	// Sample method to construct a JWT
//	public static String createJWT(String issuer, String subject, long ttlMillis) {
//
//		// The JWT signature algorithm we will be using to sign the token
//		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
//
//		long nowMillis = System.currentTimeMillis();
//		Date now = new Date(nowMillis);
//
//		// We will sign our JWT with our ApiKey secret
//		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
//		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
//
//		// Let's set the JWT Claims
//		JwtBuilder builder = Jwts.builder().setIssuedAt(now).setSubject(subject).setIssuer(issuer)
//				.signWith(signatureAlgorithm, signingKey);
//
//		// if it has been specified, let's add the expiration
//		if (ttlMillis >= 0) {
//			long expMillis = nowMillis + ttlMillis;
//			Date exp = new Date(expMillis);
//			builder.setExpiration(exp);
//		}
//
//		// Builds the JWT and serializes it to a compact, URL-safe string
//		return builder.compact();
//	}
//
//	public static Claims decodeJWT(String jwt) {
//
//		// This line will throw an exception if it is not a signed JWS (as expected)
//		Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY)).parseClaimsJws(jwt)
//				.getBody();
//		return claims;
//	}
//}
