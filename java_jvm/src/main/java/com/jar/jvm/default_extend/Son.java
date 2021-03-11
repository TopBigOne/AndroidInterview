package com.jar.jvm.default_extend;

/**
 * @author : dev
 * @version :
 * @Date :  3/11/21 2:50 PM
 * @Desc :
 */
public class Son extends Father {
    @Override
    public void testJar() {
        //super.testJar();
        System.out.println("执行子类的方法");
    }
}
