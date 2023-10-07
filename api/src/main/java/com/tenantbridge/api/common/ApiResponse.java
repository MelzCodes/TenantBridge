package com.tenantbridge.api.common;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ApiResponse(@NotNull boolean success, @NotBlank String message) {
}
