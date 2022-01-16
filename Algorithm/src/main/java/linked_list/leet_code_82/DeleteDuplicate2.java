package linked_list.leet_code_82;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  1/16/22 9:37 AM CyclicBarrier
 * @Desc :  leetcode 82: 删除排序链表中的重复元素II：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class DeleteDuplicate2 {
    public ListNode deleteDuplicates(ListNode head) {
        // 1: base corner
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;

        while (curr.next != null && curr.next.next != null) {
            // 相等
            if (curr.next.val == curr.next.next.val) {
                int tempValue = curr.next.val;
                while (curr.next != null && tempValue == curr.next.val) {
                    curr.next = curr.next.next;
                }
                continue;
            }
            curr = curr.next;
        }
        return dummy.next;


    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr.next != null && curr.next.next != null) {
            if (curr.next.val == curr.next.next.val) {
                int tempValue = curr.next.val;
                while (curr.next != null && tempValue == curr.next.val) {
                    curr.next = curr.next.next;
                }
                continue;
            }
            curr = curr.next;
        }
        return dummy.next;
    }

    public ListNode deleteDuplicates3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cuur = dummy;
        while (cuur.next != null && cuur.next.next != null) {
            if (cuur.next.val == cuur.next.next.val) {
                int tempValue = cuur.next.val;
                while (cuur.next != null && tempValue == cuur.next.val) {
                    cuur.next = cuur.next.next;
                }
                continue;
            }
            cuur = cuur.next;

        }
        return dummy.next;
    }

    public ListNode deleteDuplicates4(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;

        while (curr.next != null && curr.next.next != null) {
            // 相等
            if (curr.next.val == curr.next.next.val) {
                int tempValue = curr.next.val;
                while (curr.next != null && tempValue == curr.next.val) {
                    curr.next = curr.next.next;
                }
                continue;
            }
            curr = curr.next;
        }
        return dummy.next;
    }

    public ListNode deleteDuplicates5(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;

        while (curr.next != null && curr.next.next != null) {
            if (curr.next.val == curr.next.next.val) {
                int tempValue = curr.next.val;
                while (curr.next != null && tempValue == curr.next.val) {
                    curr.next = curr.next.next;
                }
                continue;
            }

            curr = curr.next;
        }
        return dummy.next;


    }
}
