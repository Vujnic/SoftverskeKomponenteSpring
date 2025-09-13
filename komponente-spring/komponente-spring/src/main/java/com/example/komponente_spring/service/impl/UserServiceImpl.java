package com.example.komponente_spring.service.impl;

import com.example.komponente_spring.domain.Employee;
import com.example.komponente_spring.dto.LoginDto;
import com.example.komponente_spring.repository.PersonRepository;
import com.example.komponente_spring.security.service.TokenService;
import com.example.komponente_spring.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private PersonRepository personRepository;
    private TokenService tokenService;
    @Override
    public String login(LoginDto loginDto) {
        Employee employee = personRepository.findByUsernameAndPassword(loginDto.getUsername(), loginDto.getPassword()).orElse(null);
        if(employee != null){
            Claims claims = Jwts.claims();
            claims.put("role", employee.getRole());
            claims.put("username", employee.getUsername());
            claims.put("id", employee.getId());
            return tokenService.generate(claims);
        }
        return "User does not exist";
    }
}
