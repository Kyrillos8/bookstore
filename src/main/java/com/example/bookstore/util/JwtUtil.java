package com.example.bookstore.util;
//
//import org.springframework.stereotype.Component;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.security.Keys;
//
//import javax.crypto.SecretKey;
//
//import java.util.Date;
//
//@Component
//public class JwtUtil {
////    private static final String SECRET_KEY = "secret";
//
//    private static final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
//
//    public static SecretKey getKey() {
//        return SECRET_KEY;
//    }
//    public String generateToken(String username) {
//        return Jwts.builder()
//                .setSubject(username)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
//                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
//                .compact();
//    }
//
//    public String extractUsername(String token) {
//        return Jwts.parser()
//                .setSigningKey(SECRET_KEY)
//                .parseClaimsJws(token)
//                .getBody()
//                .getSubject();
//    }
//
//    public boolean isTokenValid(String token, String username) {
//        return extractUsername(token).equals(username);
//    }
//
//public class JwtConfig {
//    private static final SecretKey SECRET_KEY = JwtUtil.getKey();
//
//    public String createToken(String subject) {
//        return Jwts.builder()
//                .setSubject(subject)
//                .signWith(SECRET_KEY, SignatureAlgorithm.HS256)
//                .compact();
//    }
//}
//}
