package com.lights.users.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lights.users.exception.JWTValidationException;
import com.lights.users.model.UserToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UsersTokenService {

    private final ObjectMapper objectMapper = new ObjectMapper();
    public UserToken verifyToken(String token) {
        try {
            Claims claimsJws = Jwts.parser()
                    .setSigningKey("key".getBytes())
                    .parseClaimsJws(token)
                    .getBody();
            UserToken userToken = objectMapper.readValue(claimsJws.getSubject(), UserToken.class);
            return userToken;
        } catch (Exception e) {
            log.error("event=verifyToken ERROR={}", e.getMessage());
            throw new JWTValidationException("Invalid Token");
        }
    }
}
