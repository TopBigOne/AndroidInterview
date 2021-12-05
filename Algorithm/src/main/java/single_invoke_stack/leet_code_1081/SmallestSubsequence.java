package single_invoke_stack.leet_code_1081;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/9/25 23:02
 * @Url : https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters/
 * @Level :    medium
 * @Desc :  返回 s 字典序最小的子序列，该子序列包含 s 的所有不同字符，且只包含一次。
 * @Counter :
 * @Answer :
 */
public class SmallestSubsequence {
    public String smallestSubsequence(String s) {
        // 单调栈
        char[] stack = new char[26];
        // 栈中是否含有指定字母
        boolean[] used = new boolean[26];
        // 每种字母剩余的个数
        int[] cnt = new int[26];
        // 栈顶指针
        int top = 0;
        // 统计每个字母初始个数
        char[] sc = s.toCharArray();
        for (char c : sc) {
            cnt[c - 'a']++;
        }

        for (char c : sc) {
            int curIndex = c - 'a';
            if (!used[curIndex]) {
                while (top > 0 && stack[top - 1] > c && cnt[stack[top-1]-'a'] > 0) {
                    used[stack[top - 1] - 'a'] = false;
                    top -= 1;
                }
                stack[top++] = c;
                used[curIndex] = true;

            }

            cnt[curIndex]--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < top; i++) {
            sb.append(stack[i]);
        }
        return sb.toString();

    }
}
