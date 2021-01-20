package com.jar.structure.queue;

/**
 * @author : dev
 * @version :
 * @Date :  1/20/21 2:28 PM
 * @Desc :
 */
public class People {
  private   String name;
   private int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "姓名：" + name + " 年龄：" + age;
    }

}
