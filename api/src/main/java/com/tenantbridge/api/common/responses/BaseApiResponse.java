package com.tenantbridge.api.common.responses;

import jakarta.validation.constraints.NotBlank;

public record BaseApiResponse(boolean success, @NotBlank String message) {
}
