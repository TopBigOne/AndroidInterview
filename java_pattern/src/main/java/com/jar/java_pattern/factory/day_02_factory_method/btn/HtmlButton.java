package com.jar.java_pattern.factory.day_02_factory_method.btn;

/**
 * @author : dev
 * @version :
 * @Date :  5/2/21 3:38 PM
 * @Desc : 具体产品 https://refactoringguru.cn/design-patterns/factory-method/java/example
 */
public class HtmlButton implements Button {
    @Override
    public void render() {
        System.out.println("<HtmlButton>Test Button</HtmlButton>");
        onClick();

    }

    @Override
    public void onClick() {
        System.out.println("Click! Button says - 'Hello World!'");
    }
}
