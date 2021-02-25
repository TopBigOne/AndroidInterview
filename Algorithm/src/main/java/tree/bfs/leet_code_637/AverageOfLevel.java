package tree.bfs.leet_code_637;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2/15/21 10:38 PM
 * @Desc : 二叉树的层平均值（https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/）
 * 实际上考察 BFS
 * <p>
 * <p>
 * 题解：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/solution/637-er-cha-shu-de-ceng-ping-jun-zhi-er-cha-shu-cen/
 */
public class AverageOfLevel {
    /**
     * https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/solution/tong-yong-bfsjie-fa-by-shi-san-dao/
     *
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        //使用队列保存上一层节点，方便进行下一层的遍历；
        //先进先出，确保上层节点一定比下层节点先遍历
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size;
        TreeNode temp;
        Double sum;
        //队列为空，说明上层所有节点都没有叶子节点，遍历完毕
        while (!queue.isEmpty()) {
            sum = 0.0;
            //重置size，确保本次for循环的是同一层的所有节点
            size = queue.size();
            for (int i = 1; i <= size; i++) {
                temp = queue.poll();
                if (temp == null) {
                    continue;
                }
                sum += temp.val;
                //把下一层的所有非空节点加入队列
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            result.add(sum / size);
        }
        return result;

    }

    public List<Double> averageOfLevels2(TreeNode root) {
        List<Double> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size;
        TreeNode temp;
        Double sum;
        while (!queue.isEmpty()) {
            sum = 0.0;
            // 每次都会减少
            size = queue.size();
            for (int i = 1; i <= size; i++) {
                temp = queue.poll();
                if (temp == null) {
                    continue;
                }
                sum += temp.val;

                // 把下一层的所有非空节点加入队列
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            result.add(sum / size);
        }

        return result;
    }

    public List<Double> averageOfLevel3(TreeNode node) {
        List<Double> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        int size;
        TreeNode temp;
        Double sum;
        while (!queue.isEmpty()) {
            size = queue.size();
            sum = 0.0;
            for (int i = 1; i <= size; i++) {
                temp = queue.poll();
                if (temp == null) {
                    continue;
                }
                sum += temp.val;
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }

            }
            result.add(sum / size);

        }
        return result;
    }


    public List<Double> averageOfLevel4(TreeNode root) {
        List<Double> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size;
        TreeNode temp;
        Double sum = 0.0;
        while (!queue.isEmpty()) {
            size = queue.size();
            sum = 0.0;
            for (int i = 1; i <= size; i++) {
                temp = queue.poll();
                if (temp == null) {
                    continue;
                }
                sum += temp.val;

                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            result.add(sum / size);
        }
        return result;
    }
}
