package com.example.java_class_loader;

import java.lang.reflect.Field;

public class MyClass {

    public static final String CHECK_DEX_CLASS = "com.example.java_class_loader.TinkerTestDexLoad";
    public static final String CHECK_DEX_FIELD = "isPatch";
    public static final String FOOT = "foot";

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.testClassName();

        try {
            boolean result = checkDexInstall(MyClass.class.getClassLoader());

            displayAllFiled(MyClass.class.getClassLoader());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void displayAllFiled(ClassLoader classLoader) {
        try {
            Class<?> aClass = Class.forName(CHECK_DEX_CLASS, true, classLoader);
            Field[] fields = aClass.getFields();
            System.err.println("---------已经声明的成员变量 --------- ");
            for (Field field : fields) {
                String fieldName = field.getName();
                Object value = field.get(null);
                System.err.println("fieldName : "+fieldName);
                System.err.println("初始值     : "+value);
            }
            System.err.println("----------------------------------- ");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testClassName() {
        String simpleName = this.getClass().getSimpleName();
        System.err.println("simpleName:" + simpleName);

    }

    private static boolean checkDexInstall(ClassLoader classLoader) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        //  String CHECK_DEX_CLASS = "com.tencent.tinker.loader.TinkerTestDexLoad";
        Class<?> clazz = Class.forName(CHECK_DEX_CLASS, true, classLoader);
        //  String CHECK_DEX_FIELD = "isPatch";
        Field isPatchFiled = ShareReflectUtil.findField(clazz, CHECK_DEX_FIELD);
        boolean isPatchResult = (boolean) isPatchFiled.get(null);
        Field footFiled = ShareReflectUtil.findField(clazz, FOOT);

        String footContent = (String) footFiled.get(null);
        System.err.println("checkDexInstall result:" + isPatchResult + "checker_classloader ：" + clazz.getClassLoader());
        System.err.println("checkDexInstall xiao ya foot Content : " + footContent);
        return isPatchResult;
    }

}