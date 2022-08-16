package single_invoke_stack.leet_code_42;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/15 23:45
 * @Desc :
 */
public class Trap6 {
    public int trap(int[] height) {
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
                water += (leftMostBar - height[i]);
            }
        }
        int rightMostBar = 0;
        for (int i = length - 1; i > peakIndex; i--) {
            if (height[i] > rightMostBar) {
                rightMostBar = height[i];
            } else {
                int rightTemp = rightMostBar - height[i];
                water += (rightMostBar - height[i]);
            }

        }
        return water;


    }
}
