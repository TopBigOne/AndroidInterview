package com.jar.hook;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;

/**
 * @author : dev
 * @version :
 * @Date :  2021/5/18 13:09
 * @Desc :
 */
public class EvilInstrumentation extends Instrumentation {

    public Instrumentation mBase;

    public EvilInstrumentation(Instrumentation mBase) {
        this.mBase = mBase;
    }

    public Activity newActivity(ClassLoader cl, String className, Intent intent) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        return mBase.newActivity(cl, className, intent);
    }

    public void callActivityOnCreate(Activity activity, Bundle bundle) {
        Class[] p1 = {Activity.class, Bundle.class};
        Object[] v1 = {activity, bundle};



    }

}
