package br.com.desafio.utils;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {CampoUnicoValidator.class})
public @interface CampoUnico {
    String message() default "Informação já cadastrada!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    Class<?> klazz();

    String name();
}
