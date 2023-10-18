package com.tenantbridge.api.common;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationResponse(boolean success, @NotBlank String message, String jwt) {
}


