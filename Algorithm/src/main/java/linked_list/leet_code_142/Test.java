package linked_list.leet_code_142;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2021/5/21 14:46
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next;

        DetectCycle detectCycle = new DetectCycle();
        detectCycle.detectCycle(head);

    }
}
