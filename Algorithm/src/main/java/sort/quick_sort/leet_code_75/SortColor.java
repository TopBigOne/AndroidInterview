package sort.quick_sort.leet_code_75;



/**
 * @author :  dev
 * @version :
 * @Date :   2021/11/27 21:48
 * @Url :  https://leetcode-cn.com/problems/sort-colors/
 * @Level :    medium
 * @Desc :
 * @Counter :
 * @Answer : https://leetcode-cn.com/problems/sort-colors/solution/kuai-su-pai-xu-partition-guo-cheng-she-ji-xun-huan/
 * <p>
 * 言简意赅的题解：https://leetcode-cn.com/problems/sort-colors/solution/fei-chang-jian-ji-de-xie-fa-by-tchj-z9fp/
 */
public class SortColor {
    public void sortColors(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return;
        }

        int zero = 0;
        int two = len;
        int i = 0;


        while (i < two) {
            if (nums[i] == 0) {
                swap(nums, i, zero);
                zero++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                two--;
                swap(nums, i, two);
            }
        }
    }

    private void swap( int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public void sortColors2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int i = 0;
        while (i <= right) {
            if (nums[i] == 0) {
                swap(nums, i++, left++);
                continue;
            }
            if (nums[i] == 2) {
                swap(nums, i, right--);
                continue;
            }
            i++;
        }
    }

}
