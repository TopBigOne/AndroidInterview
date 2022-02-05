package com.jar.ndk.bean;

/**
 * @author : dev
 * @version :
 * @Date :  2022/2/6 00:33
 * @Desc :
 */
public class Person {
    int age;
    String name;
    long userId;

    public Person(int age, String name, long userId) {
        this.age = age;
        this.name = name;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", userId=" + userId +
                '}';
    }





}
