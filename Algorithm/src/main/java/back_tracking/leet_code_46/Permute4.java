package back_tracking.leet_code_46;

import com.sun.jmx.snmp.SnmpOid;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.zip.Deflater;

/**
 * @author : dev
 * @version :
 * @Date :  2022/3/7 10:31
 * @Desc :
 */
public class Permute4 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int len;
        if (nums == null || (len = nums.length) == 0) {
            return result;
        }
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[len];
        dfs(nums, len, 0, path, used, result);

        return result;
    }

    private void dfs(int[] nums, int len, int depth, Deque<Integer> path,
                     boolean[] used, List<List<Integer>> result) {
        if (depth == len) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }

            path.addLast(nums[i]);
            used[i] = true;

            dfs(nums, len, depth + 1, path, used, result);
            path.removeLast();
            used[i] = false;

        }
    }


}
