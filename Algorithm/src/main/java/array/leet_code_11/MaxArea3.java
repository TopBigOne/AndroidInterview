package array.leet_code_11;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/15 23:21
 * @Desc :
 */
public class MaxArea3 {
    public int maxArea(int[] height) {
        int result = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            int dynamicArea = (right - left) * minHeight;
            result = Math.max(result, dynamicArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result;

    }

    public int maxArea2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            int dynamicArea = minHeight * (right - left);
            result = Math.max(result, dynamicArea);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
