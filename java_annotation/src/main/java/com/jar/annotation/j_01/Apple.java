package com.jar.annotation.j_01;

/**
 * @author : dev
 * @version :
 * @Date :  2021/4/29 17:44
 * @Desc :
 */
public class Apple {
    @FruitName("富士山苹果")
    private String appleName;


    @FruitColor(fruitColor = FruitColor.Color.RED)
    private String appleColor;

    @FruitProvider(id = 1, name = "杭州西湖", address = "文艺路22号底商")
    private String appleProvider;

    public String getAppleColor() {
        return appleColor;
    }


    public void setAppleName(String appleName) {
        this.appleName = appleName;
    }

    public String getAppleName() {
        return appleName;
    }

    public void displayName() {
        System.out.println("水果的名字是：" + appleName);
    }


}
