package dp.leet_code_349;

import java.util.*;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/11/25 22:49
 * @Url :
 * @Level :  easy
 * @Desc :
 * @Counter :
 * @Answer :
 * <p>
 * 题解：https://leetcode-cn.com/problems/intersection-of-two-arrays/solution/duo-chong-jie-fa-jie-jue-349-liang-ge-shu-zu-de-ji/
 */
public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, i);
        }
        List<Integer> res = new ArrayList<>();
        for (int i : nums2) {
            if (map.containsKey(i)) {
                if (!res.contains(map.get(i))) {
                    res.add(i);
                }
            }
        }
        return res.stream().mapToInt(value -> value).toArray();
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        int m = nums1.length;
        int n = nums2.length;

        List<Integer> mList = new ArrayList<>();

        while (i < m && j < n) {
            int topValue = nums1[i];
            int downValue = nums2[j];

            if (topValue < downValue) {
                i++;
            } else if (topValue > downValue) {
                j++;
            } else if (topValue == downValue) {
                if (!mList.contains(topValue)) {
                    mList.add(topValue);
                }
                i++;
                j++;
            }
        }
        return mList.stream().mapToInt(value -> value).toArray();
    }

    public int[] intersection3(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int num1 : nums1) {
            set.add(num1);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums2.length - 1; i++) {

            int value = nums2[i];
            if (!set.add(value) && !res.contains(value)) {
                res.add(value);
            }
        }

        return res.stream().mapToInt(Integer::valueOf).toArray();


    }
}
