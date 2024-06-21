package com.fernando.fernando_app_planejador_financas.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fernando.fernando_app_planejador_financas.config.JwtService;
import com.fernando.fernando_app_planejador_financas.user.Role;
import com.fernando.fernando_app_planejador_financas.user.User;
import com.fernando.fernando_app_planejador_financas.user.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        user.setRole(Role.ADMIN);
        userRepository.save(user);
        return AuthenticationResponse
                .builder()
                .token(jwtService.generateToken(user))
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticateRequest request) {
        authManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        return AuthenticationResponse
                .builder()
                .token(jwtService.generateToken(user))
                .build();
    }
}
