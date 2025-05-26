
cmake_minimum_required(VERSION 3.4.1)


project("a21_test_breakpad")


add_subdirectory(breakpad)


include_directories(breakpad/src/common/android/include)

add_library( # Sets the name of the library.
        a21_test_breakpad

        # Sets the library as a shared library.
        SHARED

        # Provides a relative path to your source file(s).
        test_breakpad.cpp)


find_library(log-lib
        log)

target_link_libraries(
        a21_test_breakpad
        breakpad
        ${log-lib})
