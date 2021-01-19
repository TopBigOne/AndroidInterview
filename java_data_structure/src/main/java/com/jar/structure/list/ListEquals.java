package com.jar.structure.list;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author : dev
 * @version :
 * @Date :  12/2/20 9:26 PM
 * @Desc :
 */
public class ListEquals {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);

        // the result is true；
        // 因为 ArrayList的 equal() 只进行了是否为 List 子类的判断，接着就调用了 equalRange() 方法
        if (arrayList.equals(linkedList)) {
            System.out.println("equal is true...");
            return;
        }
        System.out.println("equal is false...");
    }
}
