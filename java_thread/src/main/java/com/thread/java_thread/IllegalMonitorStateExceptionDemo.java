package com.thread.java_thread;

/**
 * @author : dev
 * @version :
 * @Date :  4/18/21 1:59 PM
 * @Desc :
 * 关于java.lang.IllegalMonitorStateException异常说明（四）
 * 首先你要了解这个异常为什么会抛出，这个异常会在三种情况下抛出：
 * 1>当前线程不含有当前对象的锁资源的时候，调用obj.wait()方法;
 * 2>当前线程不含有当前对象的锁资源的时候，调用obj.notify()方法。
 * 3>当前线程不含有当前对象的锁资源的时候，调用obj.notifyAll()方法。
 */
public class IllegalMonitorStateExceptionDemo {


}
