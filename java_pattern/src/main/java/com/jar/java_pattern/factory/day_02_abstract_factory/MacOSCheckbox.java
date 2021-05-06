package com.jar.java_pattern.factory.day_02_abstract_factory;

/**
 * @author : dev
 * @version :
 * @Date :  5/2/21 6:27 PM
 * @Desc :
 */
public class MacOSCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("You have created MacOSCheckbox.");
    }
}
