package com.jar.java_pattern.day_01_singletion;

/**
 * @author : dev
 * @version :
 * @Date :  2021/4/28 11:02
 * @Desc : 单例模式
 */
public class DCL {
    //1： 通过volatile关键字来确保安全
    private static volatile DCL INSTANCE;

    // 2:私有化构造函数
    private DCL() {

    }

    public static DCL getInstance() {
        if (INSTANCE == null) {
            // 1 只有singleton==null时才加锁，性能好
            synchronized (DCL.class) {
                //  反之
                if (INSTANCE == null) {
                    INSTANCE = new DCL();
                }
            }
        }
        return INSTANCE;
    }
}
