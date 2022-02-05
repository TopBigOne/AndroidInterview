#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_jar_native_1lib_1tip_1ip_JniHandler_stringFromJNI_(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}