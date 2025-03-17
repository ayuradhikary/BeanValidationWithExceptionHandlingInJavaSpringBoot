package com.Validation.beanvalidaitonExample.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;
import java.lang.reflect.Field;

@Target({ElementType.FIELD,ElementType.PARAMETER}) //adding the annotation in the field level and paraeter level
@Retention(RetentionPolicy.RUNTIME) //implementing the annotation at run time
@Documented
//The @Documented annotation is a meta-annotation,
//meaning it is used to annotate other annotations.
//When an annotation is annotated with @Documented,
//it means that the annotation will appear in the Javadoc output of the class
//or method to which it is applied.
@Constraint(validatedBy = UserTypeValidator.class)
//the validation logic should be written inside the UserTypeValidator class.
public @interface ValidateUserType {
    public String message() default "Invalid user Type";

    //have to add these to the custom annotation
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

//we have successfully created @ValidateUserType annotation in a field.

