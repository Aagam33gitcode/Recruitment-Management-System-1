package com.example.Recruitment.Management.System.Services;

import com.example.Recruitment.Management.System.Dto.JwtResponse;
import com.example.Recruitment.Management.System.Dto.LoginRequest;
import com.example.Recruitment.Management.System.Dto.SignupRequest;
import com.example.Recruitment.Management.System.Entity.UserEntity;
import com.example.Recruitment.Management.System.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final ModelMapper modelMapper;

    public String signup(SignupRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already registered!");
        }

        UserEntity user = modelMapper.map(request, UserEntity.class);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);
        return "User registered successfully!";
    }

    public JwtResponse login(LoginRequest request) {
        UserEntity user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        String token = jwtTokenProvider.generateToken(user);
        return new JwtResponse(token, user.getEmail(), user.getUserType().name());
    }
}
