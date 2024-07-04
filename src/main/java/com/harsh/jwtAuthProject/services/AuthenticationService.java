package com.harsh.jwtAuthProject.services;

import com.harsh.jwtAuthProject.dtos.requests.LoginUserDto;
import com.harsh.jwtAuthProject.dtos.requests.RegisterUserDto;
import com.harsh.jwtAuthProject.entities.User;
import com.harsh.jwtAuthProject.repositories.UserRespository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserRespository userRespository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRespository userRespository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRespository = userRespository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public User signup(RegisterUserDto input) {
        User user = User.builder()
                .firstName(input.getFirstName())
                .lastName(input.getLastName())
                .email(input.getEmail())
                .password(passwordEncoder.encode(input.getPassword()))
                .build();

        return userRespository.save(user);
    }

    public User authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return userRespository.findByEmail(input.getEmail())
                .orElseThrow();
    }

}
