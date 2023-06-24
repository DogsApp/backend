package com.doggo.userservice.config.JWT;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.time.*;

@AllArgsConstructor
@Service
@Log4j2
public class JwtAuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final Clock clock;
    private final String issuer;
    private final String secretKey;
    private final Long expirationDays;

    public JwtResponseDto authenticateAndGenerateToken(JwtAuthenticationRequest loginRequest) {
        log.debug("Authenticating user with username={}", loginRequest.getUsername());
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        User user = (User) authenticate.getPrincipal();
        log.debug("User authenticated successfully, username={}", user.getUsername());
        String token = createToken(user);
        String username = user.getUsername();
        log.debug("Generated JWT token successfully for user with username={}", username);
        return JwtResponseDto.builder()
                .token(token)
                .username(username)
                .build();
    }

    private String createToken(User user) {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        Instant now = LocalDateTime.now(clock).toInstant(ZoneOffset.UTC);
        Instant expiresAt = now.plus(Duration.ofDays(expirationDays));
        log.debug("Creating JWT token for user with username={}", user.getUsername());
        return JWT.create()
                .withSubject(user.getUsername())
                .withIssuedAt(now)
                .withExpiresAt(expiresAt)
                .withIssuer(issuer)
                .sign(algorithm);
    }

}