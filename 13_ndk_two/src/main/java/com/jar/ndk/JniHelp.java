package com.jar.ndk;

import com.jar.ndk.bean.Person;

/**
 * @author : dev
 * @version :
 * @Date :  2022/2/6 00:05
 * @Desc :
 */
public class JniHelp {
    static {
        System.loadLibrary("xiao_ya");
    }


    /**
     * Native 获取手机架构
     *
     * @return
     */
    public static native String nativeGetAbi();

    /**
     * Native 创建 Java 对象的属性
     *
     * @return
     */
    public static native Person nativeCreatePerson();

    /**
     * Native 操作 Java 对象的属性
     *
     * @return
     */
    public static native Person nativeModifyPerson(Person person);

    /**
     * Native 调用java 层的函数
     */
    public static native void nativeInvokeJavaMethod();


    public static native void nativeStartTicks();



    public static native void nativeStopTicks();


}
