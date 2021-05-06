package com.jar.java_pattern.factory.day_02_factory_method.dialog;

import com.jar.java_pattern.factory.day_02_factory_method.btn.Button;
import com.jar.java_pattern.factory.day_02_factory_method.btn.WindowsButton;

/**
 * @author : dev
 * @version :
 * @Date :  5/2/21 3:43 PM
 * @Desc :
 */
public class WindowsDialog extends Dialog {
    @Override
    protected Button createButton() {
        return new WindowsButton();
    }
}
