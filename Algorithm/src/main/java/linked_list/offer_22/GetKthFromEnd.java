package linked_list.offer_22;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  5/15/21 10:39 PM
 * @Desc : 字节：23 次，面试题 获取链表中倒数第 K 个节点
 * <p>
 * 参考 LeetCode 19 删除链表倒数第 n 的元素；https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        //  fast!=null； 防止越界
        for (int i = 0; i < k && fast != null; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }


}
