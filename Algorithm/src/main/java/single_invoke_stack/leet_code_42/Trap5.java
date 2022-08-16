package single_invoke_stack.leet_code_42;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/6 10:39
 * @Desc :
 */
public class Trap5 {
    public int trap(int[] height) {
        int peakIndex = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > height[peakIndex]) {
                peakIndex = i;
            }
        }


        int water = 0;
        int leftMostBar = 0;
        // 从左往右
        for (int i = 0; i < peakIndex; i++) {
            if (height[i] > leftMostBar) {
                leftMostBar = height[i];
            } else {
                water += leftMostBar - height[i];
            }
        }

        int rightMostBar = 0;
        // 从右往左
        for (int i = height.length - 1; i > peakIndex; i--) {
            if (height[i] > rightMostBar) {
                rightMostBar = height[i];
            } else {
                water += rightMostBar - height[i];
            }

        }
        return water;


    }
}
