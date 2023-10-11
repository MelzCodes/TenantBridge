package com.tenantbridge.api.common;

import jakarta.validation.constraints.NotBlank;

public record ApiResponse(boolean success, @NotBlank String message) {
}
