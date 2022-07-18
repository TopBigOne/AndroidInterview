package string.code_interview_guide;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/18 11:00
 * @Desc :
 * https://leetcode.cn/problems/check-permutation-lcci/
 */
public class CheckPermutation {
    public boolean checkPermutation(String s1, String s2) {
        int[] cout = new int[256];
        for (char c : s1.toCharArray()) {
            cout[c]++;
        }
        for (char c : s2.toCharArray()) {
            cout[c]--;
        }
        for (int i : cout) {
            if (i != 0) {
                return false;
            }
        }

        return true;


    }

}
