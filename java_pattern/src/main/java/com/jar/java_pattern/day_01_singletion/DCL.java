package com.jar.java_pattern.day_01_singletion;

/**
 * @author : dev
 * @version :
 * @Date :  2021/4/28 11:02
 * @Desc :
 */
public class DCL {
    // 通过volatile关键字来确保安全
    private static volatile DCL INSTANCE;

    private DCL() {
    }

    public static DCL getInstance() {
        if (INSTANCE == null) {
            // 1 只有singleton==null时才加锁，性能好
            synchronized (DCL.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DCL();
                }
            }
        }
        return INSTANCE;
    }
}
