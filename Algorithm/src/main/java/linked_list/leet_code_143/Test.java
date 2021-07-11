package linked_list.leet_code_143;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2021/5/11 10:28
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {
        ReorderList reorderList = new ReorderList();


        ListNode head = getHead();

        ListNode dummy = head;
        while (dummy != null) {
            System.out.print(dummy.val + "-->");
            dummy = dummy.next;
        }
        reorderList.reorderList6(head);

        System.out.println("\n|-------------------|");
        while (head != null) {
            System.out.print(head.val + "-->");
            head = head.next;
        }
    }

    public static ListNode getHead() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
       // head.next.next.next.next.next = new ListNode(6);
       // head.next.next.next.next.next.next = new ListNode(7);
        return head;
    }





}
