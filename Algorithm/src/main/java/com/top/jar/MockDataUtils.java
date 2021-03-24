package com.top.jar;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 产生假数据的工具类
 */
public class MockDataUtils {
    /**
     *  生成一个二叉树
     * @param params 可变参数
     * @return
     */
    public static TreeNode generateTree(Integer ...params) {
        List<Integer> integerList = new ArrayList<>(Arrays.asList(params));

        Integer[] integer = new Integer [integerList.size()];
        return createBinaryTreeByArray(integerList.toArray(integer),0);
    }

    private  static TreeNode createBinaryTreeByArray(Integer[]array, int index)
    {
        TreeNode tn = null;
        if (index<array.length) {
            int value = array[index];

            tn = new TreeNode(value);
            tn.left = createBinaryTreeByArray(array, 2*index+1);
            tn.right = createBinaryTreeByArray(array, 2*index+2);
            return tn;
        }
        return tn;
    }


}
