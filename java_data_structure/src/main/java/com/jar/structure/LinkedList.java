package com.jar.structure;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : Jakarta
 * @version :
 * @Date : 7/14/20 6:29 PM
 * @Desc :
 */
public class LinkedList {

    private Node          mNode;
    private AtomicInteger size = new AtomicInteger();

    public LinkedList() {
        mNode = new Node();
    }

    public boolean addHeaderElement(int value) {
        if (size.get() == 0) {
            mNode.value = value;
            size.incrementAndGet();
            return true;
        }

        size.incrementAndGet();
        Node newNode = new Node();
        newNode.value = value;
        mNode.pre = newNode;

        return true;
    }


    public boolean addTailElement(int value) {
        if (size.get() == 0) {
            mNode.value = value;
            size.incrementAndGet();
            return true;
        }

        // 尾部节点
        Node tailNode = getTailNode();
        size.incrementAndGet();
        Node newNode = new Node();
        newNode.value = value;

        tailNode.next = newNode;
        tailNode.next.pre = tailNode;
        return true;
    }

    private Node getTailNode() {
        Node reuslt = mNode;
        while (reuslt.next != null) {
            reuslt = reuslt.next;
        }

        return reuslt;
    }

    public boolean deleteElement(int value) {
        while (mNode != null && mNode.next != null) {
            if (mNode.value == value) {
                // 1: 恰巧是第一个位置，头节点,直接删除头节点；
                if (mNode.pre == null) {
                    Node next = mNode.next;
                    next.pre = null;
                    mNode = next;
                    return true;
                }
                // 2: 在尾部
//                if (mNode.next == null) {
//                    c.pre.next = null;
//                    return true;
//                }

                // 3: 在中间删除；
                // 删除节点的上一个
                Node pre = mNode.pre;
                // 删除节点的下一个
                pre.next = mNode.next;
                mNode.next.pre = pre;
            }
        }

        return false;
    }

    public Node getNode() {
        return mNode;
    }

}