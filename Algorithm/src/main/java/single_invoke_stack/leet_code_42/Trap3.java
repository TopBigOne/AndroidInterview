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
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Trap3 trap = new Trap3();
        int result = trap.trap(height);
        System.out.println("result : " + result);
    }

    public int trap(int[] height) {
        int length = height.length;
        int peakIndex = 0;
        for (int i = 0; i < length; i++) {
            if (height[i] > height[peakIndex]) {
                peakIndex = i;
            }
        }
        System.err.println("peakIndex : " + peakIndex);

        int water = 0;
        int leftMostBar = 0;
        for (int i = 0; i < peakIndex; i++) {
            // 更新
            if (height[i] > leftMostBar) {
                leftMostBar = height[i];
            } else {
                water += leftMostBar - height[i];
            }
        }

        int rightMostBar = 0;

        for (int i = length - 1; i > peakIndex; i--) {
            if (height[i] > rightMostBar) {
                rightMostBar = height[i];
            } else {
                water += rightMostBar - height[i];
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
        // step 1: find the max height index;
        for (int i = 0; i < length; i++) {
            if (height[i] > height[peakIndex]) {
                peakIndex = i;
            }
        }
        // step 2: calculate the left part.
        int leftMostBar = 0;
        for (int i = 0; i < peakIndex; i++) {
            if (height[i] > leftMostBar) {
                leftMostBar = height[i];
            } else {
                int leftTemp = leftMostBar - height[i];
                System.out.println("leftTemp : " + leftTemp);
                water += (leftMostBar - height[i]);
            }
        }
        // step 3: calculate the right part.
        int rightBar = 0;
        for (int i = length - 1; i > peakIndex; i--) {
            if (height[i] > rightBar) {
                rightBar = height[i];
            } else {
                int rightTemp = rightBar - height[i];
                System.out.println("rightTemp : " + rightTemp);
                water = water + rightTemp;
            }
        }
        return water;

    }
}
