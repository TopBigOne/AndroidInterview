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
 * @Date :  2022/9/24 14:48
 * @Desc : https://leetcode.cn/problems/course-schedule/
 */
public class CanFinish6 {
    public static void main(String[] args) {
        int[][] prerequisites = {
                {4, 0},
                {4, 1},
                {3, 1},
                {3, 2},
                {5, 4},
                {5, 3}
        };
        int numCourses = 6;
        CanFinish6 canFinish = new CanFinish6();
        boolean result = canFinish.canFinish(numCourses, prerequisites);
        System.err.println("result : " + result);

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int currCourse = prerequisite[0];
            inDegree[currCourse]++;

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
            // 入度 是0；
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        // step 3:
        while (!queue.isEmpty()) {
            int currCourse = queue.poll();
            List<Integer> toTake = graph.get(currCourse);
            if (toTake == null) {
                continue;
            }
            for (Integer tempCourse : toTake) {
                inDegree[tempCourse]--;
                if (inDegree[tempCourse] == 0) {
                    queue.add(tempCourse);
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
