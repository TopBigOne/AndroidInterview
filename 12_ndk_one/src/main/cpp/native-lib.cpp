//
// Created by Dev on 1/6/21.
//
#include <jni.h>
#include <string>
#include <iostream>
#include "android/log.h"
#include <cstdlib>

#


using namespace std;

static const char *kTAG = "NDK";

// Android log function wrappers,对android log进行了封装
#define LOGI(...) \
  ((void)__android_log_print(ANDROID_LOG_INFO, kTAG, __VA_ARGS__))
#define LOGW(...) \
  ((void)__android_log_print(ANDROID_LOG_WARN, kTAG, __VA_ARGS__))
#define LOGE(...) \
  ((void)__android_log_print(ANDROID_LOG_ERROR, kTAG, __VA_ARGS__))

typedef struct tick_context {
    JavaVM *javaVm;
    // 对应于 JniHandler
    jclass jniHelperClz;
    jobject jniHelperObj;
    // 对应于MainActivity;
    jclass mainActivityClz;
    jobject mainActivityObj;
    pthread_mutex_t lock;
    int done;
} Tick_context;

Tick_context g_ctx;


extern "C" JNIEXPORT jstring JNICALL
Java_com_jar_ndk_MainActivity_getTxt(JNIEnv *env, jobject) {
    string hello = "jar jar";
    string s1 = "www.toutiao.cn";
    unsigned int size = s1.size();
    cout << "zhou_size" << size << endl;
    printf("my_age %d", 34);

    LOGI("Something size %u=d", size);

    return env->NewStringUTF(hello.c_str());
}




extern "C"
JNIEXPORT void JNICALL
Java_com_jar_ndk_JniHandler_generateBitmap(JNIEnv *env, jobject thiz, jstring str,
                                           jintArray datas) {

    auto *ch = const_cast<jchar *>(env->GetStringChars(str, JNI_FALSE));

    // 释放
    env->ReleaseStringChars(str, reinterpret_cast<const jchar *>(ch));



}