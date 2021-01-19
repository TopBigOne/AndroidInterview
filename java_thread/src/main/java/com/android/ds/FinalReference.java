package com.android.ds;

import java.util.Collections;

/**
 * @author : dev
 * @version :
 * @Date :  12/1/20 9:50 PM
 * @Desc : 在构造函数返回之前，被构造对象的引用，不能被其他线程可见，以为此时 final scope 可能还没有初始化。
 */
public class FinalReference {
    final int i;
    static FinalReference obj;

    public FinalReference() {
        this.i = 1;
        // this 在此"逸出"
        obj = this;
    }

    public static void write() {
        new FinalReference();
    }

    public static void reader() {
        if (obj != null) {
            // FinalReference 没有被初始化，i 的值，很可能是 0；
            int temp = obj.i;
            System.out.println("temp :" + temp);
        }
    }
}
