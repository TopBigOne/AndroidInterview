package com.jar.pattern.factory.day_02_factory_method;

import com.jar.pattern.factory.day_02_factory_method.dialog.Dialog;
import com.jar.pattern.factory.day_02_factory_method.dialog.HtmlDialog;
import com.jar.pattern.factory.day_02_factory_method.dialog.WindowsDialog;

/**
 * @author : dev
 * @version :
 * @Date :  5/2/21 3:46 PM
 * @Desc :
 */
public class Demo {
    static Dialog dialog;

    public static void main(String[] args) {
        configure();
        runBusinessLogic();
    }

    private static void configure() {
        if (System.getProperty("os.name").equals("Mac OS X")) {
            dialog = new WindowsDialog();
            return;
        }

        dialog = new HtmlDialog();
    }

    private static void runBusinessLogic() {
        dialog.renderWindow();
    }


}
