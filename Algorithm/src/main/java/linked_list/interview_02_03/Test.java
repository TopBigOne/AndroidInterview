package linked_list.interview_02_03;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  5/21/21 11:31 PM
 * @Desc :
 */
public class Test {


    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        node.next = new ListNode(5);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(9);

        ListNode delNode = new ListNode(5);

        DeleteNode deleteNode = new DeleteNode();
        ListNode res = deleteNode.deleteNode(node, delNode);
        System.out.println("res : " + res);


    }


}
