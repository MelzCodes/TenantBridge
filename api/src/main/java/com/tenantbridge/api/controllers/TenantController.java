package com.tenantbridge.api.controllers;

import com.tenantbridge.api.common.requests.RegistrationRequestBody;
import com.tenantbridge.api.common.responses.AuthenticationResponse;
import com.tenantbridge.api.common.responses.BaseApiResponse;
import com.tenantbridge.api.service.TenantService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tenant")
public class TenantController {

    private final TenantService tenantService;

    @GetMapping
    public ResponseEntity<BaseApiResponse> getTenantDetails(){
        return tenantService.getTenantDetails();
    }
}
