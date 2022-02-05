#include <jni.h>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_jar_ndk_JniHelp_nativeGetAbi(JNIEnv *env, jclass clazz) {

#if defined(__arm__)
#if defined(__ARM_ARCH_7A__)
#if defined(__ARM_NEON__)
#if defined(__ARM_PCS_VFP)
#define ABI "armeabi-v7a/NEON (hard-float)"
#else
#define ABI "armeabi-v7a/NEON"
#endif
#else
#if defined(__ARM_PCS_VFP)
#define ABI "armeabi-v7a (hard-float)"
#else
#define ABI "armeabi-v7a"
#endif
#endif
#else
#define ABI "armeabi"
#endif
#elif defined(__i386__)
#define ABI "x86"
#elif defined(__x86_64__)
#define ABI "x86_64"
#elif defined(__mips64)  /* mips64el-* toolchain defines __mips__ too */
#define ABI "mips64"
#elif defined(__mips__)
#define ABI "mips"
#elif defined(__aarch64__)
#define ABI "arm64-v8a"
#else
#define ABI "unknown"
#endif
    return env->NewStringUTF("Hello from JNI !  Compiled with ABI " ABI ".");
}

extern "C"
JNIEXPORT void JNICALL
Java_com_jar_ndk_JniHelp_nativeStartTicks(JNIEnv *env, jclass thiz) {

}

extern "C"
JNIEXPORT void JNICALL
Java_com_jar_ndk_JniHelp_nativeStopTicks(JNIEnv *env, jclass thiz) {


}


/**
 * 创建java 对象
 */
extern "C"
JNIEXPORT jobject JNICALL
Java_com_jar_ndk_JniHelp_nativeCreatePerson(JNIEnv *env, jclass thiz) {
    jclass personClass = env->FindClass("com/jar/ndk/bean/Person");
    jmethodID methodId = env->GetMethodID(personClass, "<init>", "(ILjava/lang/String;J)V");
    jstring user_name = env->NewStringUTF("小田广亚郎");
    jint user_age = 30;
    jlong user_id = 12345454;
    jobject user = env->NewObject(personClass, methodId, user_age, user_name, user_id);

    // 释放资源
    env->DeleteLocalRef(personClass);
    env->DeleteLocalRef(user_name);

    return user;
}

/**
 * 修改java层的属性
 */
extern "C"
JNIEXPORT jobject JNICALL
Java_com_jar_ndk_JniHelp_nativeModifyPerson(JNIEnv *env, jclass thiz, jobject person) {
    // java 层的对象
    jclass j_person = env->GetObjectClass(person);
    // 需要修改的字段id
    jfieldID fieldId = env->GetFieldID(j_person, "name", "Ljava/lang/String;");

    char new_char[40] = "Jack Uncle";
    //字符数组new_name_char转换成jstring类型
    jstring new_name = env->NewStringUTF(new_char);
    env->SetObjectField(person, fieldId, new_name);

    env->DeleteLocalRef(j_person);
    env->DeleteLocalRef(new_name);

    return person;
}
extern "C"
JNIEXPORT void JNICALL
Java_com_jar_ndk_JniHelp_nativeInvokeJavaMethod(JNIEnv *env, jclass clazz) {
    jclass person_manger_class = env->FindClass("com/jar/ndk/PersonManger");
    const jint time = 10;
    jmethodID mid_construct = env->GetMethodID(person_manger_class, "<init>", "()V");
    jmethodID methodId = env->GetMethodID(person_manger_class, "doLoop", "(I)V");
    jobject person_manger = env->NewObject(person_manger_class, mid_construct);
    env->CallVoidMethod(person_manger, methodId, time);
}