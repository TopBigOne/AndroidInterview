package sliding_window.leet_code_718;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/6/22 13:50
 * @Url :
 * @Level : easy medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class FindLength3 {

    public int findLength(int[] numsA, int[] numsB) {
        return numsA.length < numsB.length ? findLengthHelp(numsA, numsB) : findLengthHelp(numsB, numsA);
    }

    private int findLengthHelp(int[] numsA, int[] numsB) {
        int aLength = numsA.length;
        int bLength = numsB.length;
        int total = aLength + bLength - 1;
        int max = 0;
        for (int i = 0; i < total; i++) {
            int aStart;
            int bStart;
            int len;
            if (i < aLength) {
                bStart = 0;
                aStart = aLength - i - 1;
                len = i + 1;
            } else {
                aStart = 0;
                bStart = i - aLength + 1;
                len = Math.max(bLength - bStart, aLength);
            }
            int maxLen = maxLen(numsA, numsB, aStart, bStart, len);
            max = Math.max(max, maxLen);
        }
        return max;
    }

    private int maxLen(int[] numsA, int[] numsB, int aStart, int bStart, int len) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < len; i++) {
            if (numsA[aStart + i] == numsB[bStart + i]) {
                count++;
                max = Math.max(count, max);
            }
            count = 0;
        }
        return max;
    }

}
