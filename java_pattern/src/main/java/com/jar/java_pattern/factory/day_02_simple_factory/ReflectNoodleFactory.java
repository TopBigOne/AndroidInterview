package com.jar.java_pattern.factory.day_02_simple_factory;

/**
 * @author : dev
 * @version :
 * @Date :  5/2/21 10:13 PM
 * @Desc : 利用发射创建对象
 */
public class ReflectNoodleFactory {
    public static <T extends INoodles> T createNoodles(Class<T> clz) {
        T result = null;
        try {
            result = (T) Class.forName(clz.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
