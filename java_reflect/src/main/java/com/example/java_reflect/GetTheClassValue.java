package com.example.java_reflect;

import java.lang.reflect.Field;

/**
 * @author : 周广亚
 * @version :
 * @Date :  2023/4/29 13:56
 * @Desc : 利用反射，获取类中成员变量的值;
 * 还是需要自己 传入 相应的 class 对象
 */
public class GetTheClassValue {
    public String name = "简历";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        GetTheClassValue getTheClassValue = new GetTheClassValue();
        getTheClassValue.setName("自己人");
        startReflect();
    }

    private static void startReflect() {
        try {

            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            Class<?> aClass = classLoader.loadClass("com.example.java_reflect.GetTheClassValue");
            Field aClassField = aClass.getField("name");
            aClassField.setAccessible(true);

            //GetTheClassValue getTheClassValue = new GetTheClassValue();
            String tempName = (String) aClassField.get(null);
            System.out.println("tempName : "+tempName);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
