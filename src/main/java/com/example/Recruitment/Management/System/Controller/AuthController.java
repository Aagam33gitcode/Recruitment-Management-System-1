package com.example.Recruitment.Management.System.Controller;

import com.example.Recruitment.Management.System.Dto.JwtResponse;
import com.example.Recruitment.Management.System.Dto.LoginRequest;
import com.example.Recruitment.Management.System.Dto.SignupRequest;
import com.example.Recruitment.Management.System.Services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest request) {
        return ResponseEntity.ok(authService.signup(request));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
}
