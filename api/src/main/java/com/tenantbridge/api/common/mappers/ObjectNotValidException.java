package com.tenantbridge.api.common.mappers;

import lombok.Data;

import java.util.Set;

@Data
public class ObjectNotValidException extends RuntimeException {
    private final Set<String> errorMessages;
}
