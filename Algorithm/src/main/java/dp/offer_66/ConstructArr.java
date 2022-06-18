package dp.offer_66;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/16 15:46
 * @Desc :构建乘积数组
 * https://leetcode.cn/problems/gou-jian-cheng-ji-shu-zu-lcof/solution/mian-shi-ti-66-gou-jian-cheng-ji-shu-zu-biao-ge-fe/
 */
public class ConstructArr {
    public static void main(String[] args) {
        int []a = {1, 2, 3, 4, 5};
        ConstructArr constructArr = new ConstructArr();
        int[] result = constructArr.constructArr(a);
        System.err.println(Arrays.toString(result));

    }

    public int[] constructArr(int[] a) {
        int len;
        if (a == null || (len = a.length) == 0) {
            return a;
        }

        int[] left = new int[len];
        int[] right = new int[len];

        left[0] = 1;
        right[len - 1] = 1;

        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * a[i - 1];
        }
        System.err.println("left  : "+Arrays.toString(left));

        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] * a[i + 1];
        }
        System.err.println("right : "+Arrays.toString(right));

        int[] ans = new int[len];

        for (int i = 0; i < len; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }
}
