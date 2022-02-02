package linked_list.leet_code_82;

import linked_list.BaseOperation;
import linked_list.ListNode;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/2/1 23:28
 * @Url :
 * @Level :    medium
 * @Desc :
 * @Counter : 7
 * @Answer : https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/solution/fu-xue-ming-zhu-di-gui-die-dai-yi-pian-t-wy0h/
 */
public class DeleteDuplicate3 extends BaseOperation {

    public static void main(String[] args) {
        ListNode node = generateListNode(1, 2, 2, 2);
        DeleteDuplicate3 deleteDuplicate = new DeleteDuplicate3();
        deleteDuplicate.deleteDuplicates(node);
    }


    /**
     * [1,2,3,3,4,4,5
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode curr = head;

        while (curr != null) {
            // 跳过当前的重复节点，使得cur指向当前重复元素的最后一个位置
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }
            if (pre.next == curr) {
                // pre 和 curr 之间没有重复节点，pre 往后移动一位
                pre = pre.next;
            } else {
                // pre->next 指向cur的下一个位置（相当于跳过了当前的重复元素）
                // 但是pre 不移动，仍然指向已经遍历的链表结尾
                pre.next = curr.next;
            }
            curr = curr.next;
        }

        return dummy.next;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = head;

        while (curr != null) {
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }

            if (pre.next == curr) {
                // pre 和curr 之间没有重复节点，pre 往后挪动一位
                pre = pre.next;
            } else {
                // pre -> next 指向cur的下一个位置： 相当于跳过了当前的重复元素
                // 但是pre 不移动，仍然指向已经遍历的链表结尾
                pre.next = curr.next;
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

        ListNode pre = dummy;
        ListNode curr = head;

        while (curr != null) {
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }
            //  pre 和curr之间没有重复节点，pre 往后挪一位
            if (pre.next == curr) {
                pre = pre.next;
            } else {
                // pre->next 指向curr->next ，相当于跳过了当前重复元素
                pre.next = curr.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }

    public ListNode deleteDuplicates4(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = head;
        while (curr != null) {
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }
            if (curr == pre.next) {
                pre = pre.next;
            } else {
                pre.next = curr.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
