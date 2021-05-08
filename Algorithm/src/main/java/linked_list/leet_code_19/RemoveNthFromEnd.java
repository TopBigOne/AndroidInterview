package linked_list.leet_code_19;

import java.util.List;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2021/5/7 21:16
 * @Desc :  （用快慢指针）删除链表的倒数第 N 个结点 字节：13
 * ：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // 慢指针初始指向虚拟头结点
        ListNode slow = dummyHead;
        // 快指针初始指向虚拟头结点
        ListNode fast = dummyHead;

        // 快指针先向前移动n+1步
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // 快慢指针同时向前移动，直到快指针指向null
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 慢指针的下一个节点即待删除节点
        ListNode delNode = slow.next;
        // 慢指针的后继指针指向待删除节点的下一个节点
        // 这样就将待删除节点删除了
        slow.next = delNode.next;
        delNode.next = null;
        return dummyHead.next;

    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;
        // 快指针向前移动n+1步
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        // 快慢指针同时向前移动，直到快指针指向null；
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 慢指针的下一个节点，就是要删除额节点
        ListNode delNode = slow.next;

        // 慢指针的后继节点指向待删除节点的下一个节点
        slow.next = delNode.next;
        delNode.next = null;// help GC;
        return dummy.next;

    }

    /**
     * @param head
     * @param n    倒数第 n 个
     * @return
     */
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        // 快指针向后移动 n+1 步
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        // 快慢指针同时向后移动，直到快指针的下一个指针为 null；
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // now，慢指针的下一个节点，就是要删除的节点
        ListNode delNode = slow.next;
        slow.next = delNode.next;
        delNode.next = null;// help GC;
        return dummy.next;

    }

    public ListNode removeNthFromEnd4(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        ListNode delNode = slow.next;
        slow.next = delNode.next;
        delNode.next = null;
        return dummy.next;

    }

    public ListNode removeNthFromEnd5(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode delNode = slow.next;
        slow.next = delNode.next;
        delNode.next = null;// help GC;

        return dummy.next;
    }


}
