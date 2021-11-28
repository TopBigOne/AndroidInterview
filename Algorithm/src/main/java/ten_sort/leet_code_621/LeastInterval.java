package ten_sort.leet_code_621;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/11/28 23:10
 * @Url : https://leetcode-cn.com/problems/task-scheduler/
 * @Level :    medium
 * @Desc : 任务调度器
 * @Counter :
 * @Answer : https://leetcode-cn.com/problems/task-scheduler/solution/tong-zi-by-popopop/
 */
public class LeastInterval {
    /**
     * 参考桶思想
     *
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        int[] temp = new int[26];
        int countMaxTask = 0;
        int maxTask = 0;
        for (char c : tasks) {
            temp[c - 'A']++;
            maxTask = Math.max(temp[c - 'A'], maxTask);
        }

        for (int i = 0; i < 26; i++) {
            if (temp[i] == maxTask) {
                countMaxTask++;
            }
        }
        return Math.max(tasks.length, (maxTask - 1) * (n + 1) + countMaxTask);
    }

    public int leastInterval2(char[] tasks, int n) {
        int[] temp = new int[26];
        int countMaxTask = 0;
        int maxTask = 0;
        for (char c : tasks) {
            temp[c - 'A']++;
            maxTask = Math.max(temp[c - 'A'], maxTask);
        }
        for (int i = 0; i < 26; i++) {
            if (temp[i] == maxTask) {
                countMaxTask++;
            }
        }

        return Math.max(tasks.length, (maxTask - 1) * (n + 1) + countMaxTask);

    }
}
