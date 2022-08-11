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
 * @Date :  2022/8/11 15:37
 * @Desc :
 */
public class CanFinish2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // step 1:
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            // 当前的课程
            int currCourses = prerequisite[0];
            // 统计当前课程的限制次数
            inDegree[currCourses]++;
            // 学习当前课程，必须要修完的课程
            int needPrerequisite = prerequisite[1];
            if (graph.containsKey(needPrerequisite)) {
                graph.get(needPrerequisite).add(currCourses);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(currCourses);
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
            for (int i = 0; i < toTake.size(); i++) {
                int currCourses = toTake.get(i);
                inDegree[currCourses]--;
                if (inDegree[currCourses] == 0) {
                    queue.add(currCourses);
                }
            }
        }

        // step 4:
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] != 0) {
                return false;
            }
        }
        return true;

    }

    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[numCourses];
        // step 1:
        for (int[] prerequisite : prerequisites) {
            int currCourse = prerequisite[0];
            inDegree[currCourse]++;
            int needPrerequisite = prerequisite[1];
            if (graph.containsKey(needPrerequisite)) {
                graph.get(needPrerequisite).add(currCourse);
                continue;
            }
            List<Integer> list = new ArrayList<>();
            list.add(currCourse);
            graph.put(needPrerequisite, list);
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
            int currZeroIndex = queue.poll();
            List<Integer> toTake = graph.get(currZeroIndex);
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

        // step 4: check;
        for (int i : inDegree) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean canFinish3(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        // step 1:
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
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        // step 3:
        while (!queue.isEmpty()) {
            int currZeroIndex = queue.poll();
            List<Integer> toTake = graph.get(currZeroIndex);
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

        for (int i : inDegree) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean canFinish4(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        // step 1:
        for (int[] prerequisite : prerequisites) {
            int currCourse = prerequisite[0];
            int needPrerequisite = prerequisite[1];
            inDegree[currCourse]++;
            if (graph.containsKey(needPrerequisite)) {
                graph.get(needPrerequisite).add(currCourse);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(currCourse);
                graph.put(needPrerequisite, list);
            }
        }
        // step 2:
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        // step 3:
        while (!queue.isEmpty()) {
            int currZeroIndex = queue.poll();
            List<Integer> toTake = graph.get(currZeroIndex);
            if(toTake==null){
                continue;
            }
            for (Integer currCourse : toTake) {
                inDegree[currCourse]--;
                if (inDegree[currCourse] == 0) {
                    queue.add(currCourse);
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
