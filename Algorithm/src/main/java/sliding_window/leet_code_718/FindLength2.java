package sliding_window.leet_code_718;

/**
 * @author : dev
 * @version :
 * @Date :  6/21/21 10:26 PM
 * @Desc : leetcode 718 :  字节 9 次： 最长无重复子数组：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
 * <p>
 * 题解： 看滑动窗口
 * https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/solution/javadong-tai-gui-hua-jie-jue-qi-shi-jiu-shi-zui-ch/
 */
public class FindLength2 {
    public static void main(String[] args) {
        int[] numsA = {1, 2, 3, 2, 1};
        int[] numsB = {3, 2, 1, 4};
        FindLength2 findLength = new FindLength2();
        int result = findLength.findLengthHelp(numsA, numsB);
        System.out.println("result : " + result);
    }

    public int findLength(int[] A, int[] B) {
        // 短的动....
        return A.length > B.length ? findLengthHelp(B, A) : findLengthHelp(A, B);
    }

    private int findLengthHelp(int[] numsA, int[] numsB) {
        int aLength = numsA.length;
        int bLength = numsB.length;
        // 总共运行的次数
        int total = aLength + bLength - 1;
        int max = 0;
        for (int i = 0; i < total; i++) {
            // 下面一大坨主要判断数组 A 和数组 B 比较的起始位置和比较长度
            int aStart;
            int bStart;
            int len = 0;
            if (i < aLength) {
                aStart = aLength - i - 1;
                bStart = 0;
                len = i + 1;

            } else {
                aStart = 0;
                bStart = i - aLength + 1;
                len = Math.min(bLength - bStart, aLength);
            }
            int maxLen = maxLength(numsA, numsB, aStart, bStart, len);
            max = Math.max(max, maxLen);
        }
        return max;
    }

    private int findLengthHelp2(int[] numsA, int[] numsB) {
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
                len = Math.min(bLength - bStart, aLength);
            }
            int maxLen = maxLength(numsA, numsB, aStart, bStart, len);
            max = Math.max(max, maxLen);
        }
        return max;
    }

    private int findLengthHelp3(int[] numsA, int[] numsB) {
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
                len = Math.min(bLength - bStart, aLength);
            }
            int maxLen = maxLength(numsA, numsB, aStart, bStart, len);
            max = Math.max(max, maxLen);
        }
        return max;
    }

    private int findLengthHelp4(int[] numsA, int[] numsB) {
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

                len = Math.min(bLength - bStart, aLength);

            }
            int maxLen = maxLength(numsA, numsB, aStart, bStart, len);
            max = Math.max(max, maxLen);
        }

        return max;
    }

    private int findLengthHelp5(int[] numsA, int[] numsB) {
        int aLength = numsA.length;
        int bLength = numsB.length;
        int total = aLength + bLength - 1;
        int max = 0;
        for (int i = 0; i < total; i++) {
            int aStart;
            int bStart;
            int len;
            // 处理 A；
            if (i < aLength) {
                bStart = 0;
                aStart = aLength - i - 1;
                len = i + 1;
            } else {
                aStart = 0;
                bStart = i - aLength + 1;
                len = Math.min(bLength - bStart, aLength);
            }

            int maxLen = maxLength(numsA, numsB, aStart, bStart, len);
            max = Math.max(max, maxLen);

        }
        return max;
    }

    private int findLengthHelp6(int[] numsA, int[] numsB) {
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
                len = Math.min(bLength - bStart, aLength);

            }
            int maxLen = maxLength(numsA, numsB, aStart, bStart, len);
            max = Math.max(max, maxLen);
        }
        return max;
    }

    private int findLengthHelp7(int[] numsA, int[] numsB) {
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

            int maxLen = maxLength7(numsA, numsB, aStart, bStart, len);
            max = Math.max(max, maxLen);
        }
        return max;

    }

    private int maxLength7(int[] numsA, int[] numsB, int aStart, int bStart, int len) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (numsA[aStart + i] == numsB[bStart + i]) {
                count++;
                max = Math.max(max, count);
                continue;
            }
            count = 0;
        }
        return max;
    }

    private int maxLength8(int[] numsA, int[] numsB, int aStart, int bStart, int len) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (numsA[aStart + i] == numsB[bStart + i]) {
                count++;
                max = Math.max(max, count);
                continue;
            }
            count = 0;

        }
        return max;
    }

    private int maxLength9(int[] numsA, int[] numsB, int aStart, int bStart, int len) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (numsA[aStart + i] == numsB[bStart + i]) {
                count++;
                max = Math.max(max, count);
                continue;
            }
            count = 0;
        }
        return max;
    }


    private int maxLength(int[] numsA, int[] numsB, int aStart, int bStart, int len) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (numsA[aStart + i] == numsB[bStart + i]) {
                count++;
                max = Math.max(max, count);
                continue;
            }
            count = 0;
        }
        return max;
    }

}
