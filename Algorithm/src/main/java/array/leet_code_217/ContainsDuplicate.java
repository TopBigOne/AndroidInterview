package array.leet_code_217;

import java.util.*;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/2 23:14
 * @Url :
 * @Level :  easy
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class ContainsDuplicate {
    /**
     * 超时了。。。。。。
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (list.contains(num)) {
                return true;
            }
            list.add(num);
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;

    }
}
