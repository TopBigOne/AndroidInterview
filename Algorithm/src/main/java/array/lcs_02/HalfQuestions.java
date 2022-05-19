package array.lcs_02;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/16 17:36
 * @Desc : 哈哈哈，，没有读懂题意
 */
public class HalfQuestions {
    public int halfQuestions(int[] questions) {
        int[] counts = new int[1001];
        // 题目计数器
        for (int question : questions) {

            counts[question]++;
        }
        // 从小到大排列
        Arrays.sort(counts);
        int res = 0;
        int half = questions.length >> 1;

        for (int i = 1000; i >= 0; i--) {
            if (half > 0) {
                half -= counts[i];
                // 累加
                res++;
            } else{
                return res;
            }

        }
        return questions.length >> 1;

    }
}
