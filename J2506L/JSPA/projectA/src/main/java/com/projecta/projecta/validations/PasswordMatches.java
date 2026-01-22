package com.projecta.projecta.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordMatchesValidator.class)
@Documented
public @interface PasswordMatches {
    String message() default "Password và RetypePassword không khớp";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
