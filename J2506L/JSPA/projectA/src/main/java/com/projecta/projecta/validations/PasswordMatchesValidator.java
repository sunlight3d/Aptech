package com.projecta.projecta.validations;

import com.projecta.projecta.dtos.requests.user.UserRegisterRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator
        implements ConstraintValidator<PasswordMatches, UserRegisterRequest> {

    @Override
    public boolean isValid(UserRegisterRequest request, ConstraintValidatorContext context) {
        if (request.getPassword() == null || request.getRetypePassword() == null) {
            return false;
        }
        return request.getPassword().equals(request.getRetypePassword());
    }
}
