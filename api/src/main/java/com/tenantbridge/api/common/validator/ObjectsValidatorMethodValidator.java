package com.tenantbridge.api.common.validator;

import com.tenantbridge.api.common.mappers.ObjectNotValidException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ObjectsValidatorMethodValidator implements ConstraintValidator<ValidateParameters, Object[]> {
    @Override
    public boolean isValid(Object[] methodParameters, ConstraintValidatorContext context) {
        for (Object parameter : methodParameters) {
            ObjectsValidator<Object> objectsValidator = new ObjectsValidator<>();
            try {
                objectsValidator.validate(parameter);
            } catch (ObjectNotValidException e) {
                return false;
            }
        }
        return true;
    }
}
