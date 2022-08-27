package math.leet_code_421;

import java.util.HashSet;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/15 18:54
 * @Desc :
 */
public class FindMaximumXOR2 {
    public int findMaximumXOR(int[] nums) {
        int res = 0;
        int mask = 0;
        for (int i = 30; i >= 0; i--) {
            mask = mask | (1 << i);
            HashSet<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num & mask);
            }

            int temp = res | (1 << i);
            for (Integer preFix : set) {
                if (set.contains(preFix ^ temp)) {
                    res = temp;
                    break;
                }
            }

        }
        return res;

    }
}
