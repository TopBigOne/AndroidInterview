package single_invoke_stack.leet_code_42;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/1/6 15:17
 * @Url :  https://leetcode-cn.com/problems/trapping-rain-water/submissions/
 * @Level :     hard
 * @Desc :
 * @Counter :27
 * @Answer :
 */
public class Trap4 {
    public int trap(int[] height) {
        int length = height.length;
        int water = 0;
        int peekIndex = 0;
        // step 1: find the max height index;
        for (int i = 0; i < length; i++) {
            if (height[i] > height[peekIndex]) {
                peekIndex = i;
            }
        }
        // step 2 : calculate the left part
        int leftMostBar = 0;
        for (int i = 0; i < peekIndex; i++) {
            if (height[i] > leftMostBar) {
                leftMostBar = height[i];
            } else {
                water = water + leftMostBar - height[i];
            }
        }
        // step 3 : calculate the right part
        int rightBar = 0;
        for (int index = length - 1; index > peekIndex; index--) {
            if (height[index] > rightBar) {
                rightBar = height[index];
            } else {
                water = water + rightBar - height[index];
            }

        }
        return water;

    }

    public int trap2(int[] height) {
        int result = 0;
        int peekIndex = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > height[peekIndex]) {
                peekIndex = i;
            }
        }

        int leftMostBar = 0;
        for (int i = 0; i < peekIndex; i++) {
            if (height[i] > leftMostBar) {
                leftMostBar = height[i];
            } else {
                result = result + leftMostBar - height[i];
            }
        }

        int rightMostBar = 0;
        for (int index = height.length - 1; index > peekIndex; index--) {
            if (height[index] > rightMostBar) {
                rightMostBar = height[index];
            } else {
                result = result + rightMostBar - height[index];
            }

        }
        return result;


    }

}
