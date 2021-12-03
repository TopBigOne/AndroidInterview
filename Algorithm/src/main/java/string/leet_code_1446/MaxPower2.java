package string.leet_code_1446;

import java.util.Scanner;

/**
 * @author : dev
 * @version :
 * @Date :  12/1/21 1:40 PM
 * @Desc :
 * <p>
 * https://leetcode-cn.com/problems/consecutive-characters/solution/gong-shui-san-xie-jian-dan-shuang-zhi-zh-xtv6/
 */
public class MaxPower2 {
    public int maxPower(String s) {
        int n = s.length(), ans = 1;

        for (int i = 0; i < n; ) {
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) j++;
            ans = Math.max(ans, j - i);
            i = j;
        }
        return ans;
    }

    public int maxPower2(String s) {
        int length = s.length();
        int ans = 1;
        for (int i = 0; i < length; ) {
            int j = i;
            while (j < length && s.charAt(i) == s.charAt(j)) {
                j++;
            }
            ans = Math.max(ans, j - i);
            i = j;
        }
        return ans;


    }


}
