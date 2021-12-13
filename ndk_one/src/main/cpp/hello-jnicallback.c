#include <jni.h>
#include <string.h>
#include <inttypes.h>
#include <pthread.h>
#include <android/log.h>
#include <assert.h>

// http://www.4k8k.xyz/article/CodeMyDream/116427811
static const char *kTAG = "hello-jincallback";
#define LOGI(...) \
  ((void)__android_log_print(ANDROID_LOG_INFO, kTAG, __VA_ARGS__))
#define LOGW(...) \
  ((void)__android_log_print(ANDROID_LOG_WARN, kTAG, __VA_ARGS__))
#define LOGE(...) \
  ((void)__android_log_print(ANDROID_LOG_ERROR, kTAG, __VA_ARGS__))
// processing callback to handler class，上下文
typedef struct tick_context {
    JavaVM *javaVM;
    jclass jniHelperClz;// --------->对应于JniHandler
    jobject jniHelperObj;
    jclass mainActivityClz;//------>对应于MainActivity
    jobject mainActivityObj;
    pthread_mutex_t lock;
    int done;
} TickContext;
TickContext g_ctx;

/*
 * A helper function to wrap java JniHelper::updateStatus(String msg)
 * JNI allow us to call this function via an instance even it is
 * private function.
发送一个Java的消息
 */
void sendJavaMsg(JNIEnv *env, jobject instance,
                 jmethodID func, const char *msg) {
    jstring javaMsg = (*env)->NewStringUTF(env, msg);
    (*env)->CallVoidMethod(env, instance, func, javaMsg);
    (*env)->DeleteLocalRef(env, javaMsg);
}


JNIEXPORT jstring JNICALL
Java_com_jar_ndk_MainActivity_stringFromJNI(JNIEnv *env, jobject thiz) {
    //  return (*env)->NewStringUTF(env, "Hello from JNI !  Compiled with ABI " ABI ".");

    return (*env)->NewStringUTF(env, "Hell0 from JNI");

}


/*
 * Main working thread function. From a pthread,
 *     calling back to MainActivity::updateTimer() to display ticks on UI
 *     calling back to JniHelper::updateStatus(String msg) for msg
    两个callback，一个展示时钟在UI界面上，一个回调发送消息
 */
void *UpdateTicks(void *context) {
    TickContext *pctx = (TickContext *) context;
    JavaVM *javaVM = pctx->javaVM;
    JNIEnv *env;
    jint res = (*javaVM)->GetEnv(javaVM, (void **) &env, JNI_VERSION_1_6);
    if (res != JNI_OK) {
        res = (*javaVM)->AttachCurrentThread(javaVM, &env, NULL);
        if (JNI_OK != res) {
            LOGE("Failed to AttachCurrentThread, ErrorCode = %d", res);
            return NULL;
        }
    }

    jmethodID statusId = (*env)->GetMethodID(env, pctx->jniHelperClz,
                                             "updateStatus",
                                             "(Ljava/lang/String;)V");//获取方法
    //发送消息正在初始化
    sendJavaMsg(env, pctx->jniHelperObj, statusId, "TickerThread status: initializing...");

    // get mainActivity updateTimer function
    jmethodID timerId = (*env)->GetMethodID(env, pctx->mainActivityClz,
                                            "updateTimer", "()V");//获取更新的的方法

    struct timeval beginTime, curTime, usedTime, leftTime;
    const struct timeval kOneSecond = {
            (__kernel_time_t) 1,
            (__kernel_suseconds_t) 0
    };

    sendJavaMsg(env, pctx->jniHelperObj, statusId,
                "TickerThread status: start ticking ...");
    while (1) {
        gettimeofday(&beginTime, NULL);
        pthread_mutex_lock(&pctx->lock);
        int done = pctx->done;
        if (pctx->done) {
            pctx->done = 0;
        }
        pthread_mutex_unlock(&pctx->lock);
        if (done) {
            break;
        }
        (*env)->CallVoidMethod(env, pctx->mainActivityObj, timerId);

        gettimeofday(&curTime, NULL);
        timersub(&curTime, &beginTime, &usedTime);
        timersub(&kOneSecond, &usedTime, &leftTime);
        struct timespec sleepTime;
        sleepTime.tv_sec = leftTime.tv_sec;
        sleepTime.tv_nsec = leftTime.tv_usec * 1000;

        if (sleepTime.tv_sec <= 1) {
            nanosleep(&sleepTime, NULL);
        } else {
            sendJavaMsg(env, pctx->jniHelperObj, statusId,
                        "TickerThread error: processing too long!");
        }
    }

    sendJavaMsg(env, pctx->jniHelperObj, statusId,
                "TickerThread status: ticking stopped");//发送时钟消息
    (*javaVM)->DetachCurrentThread(javaVM);
    return context;
}


JNIEXPORT void JNICALL
Java_com_jar_ndk_MainActivity_startTicks(JNIEnv *env, jobject instance) {
    pthread_t threadInfo_;
    pthread_attr_t threadAttr_;
    pthread_attr_init(&threadAttr_);
    pthread_attr_setdetachstate(&threadAttr_, PTHREAD_CREATE_DETACHED);
    pthread_mutex_init(&g_ctx.lock, NULL);
    jclass clz = (*env)->GetObjectClass(env, instance);
    g_ctx.mainActivityClz = (*env)->NewGlobalRef(env, clz);
    g_ctx.mainActivityObj = (*env)->NewGlobalRef(env, instance);

    int result = pthread_create(&threadInfo_, &threadAttr_, UpdateTicks, &g_ctx);
    assert(result == 0);
    pthread_attr_destroy(&threadAttr_);
    (void) result;

}

JNIEXPORT void JNICALL
Java_com_jar_ndk_MainActivity_StopTicks(JNIEnv *env, jobject thiz) {

}

void queryRuntimeInfo(JNIEnv *env, jobject instance) {
    jmethodID versionFunc = (*env)->GetStaticMethodID(env, g_ctx.jniHelperClz, "getBuildVersion",
                                                      "()Ljava/lang/String;");//获取静态方法
    if (!versionFunc) {
        LOGE("Failed to retrieve getBuildVersion() methodID @ line %d",
             __LINE__);
        return;
    }
    jstring buildVersion = (*env)->CallStaticObjectMethod(env,
                                                          g_ctx.jniHelperClz,
                                                          versionFunc);//调用静态的方法。
    const char *version = (*env)->GetStringUTFChars(env, buildVersion, NULL);//把jsting转换为c类型的字符串
    if (!version) {
        LOGE("Unable to get version string @ line %d", __LINE__);
        return;
    }
    LOGI("Android Version - %s", version);
    // 在调用 GetStringUTFChars 函数从 JVM 内部获取一个字符串之后，JVM 内部会分配一块新的内存，用于存储源字符串的拷贝，以便本地代码访问和修改。即然有内存分配，用完之后马上释放是一个编程的好习惯。
    // 通过调用ReleaseStringUTFChars 函数通知 JVM 这块内存已经不使用了，你可以清除了
    // 注意：这两个函数是配对使用的，用了 GetXXX 就必须调用 ReleaseXXX，而且这两个函数的命名也有规律，除了前面的 Get 和 Release 之外，后面的都一样。
    (*env)->ReleaseStringUTFChars(env, buildVersion, version);//释放jstring

}