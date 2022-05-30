package binary_search.leet_code_744;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/28 17:39
 * @Desc :744. 寻找比目标字母大的最小字母 ：https://leetcode.cn/problems/find-smallest-letter-greater-than-target/
 * <p>
 * 题解：https://leetcode.cn/problems/find-smallest-letter-greater-than-target/solution/er-fen-cha-zhao-java-by-liweiwei1419-yk3g/
 */
public class NextGreatestLetter {

    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'j'};
        char target = 'c';

        NextGreatestLetter nextGreatestLetter = new NextGreatestLetter();
        char result = nextGreatestLetter.nextGreatestLetter(letters, target);
        System.err.println("result : " + result);
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int len = letters.length;
        if (letters[len - 1] <= target) {
            return letters[0];
        }

        int l = 0;
        int r = len - 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            char midChar = letters[mid];
            if (midChar <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return letters[l];
    }
}
