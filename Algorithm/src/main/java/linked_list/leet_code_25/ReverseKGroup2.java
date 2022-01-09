package linked_list.leet_code_25;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  6/4/21 1:01 AM
 * @Desc : k 个一组反转链表
 * https://labuladong.gitee.io/algo/2/16/17/
 */
public class ReverseKGroup2 {

    public ListNode reverseKGroup1(ListNode head, int k) {
        // 1: corner base
        if (head == null || head.next == null) {
            return head;
        }

        // 2:dummy 大法；
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 3： 定义 pre 和 end 节点
        ListNode pre = dummy;
        ListNode end = dummy;
        // TODO: 6/4/21  不明白，，为啥是 end；
        while (end.next != null) {
            // 4: 循环 k 次，找到 end 的节点，（同时最 end节点做非空判断）
            // 我思：是不是可以理解成 k
            // TODO: 6/4/21 end 是否为空
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }


            // ：记录下面翻转链表的头节点
            ListNode start = pre.next;
            // : 先记录下 end.next ,方便后面连接链表
            ListNode temp = end.next;
            // : 断开链表
            end.next = null;
            // : 翻转链表：pre.next ˙指向法案后的链表， 1->2 变成 2->1  ,即便：dummy->2->1;
            pre.next = reverse(start);
            // : star 节点和 temp 节点，连接起来
            start.next = temp;
            // ：将 pre 换成下次要翻转的链表的头节点的上一个节点，即：start
            pre = start;
            // ：反转结束，将 end 设置为下一个需要反转链表的头节点的上一个借点。即：start
            end = pre;

        }
        return dummy.next;
    }

    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    private ListNode reverse(ListNode head) {
        // corner base;
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }

            if (end == null) {
                break;
            }

            ListNode start = pre.next;
            ListNode temp = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = temp;

            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    public ListNode reverseKGroup2(ListNode head,int k){
        if (head==null||head.next==null) {
            return head;

        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end.next!=null){
            for (int i = 0; i < k&&end!=null; i++) {
                end= end.next;

            }
            if(end==null){
                break;
            }
            ListNode start = pre.next;
            ListNode temp = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = temp;

            pre = start;
            end = pre;
        }

        return dummy.next;

    }


}
