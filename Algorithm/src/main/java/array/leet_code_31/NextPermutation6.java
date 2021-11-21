package array.leet_code_31;


/**
 * @author :  dev
 * @version :
 * @Date :   2021/7/16 11:31
 * @Url :https://leetcode-cn.com/problems/next-permutation/
 * @Level :    medium
 * @Desc : 下一个全排列
 * @Counter :
 * @Answer : https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-suan-fa-xiang-jie-si-lu-tui-dao-/
 */
public class NextPermutation6 extends Base {
    public void nextPermutation(int[] nums) {
        int len = 0;
        if (nums == null || (len = nums.length) == 0) {
            return;
        }
        int index = len - 2;
        // 1:倒序来看，后面以后小于前面的那一个值，直到条件不成立
        while (index > 0 && nums[index] > nums[index + 1]) {
            index--;
        }
        // 2:在[index+1,len-1] 中找到一个大于num[index]的值所对应的下标j
        if (index >= 0) {
            int j = binarySearch(nums, index + 1, len - 1, nums[index]);
            // i 下标的值与j下标的值做交换
            swap(nums, index, j);
        }

        // 3: 改[j,len-1]为升序
        doPartReverse(nums, index + 1, len - 1);
    }

    private void doPartReverse(int[] nums, int l, int r) {
        while (l<r){
            swap(nums,l++,r--);
        }
    }

    private int binarySearch(int[] nums, int l, int r, int target) {
        while (l<=r){
            int mid = (l+r)>>>1 ;
            int value = nums[mid];
            if(value<target){
                r = mid-1;
            }else {
                l = mid+1;
            }

        }
        return r;
    }


}
