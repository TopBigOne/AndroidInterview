package com.android.base.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/3/15 16:35
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class RemoveData {
    public static void main(String[] args) {
        RemoveData removeData = new RemoveData();
        List<Integer>  list=  removeData.init();
        for (int i = 0; i < 100; i++) {
            removeData.test(list);
        }
    }

    private List<Integer>  init() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        return list;


    }

    public void test(List<Integer> list) {

        list.add(0, list.remove(9));

        System.out.println("result :"+list);

    }
}
