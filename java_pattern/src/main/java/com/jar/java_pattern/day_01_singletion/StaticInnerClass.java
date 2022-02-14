package com.jar.java_pattern.day_01_singletion;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/2/7 17:34
 * @Url :
 * @Level :  easy
 * @Desc : 静态内部类实现单例模式
 * @Counter :
 * @Answer :
 */
public class StaticInnerClass {

    private StaticInnerClass() {
    }

    private static class SingletonInstance {
        public static StaticInnerClass instance = new StaticInnerClass();
    }

    public static StaticInnerClass getInstance() {
        return SingletonInstance.instance;
    }
}
