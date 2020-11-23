package com.top.jar.chapter_003.t_01;

import com.top.jar.Node;

import java.awt.HeadlessException;
import java.util.Stack;
import java.util.concurrent.RecursiveTask;
import java.util.stream.StreamSupport;

import javax.xml.transform.Source;

/**
 * 非递归遍历二叉树
 */
public class TraverseTree {

    /**
     * 前序遍历---中-->左--->右
     *
     * @param head
     */
    public void preOrderUnRecur(Node head) {
        if (head == null) {
            return;
        }
        // 自己新建一个栈
        Stack<Node> stack = new Stack<>();
        // 将 head 放入栈中；
        stack.add(head);
        // 栈不为空
        while (!stack.isEmpty()) {
            head = stack.pop();
            System.out.print("head.value: " + head.value);
            if (head.right != null) {
                stack.push(head.right);
            }
            if (head.left != null) {
                stack.push(head.left);
            }
        }
        System.out.println();
    }

    /**
     * 中序遍历 ：左--中--右
     *
     * @param head
     */
    public void inOrderUnRecur(Node head) {
        System.out.println("in-order");
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                // 一直 put----head
                stack.push(head);
                // 注意哦，遍历到二叉树的最左边的时候，left 就是空了。
                head = head.left;
            } else {
                // head 为空
                // 就出栈中弹出一个
                head = stack.pop();
                System.out.println(head.value + "");
            }
        }
        System.out.println();
    }

    /**
     * 后序遍历，用 2 个栈实现
     *
     * @param head
     */
    public static void posOrderUnRecur1(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(head);
        while (!s1.isEmpty()) {
            head = s1.pop();
            s2.push(head);
            if (head.left != null) {
                s1.push(head.left);
            }
            if (head.right != null) {
                s1.push(head.right);
            }

        }
        // 遍历s2 ,打印结果
        while (!s2.isEmpty()) {

            System.out.println(s2.pop().value + " ");
        }

    }

    /**
     * 一个栈，实现树的遍历
     *
     * @param head
     */
    public void posOrderUnRecur2(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        Node c = null;
        while (!stack.isEmpty()) {
            c = stack.peek();
            if (c.left != null && head != c.left && head != c.right) {
                stack.push(c.left);
            } else if (c.right != null && head != c.right) {
                stack.push(c.right);
            } else {
                System.out.println(stack.pop().value + "");
                head = c;
            }
        }
        System.out.println();

    }


    /**
     * 打印二叉树的边界节点
     * @param head
     */
    public void printEdgel1(Node head) {
        if (head == null) {
            return;
        }

        int height = getHeight(head, 0);
        Node[][] edgeMap = new Node[height][2];
        setEdgeMap(head, 0, edgeMap);
        // 打印边界
        for (int i = 0; i != edgeMap.length; i++) {
            System.out.println(edgeMap[i][0] + " ");
        }
        // 打印既不是左边界，也不是右边界的叶子节点
        printLeafNotInMap(head, 0, edgeMap);
        // 打印右边界，但是不是左边界的节点
        for (int i = edgeMap.length - 1; i != -1; i--) {
            if (edgeMap[i][0] != edgeMap[i][1]) {
                System.out.print(edgeMap[i][i].value + "");
            }
            System.out.println();
        }
    }

    private int getHeight(Node head, int i) {
        if (head == null) {
            return 1;
        }
        return Math.max(getHeight(head.left, i + 1), getHeight(head.right, i + 1));
    }

    private void setEdgeMap(Node head, int i, Node[][] edgeMap) {
        if (head == null) {
            return;
        }
        edgeMap[1][0] = edgeMap[1][0] == null ? head : edgeMap[1][0];
        edgeMap[1][1] = head;
        setEdgeMap(head.left, 1 + i, edgeMap);
        setEdgeMap(head.right, 1 + i, edgeMap);
    }

    private void printLeafNotInMap(Node head, int i, Node[][] m) {
        if (head == null) {
            return;
        }
        if (head.left == null && head.right == null && head != m[1][0] && head!=m[1][1]) {
            System.out.print(head.value+ "");
        }
        printLeafNotInMap(head.left,i+1,m);
        printLeafNotInMap(head.right,i+1,m);

    }


}
