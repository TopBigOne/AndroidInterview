package sort.offer_61;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/7 19:39
 * @Desc :判断给出的5个数是否可以连续，其中0可以当作任意数
 */
public class IsStraight {
    public static void main(String[] args) {
        int[] nums = {0, 0, 2, 2, 5};
        // int [] nums = {1,2,3,4,5};
        IsStraight isStraight = new IsStraight();
        boolean result = isStraight.isStraight(nums);

        System.err.println("result : " + result);
    }

    public boolean isStraight(int[] nums) {
        boolean[] m = new boolean[15];
        int minValue = 14;
        int maxValue = 0;
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            // 若有重复，提前返回 false
            if (m[num]) {
                return false;
            }

            m[num] = true;

            minValue = Math.min(num, minValue);
            maxValue = Math.max(num, maxValue);
        }

        return maxValue - minValue + 1 <= 5;
    }
}
