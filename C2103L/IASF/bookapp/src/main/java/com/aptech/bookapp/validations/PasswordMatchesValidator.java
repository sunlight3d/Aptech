package com.aptech.bookapp.validations;
import com.aptech.bookapp.viewmodels.UserRegisterModel;
import jakarta.validation.*;
public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        if (obj instanceof UserRegisterModel) {
            UserRegisterModel userRegisterModel = (UserRegisterModel) obj;
            return userRegisterModel.getPassword().equals(userRegisterModel.getRetypePassword());
        }
        return false;
    }
}
