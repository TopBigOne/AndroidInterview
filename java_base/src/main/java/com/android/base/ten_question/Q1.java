package com.android.base.ten_question;

/**
 * @author : dev
 * @version :
 * @Date :  2/7/21 2:43 PM
 * @Desc :
 */
public class Q1 {
    public static void main(String[] args) {
        short s = 1;

        // s = s + 1 计算结果被提升为int类型，再向short类型赋值时发生错误，
        // 因为不能将取值范围 大的类型赋值到取值范围小的类型，所以这个程序会报错编译失败。
        // 只能强转
        s = (short) (s+1);
        System.out.println("s: "+s);
    }

}
