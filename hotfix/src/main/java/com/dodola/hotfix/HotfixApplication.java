package com.dodola.hotfix;

import android.app.Application;
import android.content.Context;

import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

import dalvik.system.BaseDexClassLoader;
import dalvik.system.PathClassLoader;

/**
 * @author : Jakarta
 * @version :
 * @Date : 6/29/20 8:48 PM
 * @Desc :
 */
public class HotfixApplication extends Application {

    private File mApk;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        mApk = new File(getCacheDir() + "/hotfix.dex");
        if (!mApk.exists()) {
            return;
        }
        try {
            ClassLoader classLoader = getClassLoader();
            Class loaderClass = BaseDexClassLoader.class;
            Field pathListField = loaderClass.getDeclaredField("pathList");
            pathListField.setAccessible(true);
            Object pathListObject = pathListField.get(classLoader);
            if (pathListObject == null) {
                return;
            }

            Class pathListClass = pathListObject.getClass();
            Field dexElementsField = pathListClass.getDeclaredField("dexElements");
            dexElementsField.setAccessible(true);

            PathClassLoader newClassLoader = new PathClassLoader(mApk.getPath(), null);
            // newClassLoader.pathList
            Object newPathListObject = pathListField.get(newClassLoader);

            // newClassLoader.pathList.dexElements
            Object newDexElementsObject = dexElementsField.get(newPathListObject);
            // getClassLoader().pathList.dexElements
            Object dexElementsObject = dexElementsField.get(newPathListObject);

            int oldLength = Array.getLength(dexElementsObject);
            int newLength = Array.getLength(newDexElementsObject);
            Object concatDexElementObject = Array.newInstance(dexElementsObject.getClass().getComponentType(),
                    oldLength + newLength);
            for (int i = 0; i < newLength; i++) {
                Array.set(concatDexElementObject, i, Array.get(newDexElementsObject, i));
            }
            for (int i = 0; i < oldLength; i++) {
                Array.set(concatDexElementObject, newLength + i, Array.get(dexElementsField, i));
            }
            dexElementsField.set(pathListObject, concatDexElementObject);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
