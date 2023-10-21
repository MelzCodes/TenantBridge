package com.tenantbridge.api.controllers.auth;

import com.tenantbridge.api.common.responses.AuthenticationResponse;
import com.tenantbridge.api.common.requests.LoginRequestBody;
import com.tenantbridge.api.common.requests.RegistrationRequestBody;
import com.tenantbridge.api.service.auth.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/auth")
public class RegistrationController {

    private RegistrationService registrationService;

    @PostMapping()
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody LoginRequestBody requestBody){
        return registrationService.authenticate(requestBody);
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegistrationRequestBody requestBody){
        return registrationService.register(requestBody);
    }
}
