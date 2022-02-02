package com.jar.oom;

import javassist.CannotCompileException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  2/18/21 6:16 PM
 * @Desc :   方法区 oom：不间断的调用 intern();
 */
public class MethodAreaOOMByIntern implements Run {

    String str = "test_jar_jar";
    static javassist.ClassPool cp = javassist.ClassPool.getDefault();

    @Override
    public void execute() {
        //
        //  test1();
        test2();

    }

    /**
     * -Xms20m -Xmx20m
     * <p>
     * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
     */
    private void test1() {
        List<String> list = new ArrayList<>();
        while (true) {
            String str2 = str + str;
            str = str2;
            list.add(str.intern());
        }
    }

    /**
     * javassist.CannotCompileException: by java.lang.ClassFormatError: Metaspace
     * -XX:MetaspaceSize=50m -XX:MaxMetaspaceSize=50m
     */
    private void test2() {

        for (int i = 0; ; i++) {
            try {
                Class c = cp.makeClass("eu.plumbr.demo.Generated" + i).toClass();
            } catch (CannotCompileException e) {
                e.printStackTrace();
                return;
            }
        }
    }


    public static void main(String[] args) {
        MethodAreaOOMByIntern methodAreaOOMByIntern = new MethodAreaOOMByIntern();
        methodAreaOOMByIntern.execute();

    }


}
