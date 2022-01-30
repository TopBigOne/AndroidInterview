#include <jni.h>
#include <string>
#include <vector>
#include "LeetCode_300.h"

using namespace std;
extern "C" JNIEXPORT jstring JNICALL
Java_com_jar_ya_NativeLib_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}


extern "C"
JNIEXPORT jint JNICALL
Java_com_jar_ya_NativeLib_nativeLcs(JNIEnv *env, jobject thiz, jintArray nums) {
    LeetCode_300 leetCode300;

    jsize size = env->GetArrayLength(nums);
    jint *intArray = env->GetIntArrayElements(nums, JNI_FALSE);
    vector<int> rawNums;
    rawNums.reserve(size);
    for (int i = 0; i < size; i++) {
        rawNums.push_back(intArray[i]);
    }
    int result = leetCode300.lcs(rawNums);

    return result;

}