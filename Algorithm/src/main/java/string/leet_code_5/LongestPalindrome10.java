package string.leet_code_5;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/17 17:07
 * @Desc :
 */
public class LongestPalindrome10 {

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
            int[] odd = centerSpread(s, i, i);
            int[] even = centerSpread(s, i, i + 1);
            int [] max = odd[1] >even[1] ? odd :even;
            if(max[1]>maxLen){
                maxLen = max[1];
                res = max;
            }
        }
        return s.substring(res[0],res[0]+res[1]);

    }

    private int[] centerSpread(String s, int start, int end) {
        while (start >= 0 && end < s.length()) {
            if (s.charAt(start) == s.charAt(end)) {
                start--;
                end++;
            } else {
                break;
            }
        }
        // start 要往后一定一位，因为 start+1 已经被证明不符合equal
        // end 不需要-1，是因为 substring
        return new int[]{start + 1, end - start - 1};
    }


}
