package com.thread.reentrant;

/**
 * @author : 周广亚
 * @version :
 * @Date :  2023/4/29 18:23
 * @Desc :
 */
public class Log {
    static void d(String tag, String content) {
        System.err.println(tag + content);
    }static void e(String tag, String content) {
        System.err.println(tag + content);
    }
}
