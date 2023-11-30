package com.tenantbridge.api.controllers;

import com.tenantbridge.api.common.requests.LoginRequestBody;
import com.tenantbridge.api.common.requests.RegistrationRequestBody;
import com.tenantbridge.api.common.responses.AuthenticationResponse;
import com.tenantbridge.api.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegistrationRequestBody requestBody){
        return authService.register(requestBody);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequestBody loginRequestBody){
        return authService.login(loginRequestBody);
    }
}
