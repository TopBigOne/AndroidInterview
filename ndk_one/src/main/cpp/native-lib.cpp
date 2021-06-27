//
// Created by Dev on 1/6/21.
//
#include <jni.h>
#include <string>
#include <iostream>
#include "android/log.h"
#include <cstdlib>

using namespace std;


#define LOGI(...) \
  ((void)__android_log_print(ANDROID_LOG_INFO, kTAG, __VA_ARGS__))
#define LOGW(...) \
  ((void)__android_log_print(ANDROID_LOG_WARN, kTAG, __VA_ARGS__))
#define LOGE(...) \
  ((void)__android_log_print(ANDROID_LOG_ERROR, kTAG, __VA_ARGS__))

extern "C" JNIEXPORT jstring JNICALL
Java_com_jar_ndk_MainActivity_getTxt(JNIEnv *env, jobject) {
    string hello = "jar jar";
    string s1 = "www.toutiao.cn";
    unsigned int size = s1.size();
    cout << "zhou_size" << size << endl;
    printf("my_age %d", 34);

    LOGI("Something size %s=d", size);

    return env->NewStringUTF(hello.c_str());
}


