package com.tenantbridge.api.controllers;

import com.tenantbridge.api.common.requests.UpdateTenantRequestBody;
import com.tenantbridge.api.common.responses.BaseApiResponse;
import com.tenantbridge.api.common.responses.GetDetailsResponse;
import com.tenantbridge.api.common.responses.ListAllObjectsResponse;
import com.tenantbridge.api.common.validator.ValidateParameters;
import com.tenantbridge.api.model.tenant.Tenant;
import com.tenantbridge.api.model.tenant.TenantDetails;
import com.tenantbridge.api.service.TenantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tenant")
public class TenantController {

    private final TenantService tenantService;

    @GetMapping
    public ResponseEntity<ListAllObjectsResponse<TenantDetails>> getAllTenants(){
        return tenantService.getAllTenants();
    }

    @PostMapping
    @ValidateParameters
    public ResponseEntity<BaseApiResponse> createTenant(@RequestBody Tenant tenant){
        return tenantService.createTenant(tenant);
    }

    @PutMapping
    @ValidateParameters
    public ResponseEntity<BaseApiResponse> editTenant(@RequestBody UpdateTenantRequestBody tenantRequestBody){
        return tenantService.updateTenantDetails(tenantRequestBody);
    }

    @GetMapping("/{tenantId}")
    public ResponseEntity<GetDetailsResponse<TenantDetails>> getTenantDetails(@PathVariable String tenantId){
        return tenantService.getTenantDetails(tenantId);
    }

    @DeleteMapping("/{tenantId}")
    public ResponseEntity<BaseApiResponse> deleteTenant(@PathVariable String tenantId){
        return tenantService.deleteTenant(tenantId);
    }
    //associate with a tenancy, remove from a tenancy, associate existing user, handle non user
}
