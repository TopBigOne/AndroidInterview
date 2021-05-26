package string.leet_code_14;

/**
 * @author : dev
 * @version :
 * @Date :  2021/5/26 20:19
 * @Desc :
 * <p>
 * 题解：
 * 视频：https://www.bilibili.com/video/BV1my4y1B7V6?from=search&seid=8531705894344549116
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int length;
        if (strs == null || (length = strs.length) == 0) {
            return "";
        }
        String first = strs[0];
        // 最后一个相同的char 的index；
        int max = first.length() - 1;

        // 从 1 开始遍历，是不想包含 first
        for (int i = 1; i < length; i++) {
            // 当前字符串
            String currStr = strs[i];
            max = Math.min(currStr.length() - 1, max);

            for (int j = 0; j <= max; j++) {
                // 不相等
                if (currStr.charAt(j) != first.charAt(j)) {
                    if (j == 0) {
                        return "";
                    } else {
                        max = j - 1;
                    }
                }
            }
        }

        return first.substring(0, max + 1);
    }

    public String longestCommonPrefix2(String[] strs) {
        // base case;
        int length;
        if (strs == null || (length = strs.length) == 0) {
            return "";
        }
        // 1: 获取第一个字符串str，以便下面做比较
        String firstStr = strs[0];
        // 2: 定义一个右边界max，减1 是因为，数组的下标从0 开始的；
        int max = firstStr.length() - 1;
        // 3: 从数组strs第二个开始做遍历，与first 做比较；
        for (int i = 1; i < length; i++) {
            // 3-1: 当前字符串；
            String currStr = strs[i];
            max = Math.min(currStr.length() - 1, max);
            //3-2: 开始以 max的大小为范围遍历
            for (int j = 0; j < max; j++) {
                // 3-3:  若是当前字符不相等；
                if (currStr.charAt(j) != firstStr.charAt(j)) {
                    // 3-4: 若是第一个字符都不相等
                    if (j == 0) {
                        return "";
                    } else {
                        // 3-5：当前值已经不相等了，还是回头一下（减1），取上一个值吧；
                        max = j - 1;
                    }
                }
            }
        }
        // 4: 做字符串截取，并返回结果
        return firstStr.substring(0, max + 1);
    }

    public String longestCommonPrefix3(String[] strs) {
        int length;
        if (strs == null || (length = strs.length) == 0) {
            return "";
        }
        String firstStr = strs[0];
        int max = firstStr.length() - 1;
        // 从第二个开始
        for (int i = 1; i < length; i++) {
            String currStr = strs[i];
            max = Math.min(currStr.length() - 1, max);
            // 以max大小为范围，进行遍历
            for (int j = 0; j <=max; j++) {
                if (currStr.charAt(j) != firstStr.charAt(j)) {
                    if (j == 0) {
                        return "";
                    }
                    // 取上一步的值
                    max = j - 1;

                }
            }

        }
        return firstStr.substring(0, max + 1);

    }
}
