package sliding_window.offer_57;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/17 16:17
 * @Desc : 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * https://leetcode.cn/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 *
 * <p>
 * 数学题解：https://leetcode.cn/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/solution/xiang-jie-hua-dong-chuang-kou-fa-qiu-gen-fa-jian-g/
 */
public class FindContinuousSequence {
    public static void main(String[] args) {
        FindContinuousSequence findContinuousSequence = new FindContinuousSequence();
        int[][] result = findContinuousSequence.findContinuousSequence4(15);
        System.err.println("result : " + Arrays.deepToString(result));
    }

    /**
     * @param target 15
     * @return [[1, 2, 3, 4, 5], [4, 5, 6], [7, 8]]
     */
    public int[][] findContinuousSequence(int target) {
        // 滑动窗口的左边界
        int left = 1;
        // 滑动窗口的右边界
        int right = 1;
        // 滑动窗口中数字的和
        int sum = 0;
        List<int[]> res = new ArrayList<>();

        //  由于序列中至少要包含 2 个数字，因此左边界增加到 target / 2 为止
        while (left <= target / 2) {
            if (sum < target) {
                sum += right;
                // 右边界向右移动
                right++;
            } else if (sum > target) {
                sum -= left;
                // 左边界向右移动
                left++;
            } else {
                // 相等
                // 记录结果
                int[] indexArray = new int[right - left];
                for (int index = left; index < right; index++) {
                    indexArray[index - left] = index;
                }
                res.add(indexArray);
                // 左边界向右移动
                sum -= left;
                left++;
            }
        }

        return res.toArray(new int[res.size()][]);

    }


    public int[][] findContinuousSequence2(int target) {
        int left = 1;
        int right = 1;
        int mid = target >> 1;
        int sum = 0;
        List<int[]> res = new ArrayList<>();

        while (left <= mid) {
            if (sum < target) {
                sum += right;
                right++;
            } else if (sum > target) {
                sum -= left;
                left++;
            } else {
                // 相等
                int[] indexArray = new int[right - left];
                for (int i = left; i < right; i++) {
                    indexArray[i - left] = i;
                }

                res.add(indexArray);
                //
                sum -= left;
                left++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public int[][] findContinuousSequence3(int target) {
        int left = 1;
        int right = 1;
        int mid = target >> 1;
        int sum = 0;
        List<int[]> res = new ArrayList<>();
        while (left <= mid) {
            if (sum < target) {
                sum += right;
                right++;
            } else if (sum > target) {
                sum -= left;
                left++;
            } else {
                // 相等，对结果做一下统计
                int[] tempArray = new int[right - left];
                for (int i = left; i < right; i++) {
                    tempArray[i - left] = i;
                }
                res.add(tempArray);

                sum -= left;
                left++;
            }
        }
        return res.toArray(new int[res.size()][]);

    }

    public int[][] findContinuousSequence4(int target) {
        int left = 1;
        int right = 1;
        int mid = target >>> 1;
        int sum = 0;
        List<int[]> res = new ArrayList<>();
        while (left <= mid) {
            if (sum < target) {
                sum += right;
                right++;
            } else if (sum > target) {
                sum -= left;
                left++;
            } else {
                int[] arr = new int[right - left];
                for (int i = left; i < right; i++) {
                    arr[i - left] = i;
                }
                res.add(arr);

                sum -= left;
                left++;
            }
        }

        return res.toArray(new int[res.size()][]);


    }
}
