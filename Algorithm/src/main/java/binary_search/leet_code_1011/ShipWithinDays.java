package binary_search.leet_code_1011;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/8 18:02
 * @Desc : 在 D 天内送达包裹的能力 ：https://leetcode.cn/problems/capacity-to-ship-packages-within-d-days/
 *
 * 题解：https://leetcode.cn/problems/capacity-to-ship-packages-within-d-days/solution/java-er-fen-cha-zhao-zhu-shi-ban-qing-xi-7f7b/
 */
public class ShipWithinDays {
    //判断最低运载能力为H的时候能否在D天内送达
    public boolean verification(int[] weights, int D, int H) {
        //天数计数，初始化为1
        int count = 1;
        //每天的包裹总量
        int singleWeight = 0;
        for (int weight : weights) {
            //累计包裹总量
            singleWeight += weight;
            //如果累计包裹总量singleWeight > H，天数+1
            if (singleWeight > H) {
                ++count;
                singleWeight = weight;
            }
            //如果当前累计的天数count > D，说明当前H不满足条件，返回false
            if (count > D) {
                return false;
            }
        }
        //说明当前H满足条件，返回true
        return true;

    }

    //从数组的最大元素开始遍历判断值i是否满足verification
    public int shipWithinDays(int[] weights, int D) {
        //二分查找 r = 数组的总和， l = 数组的最大值
        int r = Arrays.stream(weights).sum();
        int l = Arrays.stream(weights).max().getAsInt();
        //l < r
        while (l < r) {
            //取中间值
            int mid = (l + r) >> 1;
            //如果mid满足verification，则逼近右指针
            if (verification(weights, D, mid)) {
                //包括mid
                r = mid;
            } else {
                //逼近左指针，mid + 1
                l = mid + 1;
            }
        }
        //返回当前l就是最小的满足条件的值，即最低运载能力
        return l;
    }

}
