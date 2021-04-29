package com.jar.annotation.j_01;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : dev
 * @version :
 * @Date :  2021/4/29 17:46
 * @Desc : 水果注解名称
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FruitName {
    String value() default "";
}
