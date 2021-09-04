package back_tracking.offer_38;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/9/1 17:40
 * @Url :https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 * @Level :    medium
 * @Desc : 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * @Counter :17
 * @Answer :
 * <p>
 * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/solution/hui-su-suan-fa-java-by-liweiwei1419/
 */
public class Permutation_2 {
    public static void main(String[] args) {
        Permutation_2 t = new Permutation_2();
        //输入：s = "abc"
        /// 输出：["abc","acb","bac","bca","cab","cba"]
        String s = "abc";
        t.permutation(s);
    }


    public String[] permutation(String s) {
        int len = s.length();
        if (len == 0) {
            return new String[0];
        }
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        StringBuilder path = new StringBuilder();
        boolean[] used = new boolean[len];
        List<String> res = new ArrayList<>();
        dfs(charArray, len, 0, used, path, res);
        return res.toArray(new String[0]);

    }

    private void dfs(char[] charArray, int len, int depth, boolean[] used, StringBuilder path, List<String> res) {
        if (len == depth) {
            res.add(path.toString());
            return;
        }

        // 数据处理
        for (int i = 0; i < len; i++) {
            if (i > 0 && charArray[i] == charArray[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            path.append(charArray[i]);
            dfs(charArray, len, depth + 1, used, path, res);
            path.deleteCharAt(path.length() - 1);
            used[i] = false;
        }
    }

}
