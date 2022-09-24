package dp.leet_code_207;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author : dev
 * @version :
 * @Date :  2022/9/24 15:48
 * @Desc :
 * https://leetcode.cn/problems/course-schedule/
 */
public class CanFinish7 {


    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{0, 1}};
        CanFinish7 canFinish = new CanFinish7();
        boolean result = canFinish.canFinish(2, prerequisites);
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

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int currCourse = queue.poll();
            List<Integer> toTake = graph.get(currCourse);
            if (toTake == null) {
                continue;
            }

            for (Integer temp : toTake) {
                inDegree[temp]--;
                if (inDegree[temp] == 0) {
                    queue.add(temp);
                }
            }

        }

        for (int i : inDegree) {
            if (i != 0) {
                return false;
            }
        }
        return true;

    }

    public boolean canFinish2(int numCourses, int[][] prerequisites) {
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

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int currCourse = queue.poll();
            List<Integer> toTake = graph.get(currCourse);
            if (toTake == null) {
                continue;
            }

            for (Integer temp : toTake) {
                inDegree[temp]--;
                if (inDegree[temp] == 0) {
                    queue.add(temp);
                }
            }
        }

        for (int i : inDegree) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
