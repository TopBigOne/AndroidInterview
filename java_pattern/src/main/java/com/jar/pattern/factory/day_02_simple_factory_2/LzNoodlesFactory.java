package com.jar.pattern.factory.day_02_simple_factory_2;

import com.jar.pattern.factory.day_02_simple_factory.INoodles;
import com.jar.pattern.factory.day_02_simple_factory.LzNoodles;

/**
 * @author : dev
 * @version :
 * @Date :  5/2/21 10:20 PM
 * @Desc : 兰州拉面工厂
 */
public class LzNoodlesFactory extends NoodlesFactory {
    @Override
    public INoodles create() {
        return new LzNoodles();
    }
}
