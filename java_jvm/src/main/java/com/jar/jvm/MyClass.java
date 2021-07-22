package com.jar.jvm;

public class MyClass {

    public static void main(String[] args) {
        new MyClass();
    }


    public MyClass() {
        int a = 0;
        int b = 0;

        int c = a++;
        int d = ++b;

        System.out.println("c : "+c);
        System.out.println("d : "+d);

    }
}