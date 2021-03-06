package dp.offer_60;

import java.util.Arrays;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/6/16 18:12
 * @Url :  https://leetcode.cn/problems/nge-tou-zi-de-dian-shu-lcof/submissions/
 * @Level :    medium
 * @Desc :
 * @Counter :
 * @Answer : é¢è§£ï¼https://leetcode.cn/problems/nge-tou-zi-de-dian-shu-lcof/solution/zi-jie-ti-ku-jian-60-zhong-deng-nge-tou-lni20/
 */
public class DicesProbability {
    public static void main(String[] args) {
        DicesProbability dicesProbability = new DicesProbability();
        double[] result = dicesProbability.twoSum(3);
        System.err.println("result : " + Arrays.toString(result));
    }

    public double[] twoSum(int n) {
        int[][] dp = new int[n + 1][6 * n + 1];
        for (int j = 1; j <= 6; j++) {
            dp[1][j] = 1;
        }
        System.err.println("base info : ");
        System.err.println("dp row    : " + dp.length);
        System.err.println("dp column : " + dp[0].length);
        System.err.println("start main logic.");
        System.err.println(" ");
        System.err.println(" ");

        for (int i = 2; i <= n; i++) {
            int endDot = i * 6;
            System.err.println("ð¹ð¹ð¹ð¹ð¹ð¹========================================> endDot: " + endDot);
            for (int startDot = i; startDot <= endDot; startDot++) {

                System.err.println("å¼å§ç¬¬ä¸å± ï¼ startDot ï¼"+startDot);
                for (int k = 1; k <= 6 && k <= startDot; k++) {
                    if (startDot - k <= 0) {
                        break;
                    }
                    dp[i][startDot] = dp[i][startDot] + dp[i - 1][startDot - k];
                    System.err.println(k + " : |---> " + i + "æéª°å­ï¼ åºç°çæ¬¡æ°" + startDot + "ç¹ç»åæ: " + dp[i][startDot] + "ç§");
                }

                System.err.println("|-----------------------------------------|");
            }
        }

        double[] ans = new double[6 * n - n + 1];
        for (int i = n; i <= 6 * n; i++)
            ans[i - n] = ((double) dp[n][i]) / (Math.pow(6, n));
        return ans;
    }

}
