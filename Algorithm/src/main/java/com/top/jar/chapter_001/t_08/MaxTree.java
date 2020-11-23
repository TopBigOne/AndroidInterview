package com.top.jar.chapter_001.t_08;

import com.top.jar.Node;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author : Jakarta
 * @version :
 * @Date : 2020-06-23 23:34
 * @Desc :
 * 1：数组必须没有重复元素；
 * 2：MaxTree 是一棵二叉树，数组的每一个值对应一个二叉树节点；
 * 3：包括 MaxTree 树在内，且咋其中的每一个树上，值最大的节点，都是头；
 * ----------------------------------------------------------------------------
 * 原则：
 * 1： 每一个数的父节点是 ta 左边第一个比 ta 大的数，和它右边第一个比 ta 大的数中，比较小的那个；
 * 2： 如果一个数左边没有比ta 大的数，右边也没有；这个数，就是头节点；
 */
public class MaxTree {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        Node maxTree = getMaxTree(arr);
    }

    private static Node getMaxTree(int[] arr) {
        Node[] nArr = new Node[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nArr[i] = new Node(arr[i]);
        }

        Stack<Node> stack = new Stack<>();
        HashMap<Node, Node> lBigMap = new HashMap<>();
        HashMap<Node, Node> rBigMap = new HashMap<>();

        for (int i = 0; i != nArr.length; i++) {
            Node curNode = nArr[i];
            while ((!stack.isEmpty()) && stack.peek().value < curNode.value) {
                popStackSetMap(stack, lBigMap);
            }
            stack.push(curNode);
        }

        while (!stack.isEmpty()) {
            popStackSetMap(stack, lBigMap);
        }
        for (int i = nArr.length - 1; i != -1; i--) {
            Node curNode = nArr[i];
            while ((!stack.isEmpty()) && stack.peek().value < curNode.value) {
                popStackSetMap(stack, rBigMap);
            }
            stack.push(curNode);
        }
        while (!stack.isEmpty()) {
            popStackSetMap(stack, rBigMap);
        }
        Node head = null;
        for (int i = 0; i != nArr.length; i++) {
            Node curNode = nArr[i];
            Node left = lBigMap.get(curNode);
            Node right = rBigMap.get(curNode);
            if (left == null && right == null) {
                head = curNode;
            } else if (left == null) {
                if (right.left == null) {
                    right.left = curNode;
                } else {
                    right.right = curNode;
                }
            } else if (right == null) {
                if (left.left == null) {
                    left.left = curNode;
                } else {
                    left.right = curNode;
                }
            } else {
                Node parent = left.value < right.value ? left : right;
                if (parent.left == null) {
                    parent.left = curNode;
                } else {
                    parent.right = curNode;
                }
            }
        }
        return head;
    }

    private static void popStackSetMap(Stack<Node> stack, HashMap<Node, Node> map) {
        Node popNode = stack.pop();
        if (stack.isEmpty()) {
            map.put(popNode, null);
        } else {
            map.put(popNode, stack.peek());
        }

    }
}
