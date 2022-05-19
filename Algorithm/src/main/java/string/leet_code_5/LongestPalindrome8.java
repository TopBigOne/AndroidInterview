package string.leet_code_5;

import java.util.Arrays;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/22 23:32
 * @Url : https://leetcode.cn/problems/longest-palindromic-substring/
 * @Level :    medium
 * @Desc : 最长回文串
 * @Counter :
 * @Answer :
 * <p>
 * wei wei :https://leetcode.cn/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-dong-tai-gui-hua-by-liweiwei1419/
 */
public class LongestPalindrome8 {


    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 0;
        // 数组第一位 记录起始位置，第二位 记录长度
        int[] res = new int[2];
        for (int i = 0; i < len; i++) {
            // 如果传入重合的下标，进行中心扩散，此时得到的回文子串的长度是奇数；
            int[] odd = centerSpread(s, i, i);
            // 如果传入相邻的下标，进行中心扩散，此时得到的回文子串的长度是偶数
            int[] even = centerSpread(s, i, i + 1);

            // 得到长度最大的数组
            int[] max = odd[1] > even[1] ? odd : even;
            // 不断的更新maxLen的值
            if (max[1] > maxLen) {
                res = max;
                maxLen = max[1];
            }
        }

        System.out.println("max array : "+ Arrays.toString(res));

        return s.substring(res[0], res[0] + res[1]);

    }

    private int[] centerSpread(String s, int left, int right) {
        System.out.println("curr left : " + left + " , right : " + right);
        int len = s.length();
        while (left >= 0 && right < len) {
            if (s.charAt(left) != s.charAt(right)) {
              //  left++;
               // right--;
                break;
            }
            // 相等了
            if (s.charAt(left) == s.charAt(right)) {
                // 扩散。
                // 往左边扩散
                left--;
                // 往右边扩散
                right++;
            }
        }
        // 数组第一位 记录起始位置，第二位 记录长度
        return new int[]{left + 1, right - left - 1};
        // return new int[]{left + 1, right - left + 1};
    }


}
