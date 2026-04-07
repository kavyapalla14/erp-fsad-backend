package com.example.erp.controller;

import com.example.erp.dto.AuthResponse;
import com.example.erp.dto.LoginRequest;
import com.example.erp.dto.RegisterRequest;
import com.example.erp.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest req) {
        return authService.register(req);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest req) {
        return authService.login(req);
    }

    @PostMapping("/logout")
    public AuthResponse logout() {
        return new AuthResponse(null, null, null, "Logged out");
    }
}
