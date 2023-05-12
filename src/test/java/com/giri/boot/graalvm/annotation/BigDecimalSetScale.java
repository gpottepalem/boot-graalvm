package com.giri.boot.graalvm.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * Refer: https://www.baeldung.com/java-custom-annotation
 * @author pottepalemg
 * created May 12, 2023
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface BigDecimalSetScale {
    public int scale() default 2;
}
