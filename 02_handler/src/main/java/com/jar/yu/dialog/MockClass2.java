package com.jar.yu.dialog;

import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;

/**
 * @author : dev
 * @version :
 * @Date :  5/17/21 1:23 PM
 * @Desc :
 */
public class MockClass2  implements Handler.Callback {
    /**
     * Handler 的 call back
     * @param msg
     * @return
     */
    @Override
    public boolean handleMessage(@NonNull Message msg) {

        return false;
    }
}
