package com.jar.pattern.factory.day_02_abstract_factory;

/**
 * @author : dev
 * @version :
 * @Date :  5/2/21 6:26 PM
 * @Desc :
 */
public class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("You have created WindowsButton.");
    }
}
