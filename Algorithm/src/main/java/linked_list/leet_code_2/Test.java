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
        ListNode head1= new ListNode(2);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(3);


        ListNode head2= new ListNode(5);
        head2.next = new ListNode(6);
        head2.next.next = new ListNode(4);

        AddTwoNumber addTwoNumber = new AddTwoNumber();
        addTwoNumber.addTwoNumbers2(head1,head2);

    }
}
