package array.leet_code_11;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/19 19:16
 * @Desc :
 */
public class MaxArea2 {
    public int maxArea(int[] height) {
        int result = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {

            int minHeight = Math.min(height[left], height[right]);
            int dynamicArea = (right - left) * minHeight;

            result = Math.max(result, dynamicArea);
            // 开始移动柱子了
            if (height[left] <height[right]) {
                left++;

            } else {
                right--;
            }
        }

        return result;

    }
}
