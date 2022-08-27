package sliding_window.leet_code_567;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/17 23:20
 * @Desc :
 * 题解：https://leetcode.cn/problems/permutation-in-string/solution/yong-hua-dong-chuang-kou-shuang-zhi-zhen-72m5/
 */
public class CheckInclusion2 {
    public static void main(String[] args) {
        CheckInclusion2 checkInclusion = new CheckInclusion2();
        String s1 = "ab";

        String s2 = "eidbaooo";
        s2 = "eidboaoo";

        boolean result = checkInclusion.checkInclusion(s1, s2);
        System.err.println("result : " + result);

    }

    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2) {
            return false;
        }
        int[] count = new int[256];
        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i)]--;
        }

        int left = 0;
        int right = 0;
        while (right < len2) {
            char currChar = s2.charAt(right);
            count[currChar]++;

            while (count[currChar] > 0) {
                char leftChar = s2.charAt(left);
                count[leftChar]--;
                left++;
            }
            if (right - left + 1 == len1) {
                return true;
            }
            right++;
        }
        return false;

    }

}
