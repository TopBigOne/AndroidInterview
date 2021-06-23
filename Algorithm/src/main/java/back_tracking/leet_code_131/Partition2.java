package back_tracking.leet_code_131;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  6/23/21 11:22 PM
 * @Desc : 分割回文串
 * 给你一个字符串 s；
 * 请将 s 分割成一些回文串，返回 s 所有可能的分割方案
 */
public class Partition2 {
    public void dfs(char[] charArray, int index, int len, Deque<String> path, List<List<String>> res) {
        if (index == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < len; i++) {
            if (!checkPalindrome(charArray, index, i)) {
                continue;
            }
            path.addLast(new String(charArray, index, i + 1 - index));
            dfs(charArray,  i+ 1, len, path, res);
            path.removeLast();
        }
    }

    private boolean checkPalindrome(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


}
