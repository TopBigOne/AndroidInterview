package array.leet_code_11;

import java.util.Arrays;

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

    /**
     * 前提 1 : 想一想：矩形的面积公式： 面积=长x宽(高),本题，我倾向于用高度(h)表示；
     *    即： s = a*h; a：表示宽度， h:表示高度
     *    想要s最大的话，a,b的值最大就行；ok，这是前提；
     * 前提 2 : 双指针 left: 左边界； right : 右边界；
     * 前提 3: 一个由木板组装的木桶，能装多少水取决于：最短的那块木板；
     * 映射到本题： a(左右的长度)= right - left;
     *            b= 数组height中下标所对应的值；
     * 动态变化，left ++ 和 right-- ;
     * 在left ++ 和 right--变化中，我们可以得到:
     * 长度a = right-left;
     * 高度h ：height[left],height[right],
     * 当然，我们取最小的那个高度: minHeight = Math.min(height[left],height[right]),你懂得；
     * 同时，在 left++ 和 right-- 后，a = right - left ,是一个定值；
     * 所以这时，我们就得到一个动态的面积： dynamicArea = a * minHeight,并保存起来；
     * 下面我们来 讨论一下 left 和 right 的变化；
     * 即： 何时left++？，何时 right--？;
     * 当然，咱们还是 要映射一下，left和right 其实是数组的下标；我们真实聊的是这个小标left/right
     * 看数组 height = [1,8,6,2,5,4,8,3,7]  ，length= 9；
     * 假设left = 0，right = 8,
     * 所对应的高度，height[left]=1 和 height[right]=7
     * 动态面积 s = (right-left)*height[left] = (8-0)*1 = 8;
     * case 1 : 假如 height[left] < height[right] 即，左边低，右边高；
     *        这时，我们移动右边的柱子：right-- = 6，得到height[6] = 3,
     *        但是，但是，但是，最短的柱子，还是height[left] = height[0] = 1;
     *        所以啊，我们得到的面积一定不会大于height[left] = height[0] = 1的面积；
     *        这样的right--,毫无意义；
     *case 2 : 假如 height[left] < height[right]即，左边低，右边高；
     *        我们移动左边的柱子，left++；height[1] = 8;
     *        得minHeight = min(height[1],height[right]=7)
     *        得minHeight = min(8,7)
     *        的面试 s = (right-left)*得minHeight = (8-1)*7 = 49;
     *        这下就对了，
     *
     * 可以得出一个规律，在left++ ，和 right--的过程中，
     * 他们所对应的height[left]和height[right],who最小，就移动who
     * 伪代码：
     *  if(height[left] < height[right]){
     *      left++
     *  }else{
     *      right--;
     *  }
     *  因为这样的移动方式，我们才有可能找到区别于上次面积变化，增加，或者减少，从而找到最大值；

     * @param height
     * @return
     */
    public int maxArea4(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int area = 0;
        while (left < right) {

            // 最小面积求法
            int minHeight = Math.min(height[left], height[right]);

            System.out.println("the original data is " + Arrays.toString(height));
            System.out.println("the left index is ：" + left + " , the right  index is  ：" + right);
            System.out.println("the left value is ：" + height[left] + " , the right value is : " + height[right]);
            System.out.println("the final min height ：" + minHeight);
            int tempArea = minHeight * (right - left);
            System.out.println("the temp area is : " + minHeight + " * (" + right + "-" + left + ") = " + tempArea);
            System.out.println("-------------------------------------------------------------------|");


            area = Math.max(area, tempArea);


            // 指针每一次移动，都意味着排除掉了一个柱子。
            if (height[left] < height[right]) {
                // 左边的高度小于右边的高度，
                // 左边的指针++；
                left++;
            } else {
                // 反之：右边的柱子--；
                right--;
            }

        }

        return area;


    }


}
