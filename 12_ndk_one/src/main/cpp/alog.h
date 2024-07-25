//
// Created by dev on 2024/7/23.
//

#ifndef INTERVIEW_ALOG_H
#define INTERVIEW_ALOG_H

#include <android/log.h>

#define LOG_TAG "NATIVE_LOG"
#define DEBUG
#define ANDROID_PLATFORM

#ifdef DEBUG
#ifdef ANDROID_PLATFORM
#define LOGD(...) ((void)__android_log_print(ANDROID_LOG_DEBUG, LOG_TAG, __VA_ARGS__));
#define LOGI(...) ((void)__android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__));
#define LOGW(...) ((void)__android_log_print(ANDROID_LOG_WARN, LOG_TAG, __VA_ARGS__));
#define LOGE(...) ((void)__android_log_print(ANDROID_LOG_ERROR, LOG_TAG, __VA_ARGS__));


#else
#define LOGD(fmt, ...) printf(fmt"\n", ##__VA_ARGS__)
#define LOGI(fmt, ...) printf(fmt"\n", ##__VA_ARGS__)
#define LOGW(fmt, ...) printf(fmt"\n", ##__VA_ARGS__)
#define LOGE(fmt, ...) printf(fmt"\n", ##__VA_ARGS__)
#endif
#else
#define LOGD(...);
#define LOGI(...);
#define LOGW(...);
#define LOGE(...);
#endif

#endif //INTERVIEW_ALOG_H
