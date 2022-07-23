package linked_list.leet_code_328;

import linked_list.BaseLinkedList;
import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/23 04:05
 * @Desc : 328. 奇偶链表 ：https://leetcode.cn/problems/odd-even-linked-list/
 */
public class OddEvenList extends BaseLinkedList {

    public static void main(String[] args) {
        ListNode head = generateListNode(1, 2, 3, 4, 5);
        OddEvenList oddEvenList = new OddEvenList();
        ListNode result = oddEvenList.oddEvenList(head);
        printlnListNode(result);
    }

    public ListNode oddEvenList(ListNode head) {

        ListNode dummyOne = new ListNode(-1);
        ListNode dummyTwo = new ListNode(-1);

        ListNode currOne = dummyOne;
        ListNode currTwo = dummyTwo;

        int start = 1;
        while (head != null) {
            if ((start & 1) == 1) {
                //
                currOne.next = new ListNode(head.val);
                currOne = currOne.next;
            } else {
                currTwo.next = new ListNode(head.val);
                ;
                currTwo = currTwo.next;
            }
            head = head.next;
            start++;
        }
        // System.err.println("奇数下标的节点：");
        //  printlnListNode(dummyOne.next);
        // System.err.println("偶数下标的节点：");
        // printlnListNode(dummyTwo.next);
        currOne = dummyOne;
        while (currOne.next != null) {
            currOne = currOne.next;
        }
        currOne.next = dummyTwo.next;
        return dummyOne.next;

    }
}
