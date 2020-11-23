package com.top.jar;

/**
 * @author : Jakarta
 * @version :
 * @Date : 2020-06-23 23:32
 * @Desc : 公用的树节点
 */
public class Node {
    public int  value;
    public Node left;
    public Node right;

    public Node(int data) {
        this.value = data;
    }
}
