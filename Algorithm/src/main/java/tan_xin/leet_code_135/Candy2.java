package tan_xin.leet_code_135;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/19 11:12
 * @Desc :
 */
public class Candy2 {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] candies = new int[len];
        // step1 : 每人 都发一颗
        Arrays.fill(candies, 1);
        // step2: 从左往右遍历
        for (int i = 0; i < len - 1; i++) {
            if (ratings[i + 1] > ratings[i]) {
                candies[i + 1] = candies[i] + 1;
            }
        }

        // step 3: 从右往左遍历
        for (int i = len - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i] && candies[i - 1] <= candies[i]) {
                candies[i - 1] = candies[i] + 1;
            }

        }

        // step 4: 再次做一个统计

        int minSum = 0;
        for (int candy : candies) {
            minSum += candy;
        }
        return minSum;

    }
}
