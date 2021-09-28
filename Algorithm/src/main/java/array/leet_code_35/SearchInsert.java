package array.leet_code_35;

/**
 * @author : dev
 * @version :
 * @Date :  9/14/21 8:47 PM
 * @Desc :  https://leetcode-cn.com/problems/search-insert-position/
 * <p>
 * 题解：https://leetcode-cn.com/problems/search-insert-position/solution/te-bie-hao-yong-de-er-fen-cha-fa-fa-mo-ban-python-/
 */
public class SearchInsert {

    public int searchInsert(int[] nums, int target) {

        int len = nums.length;
        if (nums[len - 1] < target) {
            return len;
        }
        int low = 0;
        int hight = len - 1;
        while (low < hight) {
            int mid = (hight + low) >> 1;
            int curValue = nums[mid];

            if (curValue < target) {
                // 下一轮搜索区间是[mid+1,right]
                low = mid + 1;

            } else {
                // 下一轮搜索区间[left,mid]
                hight = mid;
            }
        }
        return low;

    }
}
