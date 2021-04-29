package com.jar.annotation.j_01;

import java.lang.annotation.*;

/**
 * @author : dev
 * @version :
 * @Date :  2021/4/29 17:24
 * @Desc : 水果提供者
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {
    /**
     * 编号
     */
    int id() default -1;

    /**
     *
     * @return name
     */

    String name() default "";

    /**
     *
     * @return 地址
     */

    String address() default "";


}
