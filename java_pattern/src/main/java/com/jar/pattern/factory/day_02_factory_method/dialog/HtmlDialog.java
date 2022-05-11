package com.jar.pattern.factory.day_02_factory_method.dialog;

import com.jar.pattern.factory.day_02_factory_method.btn.Button;
import com.jar.pattern.factory.day_02_factory_method.btn.HtmlButton;

/**
 * @author : dev
 * @version :
 * @Date :  5/2/21 3:42 PM
 * @Desc :
 */
public class HtmlDialog extends Dialog {
    @Override
    protected Button createButton() {
        return new HtmlButton();
    }
}
