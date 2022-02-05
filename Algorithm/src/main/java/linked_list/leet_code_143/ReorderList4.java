package linked_list.leet_code_143;

import linked_list.ListNode;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/2/1 18:04
 * @Url : https://leetcode-cn.com/problems/reorder-list/
 * @Level :    medium
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class ReorderList4 extends BaseOperation {

    public void reorderList(ListNode head) {
        // step 1: base corner;
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        // find the middle node;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode newHead = slow.next;
        slow.next = null;// help GC, and avoid cycle listNode
        newHead = reverseListNode(newHead);

        // 链表节点，依次连接
        while (newHead != null) {
            ListNode temp = newHead.next;
            // 连接
            newHead.next = head.next;
            head.next = newHead;

            //交换
            head = newHead.next;
            newHead = temp;
        }
    }

    public void reorderList2(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = slow.next;
        slow.next = null;
        newHead = reverseListNode(newHead);
        while (newHead != null) {
            ListNode temp = newHead.next;

            newHead.next = head.next;
            head.next = newHead;

            head = newHead.next;
            newHead = temp;
        }
    }

    public void reorderList3(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode newNode = slow.next;
        slow.next = null;
        newNode = reverseListNode(newNode);
        while (newNode != null) {
            ListNode temp = newNode.next;

            newNode.next = head.next;
            head.next = newNode;

            head = newNode.next;
            newNode = temp;

        }

    }

    public void reorderList4(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode newNode = slow.next;
        slow.next = null;
        newNode = reverseListNode(newNode);

        while (newNode != null) {
            ListNode temp = newNode.next;
            newNode.next = head.next;
            head.next = newNode;

            head = newNode.next;
            newNode = temp;
        }


    }

    public void reorderList5(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode newNode = slow.next;
        slow.next = null;
        newNode = reverseListNode(newNode);

        while (newNode != null) {
            ListNode temp = newNode.next;
            newNode.next = head.next;
            head.next = newNode;
            head = newNode.next;
            newNode = temp;
        }


    }

    public void reorderList6(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode newNode = slow.next;
        slow.next = null;

        newNode = reverseListNode2(newNode);
        while (newNode != null) {
            ListNode removeNode = newNode.next;
            newNode.next = head.next;
            head.next = newNode;
            head = newNode.next;
            newNode = removeNode;
        }
    }


}
