package binary_search.leet_code_35;

/**
 * @author : dev
 * @version :
 * @Date :  9/14/21 8:47 PM
 * @Desc :  https://leetcode-cn.com/problems/search-insert-position/
 * <p>
 * 题解：https://leetcode-cn.com/problems/search-insert-position/solution/te-bie-hao-yong-de-er-fen-cha-fa-fa-mo-ban-python-/
 */
public class SearchInsert {
    public static void main(String[] args) {
        int[] num = {1, 3, 5, 6};
        int target = 7;
        SearchInsert searchInsert = new SearchInsert();
        int index = searchInsert.searchInsert2(num, target);
        System.err.println("index : " + index);

    }

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

    public int searchInsert2(int[] nums, int target) {

        int len = nums.length;
        if (nums[len - 1] < target) {
            return len;
        }

        int low = 0;
        int height = nums.length - 1;
        while (low < height) {
            int mid = (height + low) >>> 1;

            int midValue = nums[mid];

            if ((midValue < target)) {
                low = mid + 1;
            } else {
                height = mid;
            }
        }

        return low;

    }
}
