package com.github.intentservice;

import android.app.IntentService;
import android.content.Intent;

import androidx.annotation.Nullable;

/**
 * @author : dev
 * @version :
 * @Date :  12/21/20 12:25 AM
 * @Desc : IntentService 是一个抽象类，里面有个 ServiceHandler ,
 *       ServiceHandler 的构造函数里需要传递一个 Looper ,
 *       在 IntentService 的 onCreate() 里，有个 HandlerThread
 */
public class TestIntentService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public TestIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }
}
