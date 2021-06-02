package linked_list.interview_02_08;

import linked_list.ListNode;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/6/2 11:05
 * @Url :
 * @Level : easy medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class Test {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
       head.next.next.next.next = head.next;
        DetectCycle detectCycle = new DetectCycle();
        ListNode result = detectCycle.detectCycle(head);
        System.out.println("result : "+result.toString());
    }
}
