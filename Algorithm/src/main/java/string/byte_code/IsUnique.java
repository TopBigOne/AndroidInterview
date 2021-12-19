package string.byte_code;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/18 00:13
 * @Url :https://leetcode-cn.com/problems/is-unique-lcci/
 * @Level :  easy
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class IsUnique {
    public boolean isUnique(String astr) {
        int length = astr.length();
        if (length == 0) {
            return true;
        }
        int[] map = new int[256];
        for (int i = 0; i < length; i++) {
            char c = astr.charAt(i);
            map[c]++;
            if (map[c] > 1) {
                return false;
            }
        }
        return true;
    }
}
