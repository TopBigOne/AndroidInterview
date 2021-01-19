package com.jar.structure;

import com.jar.structure.list.LinkedList;

/**
 * @author : Jakarta
 * @version :
 * @Date : 7/14/20 6:57 PM
 * @Desc :
 */
public class TestListNode {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addTailElement(2);
        linkedList.addTailElement(3);
        linkedList.addTailElement(5);
        linkedList.addTailElement(27);
        linkedList.addTailElement(21);
        linkedList.addTailElement(1);
        linkedList.addTailElement(0);

        printNode(linkedList);
        linkedList.deleteElement(2);
        System.out.println("删除 2：");
        printNode(linkedList);

    }

    private static void printNode(LinkedList linkedList) {
        Node node = linkedList.getNode();
        while (node.next != null) {
            int value = node.value;
            System.out.println("node value :" + value);
            node = node.next;
        }
    }
}
