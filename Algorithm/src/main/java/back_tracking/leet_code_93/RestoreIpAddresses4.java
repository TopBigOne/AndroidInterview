package back_tracking.leet_code_93;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/27 21:11
 * @Desc :
 */
public class RestoreIpAddresses4 {

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
                String currIpSegment = s.substring(begin, i + 1);
                path.addLast(currIpSegment);
                dfs(s, len, i + 1, reside - 1, path, res);
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
