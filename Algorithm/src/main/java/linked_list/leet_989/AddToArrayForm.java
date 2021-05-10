package linked_list.leet_989;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  2021/3/23 19:35
 * @Desc : 989:数组形式的整数相加 https://leetcode-cn.com/problems/add-to-array-form-of-integer/solution/
 * <p>
 * 题解：https://leetcode-cn.com/problems/add-to-array-form-of-integer/solution/989-ji-zhu-zhe-ge-jia-fa-mo-ban-miao-sha-8y9r/
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,2,0,0], K = 34
 * 输出：[1,2,3,4]
 * 解释：1200 + 34 = 1234
 * 示例 2：
 * <p>
 * 输入：A = [2,7,4], K = 181
 * 输出：[4,5,5]
 * 解释：274 + 181 = 455
 * 示例 3：
 * <p>
 * 输入：A = [2,1,5], K = 806
 * 输出：[1,0,2,1]
 * 解释：215 + 806 = 1021
 * 示例 4：
 * <p>
 * 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * 输出：[1,0,0,0,0,0,0,0,0,0,0]
 * 解释：9999999999 + 1 = 10000000000
 */
public class AddToArrayForm {
    public List<Integer> addToArrayFrom(int[] A, int K) {
        List<Integer> res = new ArrayList<>();
        int i = A.length - 1;
        int sum = 0;
        int carry = 0;
        // 循环条件：两个数，有一个没完
        while (i >= 0 || K != 0) {
            int x = i >= 0 ? A[i] : 0;
            int y = K != 0 ? K % 10 : 0;

            sum = x + y + carry;
            carry = sum / 10;
            K=K/10;
            i--;
            res.add(0, sum % 10);
        }

        if (carry != 0) {
            res.add(0, carry);
        }

        return res;
        // jAR

    }

}
