package dp.leet_code_207;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : dev
 * @version :
 * @Date :  11/10/21 1:34 PM
 * @Desc : 课程表： https://leetcode-cn.com/problems/course-schedule/
 * <p>
 * 你这个学期必须选修 numCourses 门课程，记为0到numCourses - 1 。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组prerequisites 给出，其中prerequisites[i] = [ai, bi] ，
 * 表示如果要学习课程ai 则 必须 先学习课程bi 。
 * <p>
 * 例如，先修课程对[0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 题解：https://leetcode-cn.com/problems/course-schedule/solution/tuo-bu-pai-xu-by-liweiwei1419/
 */
public class CanFinish {

    /**
     * 算法流程：
     * <p>
     * 1、在开始排序前，扫描对应的存储空间（使用邻接表），将入度为 00 的结点放入队列。
     * <p>
     * 2、只要队列非空，就从队首取出入度为 00 的结点，将这个结点输出到结果集中，
     * 并且将这个结点的所有邻接结点（它指向的结点）的入度减 11，在减 11 以后，如果这个被减 11 的结点的入度为 00 ，就继续入队。
     * <p>
     * 3、当队列为空的时候，检查结果集中的顶点个数是否和课程数相等即可。
     * <p>
     * 思考这里为什么要使用队列？（马上就会给出答案。）
     * <p>
     * 在代码具体实现的时候，除了保存入度为 0 的队列，我们还需要两个辅助的数据结构：
     * <p>
     * 1、邻接表：通过结点的索引，我们能够得到这个结点的后继结点；
     * <p>
     * 2、入度数组：通过结点的索引，我们能够得到指向这个结点的结点个数。
     * <p>
     * 这个两个数据结构在遍历题目给出的邻边以后就可以很方便地得到。
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return false;
        }

        // 特判
        int pLen = prerequisites.length;
        if (pLen == 0) {
            return true;
        }

        int[] inDegree = new int[numCourses];
        HashSet<Integer>[] adj = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new HashSet<>();
        }

        for (int[] p : prerequisites) {
            inDegree[p[0]]++;
            adj[p[1]].add(p[0]);
        }

        Queue<Integer> queue = new LinkedList<>();

        // 首先加入入度为 0 的结点
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // 记录已经出队的课程数量
        int cnt = 0;
        while (!queue.isEmpty()) {
            Integer top = queue.poll();
            cnt += 1;
            // 遍历当前出队结点的所有后继结点
            for (int successor : adj[top]) {
                inDegree[successor]--;
                if (inDegree[successor] == 0) {
                    queue.add(successor);
                }
            }
        }
        return cnt == numCourses;
    }

    public boolean canFinish2(int numCourse, int[][] prerequisites) {
        // base conner.
        if (numCourse <= 0) {
            return false;
        }
        // 特别判断
        int pLen = prerequisites.length;
        // 没有特殊要求，一定可完成；
        if (pLen == 0) {
            return true;
        }
        int[] inDegree = new int[numCourse];
        HashSet<Integer>[] adj = new HashSet[numCourse];
        for (int i = 0; i < numCourse; i++) {
            adj[i] = new HashSet<>();
        }
        for (int[] p : prerequisites) {
            inDegree[p[0]]++;
            adj[p[1]].add(p[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        // 首先加入 入度 为 0 的节点
        for (int i = 0; i < numCourse; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // 记录已经出队的课程数量
        int cnt = 0;
        while (!queue.isEmpty()) {
            Integer top = queue.poll();
            cnt += 1;
            // 遍历当前出队节点的所有后继节点
            for (int successor : adj[top]) {
                inDegree[successor]--;
                if (inDegree[successor] == 0) {
                    queue.add(successor);
                }
            }

        }

        return cnt == numCourse;
    }
}
