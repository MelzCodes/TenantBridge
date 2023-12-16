package com.tenantbridge.api.service;

import com.tenantbridge.api.common.requests.UpdateTenantRequestBody;
import com.tenantbridge.api.common.responses.BaseApiResponse;
import com.tenantbridge.api.common.responses.GetDetailsResponse;
import com.tenantbridge.api.common.responses.ListAllObjectsResponse;
import com.tenantbridge.api.model.tenant.Tenant;
import com.tenantbridge.api.model.tenant.TenantDetails;
import com.tenantbridge.api.repository.tenant.TenantRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TenantService {

    private final TenantRepository tenantRepository;

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

    public ResponseEntity<BaseApiResponse> createTenant(Tenant tenant) {
        tenantRepository.save(tenant);
        return new ResponseEntity<>(new BaseApiResponse(true, String.format("TenantId: %s", tenant.getId())), HttpStatus.CREATED);
    }

    public ResponseEntity<BaseApiResponse> updateTenantDetails(UpdateTenantRequestBody updateRequest) {
        String tenantId = updateRequest.tenantId();
        Tenant tenant = tenantRepository.findById(tenantId).orElseThrow(() -> new EntityNotFoundException("No tenant found with ID: " + tenantId));

        TenantDetails tenantDetails = new TenantDetails();
        tenantDetails.setDateOfBirth(updateRequest.tenantDetails().getDateOfBirth());
        tenantDetails.setTenant(tenant);
        tenantDetails.setCurrentAddress(updateRequest.tenantDetails().getCurrentAddress());

        tenant.setTenantDetails(tenantDetails);
        tenantRepository.save(tenant);

        return ResponseEntity.ok(new BaseApiResponse(true, String.format("Updated Tenant: %s", updateRequest.tenantId())));
    }

    public ResponseEntity<BaseApiResponse> deleteTenant(String id) {
        Tenant tenant = tenantRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No tenant found with ID: " + id));
        tenantRepository.delete(tenant);
        return ResponseEntity.ok(new BaseApiResponse(true, "Deleted successfully"));
    }
}
