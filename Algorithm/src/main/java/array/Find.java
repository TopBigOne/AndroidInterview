package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/8/12 18:57
 * @Url :  https://mp.weixin.qq.com/s/KpQ0LWY5QUcRZN6PYfO3DA
 * @Level :    medium
 * @Desc :  求数组中比左边元素都大同时比右边元素都小的元素，返回这些元素的索引
 * <p>
 * 要求时间复杂度
 * <p>
 * 输入：[2, 3, 1, 8, 9, 20, 12]
 * 输出：3, 4
 * 解释：数组中 8, 9 满足题目要求，他们的索引分别是 3、4
 * @Counter :
 * @Answer :
 */
public class Find {
    public static void main(String[] args) {
        int arr [] = {2, 3, 1, 8, 9, 20, 12};
        Find find = new Find();
        int[] ints = find.find(arr);
        System.out.println(Arrays.toString(ints));


    }
    public int[] find(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        int[] leftMax = new int[n];
        Arrays.fill(leftMax, Integer.MIN_VALUE);
        int[] rightMin = new int[n];
        Arrays.fill(rightMin, Integer.MIN_VALUE);


        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], nums[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], nums[i + 1]);
        }
        for (int i = 0; i < n; i++) {
            if (leftMax[i] < nums[i] && nums[i] < rightMin[i]) {
                res.add(i);
            }
        }

        return res.stream().mapToInt(new ToIntFunction<Integer>() {
            @Override
            public int applyAsInt(Integer value) {
                return value;
            }
        }).toArray();

    }
}
