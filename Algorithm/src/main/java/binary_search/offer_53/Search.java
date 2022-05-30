package binary_search.offer_53;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/26 17:35
 * @Desc :
 * <p>
 * 题解：https://leetcode.cn/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/solution/gong-shui-san-xie-liang-chong-er-fen-ton-3epx/
 */
public class Search {
    public static void main(String[] args) {

        int[] nums = {5, 7, 7, 8, 8, 8, 8, 8, 8, 8, 10};

        Search search = new Search();

        int count = search.search2(nums, 8);
        System.err.println("nums : "+ Arrays.toString(nums));
        System.err.println("count : "+ count);

    }

    public int search(int[] nums, int t) {
        int n = nums.length;
        int l = 0, r = n - 1;
        // 找最右边的哪一个下标
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= t) {
                l = mid;
            } else {

                r = mid - 1;
            }
        }

        System.out.println(" r index is : " + r);
        int ans = 0;
        while (r >= 0 && nums[r] == t) {
            r--;
            ans++;
        }
        return ans;
    }

    public int search2(int[] nums, int t) {
        int length = nums.length;
        int l = 0;
        int r = length - 1;
        while (l < r) {
            int mid = (l + r + 1) >>> 1;
            // l point 不断的向右边移动
            if (nums[mid] <= t) {
                l = mid;
            } else {
                // r point 不断的向右边移动
                r = mid - 1;
            }
        }

        System.err.println(" the final r index : " + r);

        int res = 0;
        while (r >= 0 && nums[r] == t) {

            res++;
            r--;
        }
        return res;


    }
}
