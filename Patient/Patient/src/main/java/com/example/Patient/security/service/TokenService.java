package com.example.Patient.security.service;

import io.jsonwebtoken.Claims;

public interface TokenService {

    String generate(Claims claims);

    Claims parseToken(String jwt);
    Long getUserIdFromToken(String jwt);
}
