package com.jar.pattern.factory.day_02_simple_factory;

/**
 * @author : dev
 * @version :
 * @Date :  5/2/21 10:10 PM
 * @Desc : 简单工厂测试
 * ；扩展性较差；
 */
public class TestSimpleFactory {
    public static void main(String[] args) {
        INoodles noodies = SimpleNoodlesFactory.createNoodies(1);
        noodies.desc();

    }
}
