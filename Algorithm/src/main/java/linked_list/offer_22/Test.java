package linked_list.offer_22;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  5/16/21 12:34 PM
 * @Desc :
 */
public class Test {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        GetKthFromEnd getKthFromEnd = new GetKthFromEnd();
        ListNode result = getKthFromEnd.getKthFromEnd(head, 2);
        System.out.println("result: " + result);
    }


}
