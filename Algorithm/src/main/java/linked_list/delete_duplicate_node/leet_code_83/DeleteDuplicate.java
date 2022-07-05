package linked_list.delete_duplicate_node.leet_code_83;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  5/15/21 9:56 PM
 * @Desc : 83: 删除排序链表中的重复元素 ： https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * 题解：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/solution/yuan-di-qu-chu-de-zhong-fu-yuan-su-yi-wen-miao-s-2/
 */
public class DeleteDuplicate {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            if (fast.val != slow.val) {
                // nums[slow]= nums[fast]
                slow.next = fast;
                //  slow++
                slow = slow.next;
            }
            // fast++;
            fast = fast.next;
        }
        // 断开与后面的重复元素的连接
        slow.next = null;
        return head;
    }

    /**
     * 当前链表与下一个链表做比较，相等的话就断开，然后连接当前链表的下一个的下一个；
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode curr = head;
        while (curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;

    }


}
