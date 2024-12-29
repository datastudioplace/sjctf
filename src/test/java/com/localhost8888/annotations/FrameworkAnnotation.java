package com.localhost8888.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import com.localhost8888.enums.CategoryType;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;


@Retention(RUNTIME)
@Target(METHOD)
@Documented
public @interface FrameworkAnnotation {

  public String[] author();

  public CategoryType[] category();
}
