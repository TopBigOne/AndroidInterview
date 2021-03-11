package com.example.java_class_loader;

public class MyClass {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.testClassName();

    }

    public void testClassName(){
        String simpleName = this.getClass().getSimpleName();
        System.out.println("simpleName:"+simpleName);

    }
}