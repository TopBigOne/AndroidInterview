#include <jni.h>
#include <string>

#include <iostream>
#include <jni.h>
#include <string>
#include <android/log.h>
#include <stdio.h>
#include <time.h>
#include <ctime>
#include "breakpad/src/client/linux/handler/minidump_descriptor.h"
#include "breakpad/src/client/linux/handler/exception_handler.h"
#include <jni.h>

#define TAG "NativeCrash"
#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG,TAG ,__VA_ARGS__) // 定义LOGD类型
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO,TAG ,__VA_ARGS__) // 定义LOGI类型
#define LOGW(...) __android_log_print(ANDROID_LOG_WARN,TAG ,__VA_ARGS__) // 定义LOGW类型
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR,TAG ,__VA_ARGS__) // 定义LOGE类型
#define LOGF(...) __android_log_print(ANDROID_LOG_FATAL,TAG ,__VA_ARGS__) // 定义LOGF类型
