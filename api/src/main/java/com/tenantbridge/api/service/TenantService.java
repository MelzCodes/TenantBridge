package com.tenantbridge.api.service;

import com.tenantbridge.api.common.responses.BaseApiResponse;
import com.tenantbridge.api.repository.tenant.TenantRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TenantService {

    private TenantRepository tenantRepository;

    public ResponseEntity<BaseApiResponse> getTenantDetails(){
        return ResponseEntity.ok(new BaseApiResponse(true, "yup"));
    }

}
