package array.leet_code_350;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/31 11:53
 * @Url : https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/solution/
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class Intersect {
    public static void main(String[] args) {
        int[] n1 = {4, 9, 5};
        int[] n2 = {9, 4, 9, 8, 4};

        Intersect intersect = new Intersect();
        int[] result = intersect.intersect(n1, n2);
        System.out.println(Arrays.toString(result));

    }

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        //先遍历第一个数组，并初始化map
        for (int j : nums1) {
            if (map.containsKey(j))
                map.put(j, map.get(j) + 1);
            else
                map.put(j, 1);
        }

        //再遍历第二个数组，将于map中找到的key放入list中
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int k : nums2) {
            if (map.containsKey(k) && map.get(k) > 0) {
                list.add(k); //添加到list中
                map.put(k, map.get(k) - 1);
            }
        }

        //最后，将list中的值放入数组中
        int count = list.size();
        int[] aux = new int[count];
        for (int i = 0; i < count; i++) {
            aux[i] = list.poll();
        }
        return aux;


    }
}
