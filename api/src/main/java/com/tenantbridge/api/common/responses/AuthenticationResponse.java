package com.tenantbridge.api.common.responses;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationResponse(boolean success, @NotBlank String message, String username, String jwt) {
}


