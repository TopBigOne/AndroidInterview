package back_tracking.leet_code_93;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  5/28/21 11:59 PM
 * @Desc : 93. 复原 IP 地址：https://leetcode.cn/problems/restore-ip-addresses/solution/
 * <p>
 * <p>
 * 题解：https://leetcode.cn/problems/restore-ip-addresses/solution/hui-su-suan-fa-hua-tu-fen-xi-jian-zhi-tiao-jian-by/
 */
public class RestoreIpAddresses2 {
    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        List<String> res = new ArrayList<>();
        if (len < 4 || len > 12) {
            return res;
        }
        Deque<String> path = new ArrayDeque<>();

        dfs(s, len, 0, 4, path, res);
        return res;
    }

    /**
     * @param s
     * @param len
     * @param begin   截取 ip 段的起始位置
     * @param residue
     * @param path    记录从根结点到叶子结点的一个路径（回溯算法常规变量，是一个栈）；
     * @param res
     */
    private void dfs(String s, int len, int begin, int residue, Deque<String> path, List<String> res) {
        if (begin == len) {
            if (residue == 0) {
                res.add(String.join(".", path));
            }
            return;
        }
        // ip 3个int 一组
        for (int i = begin; i < begin + 3; i++) {
            if (i >= len) {
                break;
            }
            if (residue * 3 < len - i) {
                continue;
            }
            if (judgeIpSegment(s, begin, i)) {
                // 每一个结点可以选择截取的方法只有 3 种：截 1 位、截 2 位、截 3 位，
                String currentIpSegment = s.substring(begin, i + 1);
                path.addLast(currentIpSegment);

                dfs(s, len, i + 1, residue - 1, path, res);
                path.removeLast();
            }
        }
    }

    private boolean judgeIpSegment(String s, int left, int right) {
        int len = right - left + 1;
        if (len > 1 && s.charAt(left) == '0') {
            return false;
        }
        int res = 0;
        while (left <= right) {
            res = res * 10 + s.charAt(left) - '0';
            left++;
        }
        return res >= 0 && res <= 255;
    }
}

