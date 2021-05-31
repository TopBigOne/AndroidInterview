package array.leet_code_215;

import array.leet_code_215.base.BaseFun;

import java.util.Arrays;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/5/31 15:15
 * @Url :
 * @Desc :
 * @Counter :
 * @Answer : 伟伟：https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/partitionfen-er-zhi-zhi-you-xian-dui-lie-java-dai-/
 */
public class FindKthLargest2  extends BaseFun {
    /**
     * 借助 partition 操作，定位到最终
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLarge(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        // 转换一下，第k大元素的索引是len-k;
        int target = len - k;
        while (true) {
            //  这是一个排序操作；
            int index = partition(nums, left, right);
            System.out.println("index： " + index);
            if (index == target) {
                System.out.println("last arr ： " + Arrays.toString(nums));
                return nums[index];
            } else if (index < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
    }

    /**
     * 在数组nums 的子区间，[left,right] 执行partition 操作，返回nums[left] 排序以后，应该在的位置
     * 在遍历过程中，保持循环不变量的语义；
     * <p>
     * 1，[left+1,j] <nums[left]
     * 2, (j,i] >=nums[left]
     *
     * @param nums  数组
     * @param left  左
     * @param right 右
     * @return 分割
     */
    public int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        System.out.println("pivot :"+pivot);
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            int currValue = nums[i];
            if (currValue < pivot) {
                // 小于pivot 的元素都被交换到前面
                j++;
                swap(nums, j, i);
            }
        }
        print("currValue < pivot 遍历结果：",nums);
        // 之前遍历的过程中，满足[left + 1, j]< pivot,并且（j,i] >=pivot
        swap(nums, j, left);
        return j;
    }

}
