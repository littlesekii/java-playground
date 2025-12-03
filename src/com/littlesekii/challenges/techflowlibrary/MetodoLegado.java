package com.littlesekii.challenges.techflowlibrary;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MetodoLegado {
    String motivo();
    String versaoRemocao() default "2.0";
}