package binary_search.leet_code_275;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/8 18:17
 * @Desc :
 *
 * 题解：https://leetcode.cn/problems/h-index-ii/solution/jian-er-zhi-zhi-er-fen-cha-zhao-by-liweiwei1419-2/
 */
public class HIndex {
    public int hIndex(int[] citations) {
        int len = citations.length;
        Arrays.sort(citations);

        // 特殊判断
        if (citations[len - 1] == 0) {
            return 0;
        }
        // 二分查找猜测论文的数量，需要满足：分割线右边的最少引用次数 >= 分割线右边的论文篇数
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            // citations[mid] 表示分割线右边的文章的最少引用的次数
            if (citations[mid] < len - mid) {
                // 下一轮搜索区间 [mid + 1..right]
                left = mid + 1;
            } else {
                // 下一轮搜索区间 [left..mid]
                right = mid;
            }
        }
        return len - left;


    }
}
