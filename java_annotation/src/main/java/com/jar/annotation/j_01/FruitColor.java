package com.jar.annotation.j_01;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : dev
 * @version :
 * @Date :  2021/4/29 17:44
 * @Desc :
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FruitColor {
    public enum Color {BLUE, RED, GREEN};

    public Color fruitColor() default Color.GREEN;
}
