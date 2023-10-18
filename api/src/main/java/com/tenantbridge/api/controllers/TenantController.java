package com.tenantbridge.api.controllers;

import com.tenantbridge.api.service.TenantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/tenant")
public class TenantController {

    private TenantService tenantService;
}
