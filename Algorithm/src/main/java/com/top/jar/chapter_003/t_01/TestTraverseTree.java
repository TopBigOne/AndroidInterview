package com.top.jar.chapter_003.t_01;

import com.top.jar.MockDataUtils;

public class TestTraverseTree {
    public static void main(String[] args) {
      TreeNode head =  MockDataUtils.generateTree(1,2,3,4,5,6,7);

        TraverseTree traverseTree  = new TraverseTree();

        traverseTree.posOrderUnRecur2(head);


    }
}
