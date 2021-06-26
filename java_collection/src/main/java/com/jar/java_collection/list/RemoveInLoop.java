package com.jar.java_collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author : dev
 * @version :
 * @Date :  2021/6/10 15:10
 * @Desc : 在循环体内删除元素
 */
public class RemoveInLoop {
    public static void main(String[] args) {
        RemoveInLoop removeInLoop = new RemoveInLoop();
//        removeInLoop.testDelete();
//        removeInLoop.testDelete2();
        removeInLoop.testDelete3_1();
//        removeInLoop.testDelete4();
    }

    public void testDelete() {
        // 添加元素
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 10_000; i++) {
            list.add(i);
        }
        // 移除元素，报错：Index 6667 out of bounds for length 6666
        for (int i = 1; i < 10_000; i += 2) {
            list.remove(i);
        }
    }

    public void testDelete2() {
        // 添加元素
        List<String> platformList = getData();
        platformList.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.equals("博客园");
            }
        });
        System.out.println(platformList);
    }

    public void testDelete3() {
        // 添加元素
        List<String> platformList = getData();
        // 遍历删除
        for (String s : platformList) {
            if (s.equals("掘金")) {

                platformList.remove(s);
                // break;
            }
        }
    }

    public void testDelete3_1() {
        List var1 = this.getData();
        Iterator var2 = var1.iterator();
        while (var2.hasNext()) {//
            String var3 = (String) var2.next();
            if (var3.equals("掘金")) {
                // 仔细看，调用的是 var1 移除
                var1.remove(var3);
            }
        }
    }

    public void testDelete4() {
        // 添加元素
        List<String> platformList = getData();

        // 遍历删除
        Iterator<String> iterator = platformList.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (next.equals("博客园")) {
                // 不一样的地方，用 iterator  调用remove
                // iterator.remove();
                // 调用这行代码，其实还会crash
                //  platformList.remove(next);
            }
        }
        System.out.println("platformList  ： " + platformList);
    }

    private List<String> getData() {
        List<String> platformList = new ArrayList<>();
        platformList.add("博客园");
        platformList.add("CSDN");
        platformList.add("掘金");
        return platformList;
    }


}
