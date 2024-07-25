//
// Created by dev on 2024/7/25.
//

#ifndef INTERVIEW_MMAP_UTIL_H
#define INTERVIEW_MMAP_UTIL_H

#include "../alog.h"
#include <stdio.h>
#include <fcntl.h>
#include <sys/mman.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <strings.h>
#include <android/log.h>
#include <string>


//写在头文件里的变量如果不加上static 的话会造成重复引用 最好的办法就是不要写在头文件
static int8_t *_ptr = 0;
static size_t _size;
static int32_t _fd;

void mmap_write(const char *src_ptr, const int32_t len, const char *path_ptr, const char *name_ptr);

void mmap_write(const std::string src_ptr, const std::string path, const std::string name);

void mmap_write(const void *src_ptr, const int32_t len, const char *path_ptr, const char *name_ptr);

#endif //INTERVIEW_MMAP_UTIL_H
