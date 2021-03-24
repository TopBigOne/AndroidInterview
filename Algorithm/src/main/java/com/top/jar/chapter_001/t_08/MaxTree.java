package com.top.jar.chapter_001.t_08;

import tree.TreeNode;

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
        TreeNode maxTree = getMaxTree(arr);
    }

    private static TreeNode getMaxTree(int[] arr) {
        TreeNode[] nArr = new TreeNode[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nArr[i] = new TreeNode(arr[i]);
        }

        Stack<TreeNode> stack = new Stack<>();
        HashMap<TreeNode, TreeNode> lBigMap = new HashMap<>();
        HashMap<TreeNode, TreeNode> rBigMap = new HashMap<>();

        for (int i = 0; i != nArr.length; i++) {
            TreeNode curTreeNode = nArr[i];
            while ((!stack.isEmpty()) && stack.peek().val < curTreeNode.val) {
                popStackSetMap(stack, lBigMap);
            }
            stack.push(curTreeNode);
        }

        while (!stack.isEmpty()) {
            popStackSetMap(stack, lBigMap);
        }
        for (int i = nArr.length - 1; i != -1; i--) {
            TreeNode curTreeNode = nArr[i];
            while ((!stack.isEmpty()) && stack.peek().val < curTreeNode.val) {
                popStackSetMap(stack, rBigMap);
            }
            stack.push(curTreeNode);
        }
        while (!stack.isEmpty()) {
            popStackSetMap(stack, rBigMap);
        }
        TreeNode head = null;
        for (int i = 0; i != nArr.length; i++) {
            TreeNode curTreeNode = nArr[i];
            TreeNode left = lBigMap.get(curTreeNode);
            TreeNode right = rBigMap.get(curTreeNode);
            if (left == null && right == null) {
                head = curTreeNode;
            } else if (left == null) {
                if (right.left == null) {
                    right.left = curTreeNode;
                } else {
                    right.right = curTreeNode;
                }
            } else if (right == null) {
                if (left.left == null) {
                    left.left = curTreeNode;
                } else {
                    left.right = curTreeNode;
                }
            } else {
                TreeNode parent = left.val < right.val ? left : right;
                if (parent.left == null) {
                    parent.left = curTreeNode;
                } else {
                    parent.right = curTreeNode;
                }
            }
        }
        return head;
    }

    private static void popStackSetMap(Stack<TreeNode> stack, HashMap<TreeNode, TreeNode> map) {
        TreeNode popTreeNode = stack.pop();
        if (stack.isEmpty()) {
            map.put(popTreeNode, null);
        } else {
            map.put(popTreeNode, stack.peek());
        }

    }
}
