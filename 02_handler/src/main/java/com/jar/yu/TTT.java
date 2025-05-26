package com.jar.yu;

/**
 * @author : 周广亚
 * @version :
 * @Date :  2024/8/19 15:41
 * @Desc :
 */
public class TTT {

    static int anInt = 0;
    // static  int anInt = 9;

    // case 1:
    private static volatile TTT mInstance = null;

    // case 2
    private TTT() {
    }

    /**
     * DCL
     * // 1: new
     * // 2:aload ()
     * // 3: invokespecil()
     * // 4: return T
     *
     * @return
     */
    public static TTT getInstance() {
        if (mInstance == null) {
            synchronized (TTT.class) {
                if (mInstance == null) {
                    mInstance = new TTT();
                }
            }
        }

        return mInstance;
    }
}
