package com.jar.pattern.factory.day_02_simple_factory_2;

import com.jar.pattern.factory.day_02_simple_factory.INoodles;

/**
 * @author : dev
 * @version :
 * @Date :  5/2/21 10:19 PM
 * @Desc :
 *
 * 普通工厂模式特点：不仅仅做出来的产品要抽象， 工厂也应该需要抽象。
 */
public  abstract class NoodlesFactory {
    public abstract INoodles create();
}
