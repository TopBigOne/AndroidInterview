package com.top.jar.chapter_004;

/**
 * @author : dev
 * @version :
 * @Date :  1/12/21 12:03 AM
 * @Desc : 裴波那楔数列： 最普通的写法！
 */
public class GeneralFib {
    int fib(int n){
        if (n<=1) {
            return n;

        }
        else {
            return fib(n-1)+fib(n-2);
        }
    }
}
