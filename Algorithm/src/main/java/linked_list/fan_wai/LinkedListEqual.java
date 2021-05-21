package linked_list.fan_wai;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2021/5/21 13:49
 * @Desc : 测试链表是否相等
 */
public class LinkedListEqual {
    public static void main(String[] args) {
        boolean result = test1();
        System.out.println("result: "+result);
    }

    private static boolean test1() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(3);
        l2.next.next.next = new ListNode(5);

        if (l1==l2) {
            return true;
        }
        return false;
    }
}
