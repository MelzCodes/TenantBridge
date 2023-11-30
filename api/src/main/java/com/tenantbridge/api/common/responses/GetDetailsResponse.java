package com.tenantbridge.api.common.responses;

public record GetDetailsResponse<T>(boolean success, T objectDetails) {
}
