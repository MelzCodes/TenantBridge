package com.tenantbridge.api.service;

import com.tenantbridge.api.common.ObjectsValidator;
import com.tenantbridge.api.common.responses.BaseApiResponse;
import com.tenantbridge.api.common.responses.GetDetailsResponse;
import com.tenantbridge.api.common.responses.ListAllObjectsResponse;
import com.tenantbridge.api.model.tenant.Tenant;
import com.tenantbridge.api.model.tenant.TenantDetails;
import com.tenantbridge.api.repository.tenant.TenantRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TenantService {

    private final TenantRepository tenantRepository;
    private final ObjectsValidator<Tenant> objectsValidator;

    public ResponseEntity<GetDetailsResponse<TenantDetails>> getTenantDetails(String id) {
        Tenant tenant = tenantRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No tenant found with ID: " + id));
        return ResponseEntity.ok(new GetDetailsResponse<>(true, tenant.getTenantDetails()));
    }

    public ResponseEntity<ListAllObjectsResponse<TenantDetails>> getAllTenants() {
        List<TenantDetails> tenantList = tenantRepository
                .findAll()
                .stream()
                .map(Tenant::getTenantDetails)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new ListAllObjectsResponse<>(true, tenantList));
    }

    public ResponseEntity<BaseApiResponse> deleteTenant(String id) {
        Tenant tenant = tenantRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No tenant found with ID: " + id));
        tenantRepository.delete(tenant);
        return ResponseEntity.ok(new BaseApiResponse(true, "Deleted successfully"));
    }

}
