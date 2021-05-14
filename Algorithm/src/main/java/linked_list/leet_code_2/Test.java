package linked_list.leet_code_2;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2021/3/23 20:47
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {
        ListNode head1= new ListNode(6);
        head1.next = new ListNode(1);
        head1.next.next = new ListNode(7);


        ListNode head2= new ListNode(2);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(5);

        AddTwoNumber addTwoNumber = new AddTwoNumber();
        ListNode result = addTwoNumber.addTwoNumbers3(head1, head2);
        while (result != null) {
            System.out.print(result.val+"-->");
            result = result.next;
        }

    }
}
