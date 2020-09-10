package com.android.interview.handler;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author : Jakarta
 * @version :
 * @Date : 2020-06-07 13:15
 * @Desc : Handler 的问题。
 * Android 的消息机制：
 * 1：概述： android 规定了只能在主线程中更新 UI，并且在 {@link ViewRootImpl} 类中的 checkThread() 函数中进行了检测；
 * 2.1 : ThreadLocal 的工作原理：
 * 2.2 : 消息队列的
 */
public class HandlerDemo {
    public void test() {
    }

}
