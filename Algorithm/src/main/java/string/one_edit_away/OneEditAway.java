package string.one_edit_away;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/13 16:09
 * @Desc :
 * <p>
 * https://leetcode.cn/problems/one-away-lcci/submissions/
 * <p>
 * https://leetcode.cn/problems/one-away-lcci/solution/by-ac_oier-7ml0/
 *
 * 题解：https://leetcode.cn/problems/one-away-lcci/solution/zi-fu-chuan-bi-jiao-by-luorong/
 */
public class OneEditAway extends Base {
    public boolean oneEditAway(String first, String second) {

        int mLength = first.length();
        int nLength = second.length();

        if (Math.abs(nLength - mLength) > 1) {
            return false;
        }
        if (mLength > nLength) {
            return oneEditAway(second, first);
        }


        int i = 0;
        int j = 0;
        int count = 0;

        while (i < mLength && j < nLength && count <= 1) {
            char c1 = first.charAt(i);
            char c2 = second.charAt(j);
            if (c1 == c2) {
                i++;
                j++;
                continue;
            }

            if (mLength == nLength) {
                i++;
                j++;
            } else {
                j++;
                count++;
            }

        }

        return count <= 1;

    }

}
