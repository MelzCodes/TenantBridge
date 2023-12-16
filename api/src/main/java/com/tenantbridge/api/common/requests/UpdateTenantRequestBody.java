package com.tenantbridge.api.common.requests;

import com.tenantbridge.api.model.tenant.TenantDetails;
import jakarta.validation.constraints.NotNull;

public record UpdateTenantRequestBody(@NotNull String tenantId, @NotNull TenantDetails tenantDetails) {
}
