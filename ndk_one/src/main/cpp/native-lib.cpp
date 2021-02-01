//
// Created by Dev on 1/6/21.
//
#include <jni.h>
#include <string>

using namespace std;

extern "C" JNIEXPORT jstring JNICALL
Java_com_jar_ndk_MainActivity_getTxt(JNIEnv *env,jobject){
    string hello  = "jar jar";
    return env->NewStringUTF(hello.c_str());
}