package string.leet_code_5;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/17 15:41
 * @Desc :
 */
public class LongestPalindrome9 {

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 0;
        // 0 index : 记录起始位置；
        // 1 index : 记录回文长度；
        int[] res = new int[2];

        for (int i = 0; i < len; i++) {

            // 奇数
            int[] odd = centerSpread(s, i, i);
            // 偶数
            int[] even = centerSpread(s, i, i + 1);


            int[] max = odd[1] > even[1] ? odd : even;

            if (max[1] > maxLen) {
                maxLen = max[1];
                res = max;
            }
        }

        return s.substring(res[0], res[0] + res[1]);

    }

    private int[] centerSpread(String s, int start, int end) {
        int len = s.length();

        while (start >= 0 && end < len) {
            if (s.charAt(start) == s.charAt(end)) {
                // 扩大范围
                start--;
                end++;
                continue;
            }
            // 只要发现了不相等，就中断循环
            break;
        }

        // start+end+1,中+1，是因为s.substring(int beginIndex ,int endIndex) 中的beginIndex，endIndex
        // 是 左闭右开的；
        return new int[]{start + 1, end - start - 1};
    }


}
