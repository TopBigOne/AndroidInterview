package tan_xin.leet_code_135;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  6/9/21 11:19 PM
 * @Desc : leet code 135 : 分发糖果：字节：17 次：https://leetcode-cn.com/problems/candy/
 * <p>
 * 题解 :https://leetcode-cn.com/problems/candy/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-31/
 * <p>
 * 视频：https://www.youtube.com/watch?v=QzPWc0ilEek
 */
public class Candy {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        //step1: 每人发一个糖
        Arrays.fill(candies, 1);
        //step2: 正着遍历
        for (int i = 0; i < n - 1; i++) {
            //当前小朋友的 rating 比后一个小朋友的小,后一个小朋友的糖是当前小朋友的糖加 1。
            if (ratings[i + 1] > ratings[i]) {
                candies[i + 1] = candies[i] + 1;
            }
        }

        //step 3: 倒着遍历
        //下标顺序就变成了 i i-1 i-2 i-3 ... 0
        //当前就是第 i 个，后一个就是第 i - 1 个
        for (int i = n - 1; i > 0; i--) {
            //ratings[i] < ratings[i - 1]: 当前小朋友的 rating 比后一个小朋友的小
            // candies[i - 1] <= candies[i] :后一个小朋友的糖果树没有前一个的多，就更新后一个等于前一个加 1
            if (ratings[i - 1] > ratings[i] && candies[i - 1] <= candies[i]) {
                candies[i - 1] = candies[i] + 1;
            }
        }

        //计算糖果总和
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += candies[i];
        }
        return sum;
    }
}


