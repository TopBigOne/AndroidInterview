package com.jar.java_pattern.factory.day_02_factory_method.dialog;

import com.jar.java_pattern.factory.day_02_factory_method.btn.Button;

/**
 * @author : dev
 * @version :
 * @Date :  5/2/21 3:40 PM
 * @Desc :
 */
public  abstract class Dialog {
    public void renderWindow(){
        Button button = createButton();
        button.onClick();
    }

    /**
     * 在子类中重写
     * @return
     */
    protected abstract Button createButton();
}
