package com.tenantbridge.api.common.requests;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record UpdateTenantRequestBody(@NotNull LocalDate dateOfBirth ) {
}
