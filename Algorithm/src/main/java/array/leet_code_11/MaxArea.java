package array.leet_code_11;

/**
 * @author : dev
 * @version :
 * @Date :  2021/4/21 21:17
 * @Desc :  盛最多水的容器：https://leetcode-cn.com/problems/container-with-most-water/
 * <p>
 * 题解：https://leetcode-cn.com/problems/container-with-most-water/solution/on-shuang-zhi-zhen-jie-fa-li-jie-zheng-que-xing-tu/
 * <p>
 * <p>
 * 缩减搜索空间
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int res = 0;
        while (i < j) {
            res = height[i] < height[j] ? Math.max(res, (j - i) * height[i++]) : Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }

    public int maxArea2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int area = Integer.MIN_VALUE;
        while (left < right) {
            int temp = Math.min(height[left], height[right]) * (right - left);
            area = Math.max(area, temp);
            // 采用短边收缩
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return area;
    }

    public int maxArea3(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int area = Integer.MIN_VALUE;
        while (left < right) {
            int temp = Math.min(height[left],height[right])*(right-left);
            area = Math.max(area, temp);
            // 采用短边收缩
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return area;
    }

    public int maxArea4(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int area = 0;
        while (left < right) {
            area = Math.max(area, Math.min(height[left], height[right] )*(right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }

        }
        return area;


    }


}
