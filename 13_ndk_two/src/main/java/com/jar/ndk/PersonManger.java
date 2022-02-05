package com.jar.ndk;

import android.util.Log;

import com.jar.ndk.bean.Person;

/**
 * @author : dev
 * @version :
 * @Date :  2022/2/6 01:22
 * @Desc :
 */
public class PersonManger {
    private static final String TAG = "PersonManger ";

    public static void createPerson() {
        Person person = JniHelp.nativeCreatePerson();
        Log.d(TAG, "createPerson# " + person);
    }

    public static void modifyPerson() {
        Person person = JniHelp.nativeCreatePerson();
        Person newPerson = JniHelp.nativeModifyPerson(person);
        Log.d(TAG, "modifyPerson# " + newPerson);
    }

    public void doLoop(int time) {
        for (int i = 0; i < time; i++) {
            Log.d(TAG, "doLoop: " + i);
        }
    }


}
