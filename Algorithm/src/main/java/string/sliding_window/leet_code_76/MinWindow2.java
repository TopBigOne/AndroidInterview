package string.sliding_window.leet_code_76;

/**
 * @author : dev
 * @version :
 * @Date :  2021/5/24 17:06
 * @Desc :  leetcode 76 ：最小覆盖子串，困难，字节：26 次：https://leetcode-cn.com/problems/minimum-window-substring/
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 题解：https://leetcode-cn.com/problems/minimum-window-substring/solution/hua-dong-chuang-kou-ji-bai-liao-100de-javayong-hu-/
 */
public class MinWindow2 {
    public String minWindow(String s, String t) {
        int sLen;
        int tLen;
        String result = "";
        if (s == null || t == null || (sLen = s.length()) == 0 || (tLen = t.length()) == 0 || sLen < tLen) {
            return result;
        }
        int[] needs = new int[128];
        int[] window = new int[128];
        int count = 0;
        int targetCount = tLen;
        int left = 0;
        int right = 0;
        int minLength = sLen + 1;
        for (char c : t.toCharArray()) {
            needs[c]++;
        }


        while (right < sLen) {
            char currChar = s.charAt(right);
            window[currChar]++;
            if(needs[currChar]>0&&needs[currChar]>=window[currChar]){
                count++;
            }
            while (count==targetCount){
                currChar = s.charAt(left);
                if(needs[currChar]>0&&needs[currChar]>=window[currChar]){
                    count--;
                }
                if(minLength>right-left+1){
                    minLength= right-left+1;
                    result = s.substring(left,right+1);
                }
                window[currChar]--;
                left++;
            }


            right++;
        }


        return result;
    }

}
