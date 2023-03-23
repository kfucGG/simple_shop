package ru.internet_shop.authenticationservice.util;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.Date;

@Component
public class JwtUtil {

    private final String secret = "SECRET_KEY";

    public static String generateToken(String username){
        Date expiresAt = Date.from(ZonedDateTime.now().plusMinutes(60).toInstant());
        return JWT.create()
                .withSubject("User details")
                .withClaim("username", username)
                .withIssuer("auth-service")
                .withIssuedAt(new Date())
                .withExpiresAt(expiresAt)
                .sign(Algorithm.HMAC256("SECRET"));
    }

    private static JWTVerifier validateToken() {
        return JWT.require(Algorithm.HMAC256("SECRET"))
                .withSubject("User details")
                .withIssuer("auth-service")
                .build();
    }
    public static String getUsernameClaimFromToken(String token) {
        return validateToken().verify(token).getClaim("username").asString();
    }
}
