package back_tracking.leet_code_93;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/5 19:51
 * @Desc :
 */
public class RestoreIpAddresses8 {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        int len = 0;
        if (s == null || (len = s.length()) == 0 || len < 4 || len > 12) {
            return res;
        }
        Deque<String> path = new ArrayDeque<>();
        dfs(s, len, 0, 4, path, res);
        return res;

    }

    private void dfs(String s, int len, int begin, int reside, Deque<String> path, List<String> res) {
        if (begin == len) {
            if (reside == 0) {
                res.add(String.join(".", path));
            }
            return;
        }
        for (int i = begin; i < begin + 3; i++) {
            if (i >= len) {
                break;
            }
            if (reside * 3 < len - i) {
                continue;
            }
            if (judgeIpSegment(s, begin, i)) {
                path.addLast(s.substring(begin, i + 1));
                dfs(s, len, i + 1, reside - 1, path, res);
                path.removeLast();
            }
        }
    }

    private boolean judgeIpSegment(String s, int start, int end) {
        int len = end - start + 1;
        if (len > 1 && s.charAt(start) == '0') {
            return false;
        }
        int res = 0;
        while (start <= end) {
            res = res * 10 + s.charAt(start) - '0';
            start++;
        }
        return res >= 0 && res <= 255;
    }


}
