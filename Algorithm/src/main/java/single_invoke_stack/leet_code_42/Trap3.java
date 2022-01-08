package single_invoke_stack.leet_code_42;

/**
 * @author : dev
 * @version :
 * @Date :  2022/1/4 14:05
 * @Desc :  接雨水
 * <p>  https://leetcode-cn.com/problems/trapping-rain-water/submissions/
 * 字节：27次
 * 一姐的解法
 * https://www.youtube.com/watch?v=bu1quf2rOp8
 */
public class Trap3 {
    public int trap(int[] height) {
        int length = height.length;
        int peakIndex = 0;
        for (int i = 0; i < length; i++) {
            if (height[i] > height[peakIndex]) {
                peakIndex = i;
            }
        }
        int leftMostBar = 0;
        int water = 0;
        for (int i = 0; i < peakIndex; i++) {
            if (height[i] > leftMostBar) {
                leftMostBar = height[i];
            } else {
                water = water + leftMostBar - height[i];
            }
        }

        int rightMostBar = 0;
        for (int i = length - 1; i > peakIndex; i--) {
            if (height[i] > rightMostBar) {
                rightMostBar = height[i];
            } else {
                water = water + rightMostBar - height[i];
            }
        }
        return water;
    }

    public int trap2(int[] height) {
        int length = height.length;
        int peakIndex = 0;
        // step 1:
        for (int i = 0; i < length; i++) {
            if (height[i] > height[peakIndex]) {
                peakIndex = i;
            }
        }

        int water = 0;
        // step 2:
        int leftBar = 0;

        for (int i = 0; i < peakIndex; i++) {
            if (height[i] > leftBar) {
                leftBar = height[i];
            } else {
                // 这行代码没理解
                water = water + leftBar - height[i];
            }
        }

        // step 3:
        int rightBar = 0;
        for (int i = length - 1; i > peakIndex; i--) {
            if (height[i] > rightBar) {
                rightBar = height[i];
            } else {
                water = water + rightBar - height[i];
            }
        }
        return water;
    }

    /**
     * 接雨水，用挡板
     *
     * @param height
     * @return
     */
    public int trap3(int[] height) {
        int length = height.length;
        int water = 0;
        int peakIndex = 0;
        // step 1: find the max heigh index;
        for (int i = 0; i < length; i++) {
            if (height[i] > height[peakIndex]) {
                peakIndex = i;
            }
        }
        // step 2: calcute the left part.
        int leftMostBar = 0;
        for (int i = 0; i < peakIndex; i++) {
            if (height[i] > leftMostBar) {
                leftMostBar = height[i];
            } else {
                water = water + leftMostBar - height[i];
            }
        }
        // step 3: calcute the right part.
        int rightBar = 0;
        for (int i = length - 1; i > peakIndex; i--) {
            if (height[i] > rightBar) {
                rightBar = height[i];
            } else {
                water = water + rightBar - height[i];
            }
        }
        return water;

    }
}
