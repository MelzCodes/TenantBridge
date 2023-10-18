package com.tenantbridge.api.common;

import jakarta.validation.constraints.NotBlank;

public record RegistrationRequestBody(@NotBlank String firstName, @NotBlank String lastName, @NotBlank String email, @NotBlank String password) {
}
