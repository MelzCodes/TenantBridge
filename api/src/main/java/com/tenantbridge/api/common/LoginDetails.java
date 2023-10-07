package com.tenantbridge.api.common;

import jakarta.validation.constraints.NotBlank;

public record LoginDetails(@NotBlank String email, @NotBlank String password) {
}
