package com.jar.jvm.default_extend;

/**
 * @author : dev
 * @version :
 * @Date :  3/11/21 2:51 PM
 * @Desc :
 */
public class TestDefaultExtend {
    public static void main(String[] args) {
        Father father = new Father();
       // father.testJar();
        Son son = new Son();
        son.testJar();
        System.out.println("---------分割线-------");
        Father father2 = new Son();
        father2.testJar();
    }

}
