package dp.offer_66;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/16 15:57
 * @Desc :
 * 题解：https://leetcode.cn/problems/gou-jian-cheng-ji-shu-zu-lcof/solution/jian-zhi-offer-66-xianzuo-by-leetcode_xs-jyh9/
 */
public class ConstructArr2 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        System.err.println("raw data : " + Arrays.toString(a));
        ConstructArr2 constructArr = new ConstructArr2();
        int[] result = constructArr.constructArr(a);

        System.err.println("result   : " + Arrays.toString(result));
    }

    public int[] constructArr(int[] a) {
        int[] res = new int[a.length];
        int temp = 1;
        // 第一次遍历
        for (int i = 0; i < a.length; i++) {
            res[i] = temp;
            temp *= a[i];
        }
        System.err.println("第一次遍历 res : " + Arrays.toString(res));

        temp = 1;
        // 第二次遍历
        for (int i = a.length - 1; i >= 0; i--) {
            res[i] *= temp;
            temp *= a[i];
        }
        System.err.println("第二次遍历 res : " + Arrays.toString(res));
        return res;


    }
}
