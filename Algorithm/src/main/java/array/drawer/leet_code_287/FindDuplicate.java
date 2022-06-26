package array.drawer.leet_code_287;

import java.util.HashSet;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/12 20:55
 * @Url :
 * @Level :     medium
 * @Desc :287. 寻找重复数
 * @Counter :
 * @Answer :https://leetcode-cn.com/problems/find-the-duplicate-number/solution/er-fen-fa-si-lu-ji-dai-ma-python-by-liweiwei1419/
 *
 * 题解：
 * https://leetcode.cn/problems/find-the-duplicate-number/solution/er-fen-fa-si-lu-ji-dai-ma-python-by-liweiwei1419/
 */
public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        int result = -1;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                result = num;
                break;
            }
        }
        return result;
    }
}
