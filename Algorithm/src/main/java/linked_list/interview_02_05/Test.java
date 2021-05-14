package linked_list.interview_02_05;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2021/5/14 21:02
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {
        test1();
//        test2();
    }
    private static void test1() {
        AddTwoNumber addTwoNumber = new AddTwoNumber();

        ListNode l1 = new ListNode(6);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(7);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(5);
        ListNode result = addTwoNumber.addTwoNumbers(l1, l2);


        while (result != null) {
            System.out.print(result.val + "-->");
            result = result.next;

        }
    }

    @Deprecated
    private static void test2() {
        AddTwoNumber addTwoNumber = new AddTwoNumber();

        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(6);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(2);
        ListNode result = addTwoNumber.addTwoNumbers(l1, l2);


        while (result != null) {
            System.out.print(result.val + "-->");
            result = result.next;

        }
    }
}
