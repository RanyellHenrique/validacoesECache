package com.ranyell.testes.validation.valid;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ValidTotalProduct.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)

public @interface ValidTotal {
    String message() default "O Total deve ser a soma dos produtos";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
