package com.jar.java_pattern.factory.day_02_simple_factory;

/**
 * @author : dev
 * @version :
 * @Date :  5/2/21 10:10 PM
 * @Desc : 简单工厂
 */
public class SimpleNoodlesFactory {
    public static final int TYPE_LZ = 1; //兰州拉面

    public static final int TYPE_HOT = 2; //热干面

    public static final int TYPE_PAO = 3; //泡面

    public static INoodles createNoodies(int type) {
        switch (type) {
            case TYPE_LZ:
                return new LzNoodles();
            case TYPE_PAO:
                return new PaoNoodles();
            default:
                return new HotNoodles();
        }
    }


}
