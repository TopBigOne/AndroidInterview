package linked_list.leet_code_25;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2021/5/6 21:46
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {
        ReverseKGroup reverseKGroup = new ReverseKGroup();
        reverseKGroup.reverseKGroup(getListNode(),3);
    }

    private static ListNode getListNode() {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);
        node1.next.next.next.next.next = new ListNode(6);
        node1.next.next.next.next.next.next = new ListNode(7);
        node1.next.next.next.next.next.next.next = new ListNode(8);
        return node1;
    }
}
