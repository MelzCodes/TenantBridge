package com.tenantbridge.api.controllers.auth;

import com.tenantbridge.api.common.ApiResponse;
import com.tenantbridge.api.common.RegistrationRequestBody;
import com.tenantbridge.api.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/register")
public class RegistrationController {

    private RegistrationService registrationService;

    @PostMapping
    public ResponseEntity<ApiResponse> register(@RequestBody RegistrationRequestBody requestBody){
        return registrationService.register(requestBody);
    }
}
