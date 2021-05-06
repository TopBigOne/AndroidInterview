package com.jar.java_pattern.factory.day_02_abstract_factory;

/**
 * @author : dev
 * @version :
 * @Date :  5/2/21 6:25 PM
 * @Desc :
 */
public class MacOSButton implements Button {
    @Override
    public void paint() {
        System.out.println("You have created MacOSButton.");
    }
}
