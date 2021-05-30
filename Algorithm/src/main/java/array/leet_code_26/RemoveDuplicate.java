package array.leet_code_26;

/**
 * @author : dev
 * @version :
 * @Date :  5/30/21 3:01 PM
 * @Desc : leetcode 26 删除有序数组的重复项 https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/solution/
 * <p>
 * <p>
 * <p>
 * <p>
 * 题解：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/solution/shuang-zhi-zhen-shan-chu-zhong-fu-xiang-dai-you-hu/
 */
public class RemoveDuplicate {
    /**
     * 1： 首先注意：数组是有序的，那么重复的元素一定相邻；
     * 2： 要删除重复元素，实际上，就是将不重复的元素移到数组的左侧；
     * ------------------------------------------------------------
     * 所以用2 个指针，一个是 p，一个是q，流程是这样：
     * 1： 比较 p 和 q 位置的元素是否相等；
     * 1-1： 如果相等，q 后移一位；
     * 1-2： 如果不相等，将 q 位置的元素复制到 p+1 位置，p 后移1位，q后移 1 位；
     * 2： 重复上述操作，直到 q 等于数组的长度
     *
     * @param nums
     * @return
     */
    public int removeDuplicate(int[] nums) {
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return 0;
        }
        int p = 0;
        int q = 1;
        while (q < length) {
            if (nums[p] != nums[q]) {
                nums[p + 1] = nums[q];
                p++;
            }
            q++;
        }
        return p + 1;
    }

    public int removeDuplicate2(int[] nums) {
        int length;
        // base corner
        if (nums == null || (length = nums.length) == 0) {
            return 0;
        }
        int p = 0;
        int q = 1;
        while (q < length) {
            if (nums[p] == nums[q]) {
                // q 右移动一位
                q++;
            } else {
                // 不相等,p 的下一个位置的值，就等于当前 q 位置的值；
                nums[p + 1] = nums[q];
                p++;
            }
        }
        return p + 1;
    }

    public int removeDuplicate3(int[] nums) {
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return 0;
        }
        int p = 0;
        int q = 1;
        while (q < length) {
            if (nums[p] != nums[q]) {
                nums[p + 1] = nums[q];
                p++;
            }
            q++;
        }
        return p + 1;
    }

    public int removeDuplicate4(int[] nums) {
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return 0;
        }
        int p = 0;
        int q = 1;
        while (q < length) {
            if (nums[p] != nums[q]) {
                nums[p + 1] = nums[q];
                p++;

            }
            q++;
        }

        return p + 1;
    }
}


