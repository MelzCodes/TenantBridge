package com.tenantbridge.api.common.responses;

import java.util.List;

public record ListAllObjectsResponse<T>(boolean success, List<T> allObjects) {
}
