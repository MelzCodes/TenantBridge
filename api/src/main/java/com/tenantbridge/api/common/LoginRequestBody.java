package com.tenantbridge.api.common;

import jakarta.validation.constraints.NotBlank;

public record LoginRequestBody(@NotBlank String email, @NotBlank String password) {
}
