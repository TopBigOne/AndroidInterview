package array.leet_code_287;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/12 22:46
 * @Url :
 * @Level :    medium
 * @Desc :
 * @Counter :
 * @Answer :https://leetcode-cn.com/problems/find-the-duplicate-number/solution/er-fen-fa-si-lu-ji-dai-ma-python-by-liweiwei1419/
 */
public class FindDuplicate2 {
    /**
     * 思考那边区间存在重复数是容易的，因为有抽屉原理做保证
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int left = 1;
        int right = len - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt += 1;
                }
            }

            // 根据抽屉原理，小于等于4 的个数如果严格大于4个，此时重复元素一定出现在[1...4]区间里
            if (cnt > mid) {
                // 重复元素位于区间[left...mid]
                right = mid;
            } else {
                // if 分析正确了以后，else 探索的区间就是if 的反面区间[mid+1...right]
                left = mid + 1;
            }

        }
        return left;

    }

    public int findDuplicate2(int[] nums) {
        int len = nums.length;
        int left = 1;
        int right = len - 1;

        // 在循环体内不断的排除元素
        while (left < right) {
            int mid = left + (right - left) / 2;
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt += 1;


                }
            }
            if (cnt > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }
        return left;

    }

    public int findDuplicate3(int[] nums) {
        int length = nums.length;
        int left = 1;
        int right = length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt += 1;
                }
            }

            if (cnt > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;

    }

    public int findDuplicate4(int[] nums) {
        int length = nums.length;
        int left = 1;
        int right = length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt += 1;
                }
            }

            if (cnt > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;

    }

    public int findDuplicate5(int[] nums) {
        int length = nums.length;
        int left = 1;
        int right = length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt += 1;
                }
            }

            if (cnt > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;

    }


}
