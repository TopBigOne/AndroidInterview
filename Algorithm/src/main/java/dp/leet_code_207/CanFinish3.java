package dp.leet_code_207;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/30 00:10
 * @Desc :
 */
public class CanFinish3 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] inDegree = new int[numCourses];

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            int currCourse = prerequisite[0];
            // 统计当前课程的限制次数
            inDegree[currCourse]++;
            // 学习完这门课程，必须要修完的课程
            int needPrerequisite = prerequisite[1];
            if (graph.containsKey(needPrerequisite)) {
                graph.get(needPrerequisite).add(currCourse);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(currCourse);
                graph.put(needPrerequisite, list);
            }
        }

        // step 2:
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        // step 3:
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            List<Integer> toTake = graph.get(curr);
            if (toTake == null) {
                continue;
            }

            for (Integer currCourse : toTake) {
                inDegree[currCourse]--;
                if (inDegree[currCourse] == 0) {
                    queue.add(currCourse);
                }
            }
        }

        // step 4:
        for (int i : inDegree) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}
