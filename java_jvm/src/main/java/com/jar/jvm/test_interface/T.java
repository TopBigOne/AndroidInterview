package com.jar.jvm.test_interface;

/**
 * @author : dev
 * @version :
 * @Date :  2021/3/27 17:49
 * @Desc :
 */
public interface T {

    /**
     * 默认函数，，
     * @return  123.
     */
    default  int myDefaultFun(){
        return 123;
    }
    /**
     * 静态函数
     */
    static  void hello(){
        System.out.println("say hi");
    }
}
