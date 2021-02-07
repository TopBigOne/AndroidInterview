package com.android.base.ten_question;

/**
 * @author : dev
 * @version :
 * @Date :  2/7/21 2:43 PM
 * @Desc :
 */
public class Q2 {
    public static void main(String[] args) {
        // s += 1 逻辑上看作是 s = s + 1 计算结果被提升为int类型，再向short类型赋值时发生错误，因为不能将取值范围 大的类型赋值到取值范围小的类型。但是， s=s+1进行两次运算 ， += 是一个运算符，只运算一次，并带有强制转换的特点， 也就是说 s += 1 就是 s = (short)
        short s = 1;
        s +=1;
        System.out.println("s: "+s);
    }

}
