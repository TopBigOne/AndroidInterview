cmake_minimum_required(VERSION 3.4.1)

# Declares and names the project.

project("test_breakpad")

add_subdirectory(breakpad)

include_directories(breakpad/src breakpad/src/common/android/include)

add_library(
        test_breakpad
        SHARED
        test_breakpad.cpp)


find_library(
        log-lib
        log)


target_link_libraries(
        test_breakpad
        ${log-lib} breakpad)