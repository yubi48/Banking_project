package com.rab3tech.aop.advice;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface TimeLogger {
   String value() default "This is default time 100"; 
}
