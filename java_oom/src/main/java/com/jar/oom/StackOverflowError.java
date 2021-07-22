package com.jar.oom;



/**
 * @author : Jakarta
 * @version :
 * @Date : 10/17/20 11:36 PM
 * @Desc :
 */
public class StackOverflowError implements Run {
    public static  int stackLenght =1;
    @Override
    public void execute() {
        stackLenght++;
        execute();
    }
}
