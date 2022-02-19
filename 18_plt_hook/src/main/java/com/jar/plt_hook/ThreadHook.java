package com.jar.plt_hook;

/**
 * @author : dev
 * @version :
 * @Date :  2/20/22 1:07 AM
 * @Desc :
 */
public class ThreadHook {
    static {
        System.loadLibrary("plt_hook");
    }

    private static boolean sHasHook = false;
    private static boolean sHookFailed = false;


    public static String getStack() {
        return stackTraceToString(new Throwable().getStackTrace());
    }

    private static String stackTraceToString(final StackTraceElement[] arr) {
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
