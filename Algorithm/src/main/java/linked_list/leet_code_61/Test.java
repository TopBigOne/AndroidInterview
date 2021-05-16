package linked_list.leet_code_61;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  5/17/21 12:16 AM
 * @Desc :
 */
public class Test {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);


        RotateRight rotateRight = new RotateRight();
        ListNode result = rotateRight.rotateRight(head, 2);
        System.out.println("result : "+result);


    }

}
