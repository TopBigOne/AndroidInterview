package com.top.jar.chapter_003.t_01;

import com.top.jar.MockDataUtils;
import com.top.jar.Node;

public class TestTraverseTree {
    public static void main(String[] args) {
      Node head =  MockDataUtils.generateTree(1,2,3,4,5,6,7);

        TraverseTree traverseTree  = new TraverseTree();

        traverseTree.posOrderUnRecur2(head);


    }
}
