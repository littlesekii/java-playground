package com.littlesekii.playground.examples.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface StreamerData {
    String name() default "Littlesekii";
    String mostPlayedGame() default "Hollow Knight";
}
