package com.Validation.beanvalidaitonExample.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

//<the annotation that is to be validated, the data type of the field that the annotation is used to validate>
//suppose we are validating a field name UserType then <ValidateUserType(anootation that we have created),String(datatype of the field)>
public class UserTypeValidator implements ConstraintValidator<ValidateUserType,String> {

    @Override
    public boolean isValid(String userType, ConstraintValidatorContext constraintValidatorContext) {
       List<String> userTypes = Arrays.asList("Admin","user","superadmin");
       return userTypes.contains(userType);
    }
}
