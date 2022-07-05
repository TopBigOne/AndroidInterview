package linked_list.delete_duplicate_node.leet_code_83;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/4 19:39
 * @Desc : 83: 删除排序链表中的重复元素 ： https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * 不删除重复元素
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list/solution/hua-jie-suan-fa-83-shan-chu-pai-xu-lian-biao-zhong/
 */
public class DeleteDuplicate2 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return curr;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
}
