package com.dodola.thread;

/**
 * @author : dev
 * @version :
 * @Date :  6/23/21 6:13 PM
 * @Desc :
 */
public final class ThreadHook {

    static {
        System.loadLibrary("threadhook");
    }

    private static boolean sHasHook = false;
    private static boolean sHookFailed = false;
    public static String getStack(){
        return stackTraceToStirng(new Throwable().getStackTrace());
    }

   //  python2 systrace.py dalvik -b 90960 -a com.dodola.thread

    private static String stackTraceToStirng(StackTraceElement[] arr) {

        if (arr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();

        for (StackTraceElement stackTraceElement : arr) {
            String className = stackTraceElement.getClassName();
            // remove unused stacks
            if (className.contains("java.lang.Thread")) {
                continue;
            }
            sb.append(stackTraceElement).append('\n');
        }
        return sb.toString();

    }
    public static void enableThreadHook() {
        if (sHasHook) {
            return;
        }
        sHasHook = true;
        enableThreadHookNative();

    }

    private static native void enableThreadHookNative();


}
