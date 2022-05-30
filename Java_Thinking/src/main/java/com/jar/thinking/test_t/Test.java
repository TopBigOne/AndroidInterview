package com.jar.thinking.test_t;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/29 15:43
 * @Desc :
 */
public class Test {

    void test() {
        MyClass<String> stringMyClass = new MyClass<>();
        MyClass<?> stringMyClass2 = new MyClass<>();
        stringMyClass.add("dsf");

        stringMyClass2 = stringMyClass;


    }

}
