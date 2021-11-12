package string.leet_code_38;

/**
 * @author : dev
 * @version :
 * @Date :  11/9/21 1:37 PM
 * @Desc : leetcode 38：外观数列 https://leetcode-cn.com/problems/count-and-say/
 *
 *
 *
 * 题解：https://leetcode-cn.com/problems/count-and-say/solution/jian-dan-12wai-guan-shu-lie-de-tui-dao-di-gui-yi-c/
 */
public class CountAndSay {

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        int cnt = 1;
        String pre = countAndSay(n - 1);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < pre.length(); i++) {
            if (i < pre.length() - 1 && pre.charAt(i) == pre.charAt(i + 1)) {
                cnt++;
            } else {
                res.append(cnt).append(pre.charAt(i));
                cnt = 1;
            }
        }
        return res.toString();
    }

    public String countAndSay2(int n) {
        if (n == 1) {
            return "1";
        }
        int cnt = 1;
        // 反手一个递归
        String pre = countAndSay2(n - 1);
        StringBuilder res = new StringBuilder();
        int preLength = res.length();
        for (int i = 0; i < preLength; i++) {

            if (i < preLength - 1 && pre.charAt(i) == pre.charAt(i + 1)) {
                cnt++;
                continue;
            }
            res.append(cnt).append(pre.charAt(i));
            cnt = 1;
        }
        return res.toString();



    }

}
