package linked_list.offer_18;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/2 17:15
 * @Desc : 删除链表中的节点：https://leetcode.cn/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 * 题解：https://leetcode.cn/problems/shan-chu-lian-biao-de-jie-dian-lcof/solution/mian-shi-ti-18-shan-chu-lian-biao-de-jie-dian-sh-2/
 */
public class DeleteNode {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(1);
        l1.next.next.next = new ListNode(9);

        DeleteNode deleteNode = new DeleteNode();
        ListNode result = deleteNode.deleteNode(l1, 9);
        while (result != null) {
            System.out.println(" Node " + result.val);
            result = result.next;
        }

    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        if (head.val == val) {
            return head.next;
        }

        ListNode curr = head;

        while (curr.next != null && curr.next.val != val) {
            curr = curr.next;

        }
        if (curr.next != null) {
            curr.next = curr.next.next;
            curr.next = null;
        }

        return head;
    }

    public ListNode deleteNode2(ListNode head, int val) {
        // base corner
        if (head == null) {
            return null;
        }
        //delete the head node;
        if (head.val == val) {
            return head.next;
        }
        ListNode curr = head;
        while (curr.next != null && curr.next.val != val) {
            curr = curr.next;
        }
        // find the target value;
        if (curr.next != null) {
            curr.next = curr.next.next;
        }

        return head;
    }

    public ListNode deleteNode3(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        if (head.val == val) {
            return head.next;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        // 有点像滚动数组
        while (fast != null && fast.val != val) {
            slow = fast;
            fast = fast.next;
        }
        if (fast != null) {
            slow.next = fast.next;
        }
        return head;

    }
}
