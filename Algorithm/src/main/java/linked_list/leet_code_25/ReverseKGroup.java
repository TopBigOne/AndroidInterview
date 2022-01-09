package linked_list.leet_code_25;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2021/5/6 20:26
 * @Desc :  K个一组反转链表：字节：36次：https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * 题解：https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/tu-jie-kge-yi-zu-fan-zhuan-lian-biao-by-user7208t/
 * <p>
 * 视频：https://www.bilibili.com/video/BV1i44111721?from=search&seid=3623965927550448834
 * https://labuladong.gitee.io/algo/2/16/17/
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        // 定义一个假节点
        ListNode dummy = new ListNode(0);
        // dummy 指向head；
        // dummy->1->2->3->4->5;
        dummy.next = head;
        // 初始换pre 和end
        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            // 循环k次，找到需要循环的链表的结尾，这里每次循环判断end是否等于空，因为如果为空，end.next 会报空指针异常
            // dummy->1->2->3->4->5 若k为2，循环2次，end指向2；
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            // 如果end==null,即需要翻转的链表的节点小于k，不执行翻转
            if (end == null) {
                break;
            }

            // 先记录下end.next ,方便后面连接链表;
            ListNode next = end.next;
            // 然后断块链表
            end.next = null;
            // 记录下面翻转链表的头节点
            ListNode start = pre.next;
            // 翻转链表：pre.next指向翻转后的链表， 1->2 变成 2->1.  dummy->2->1;
            pre.next = reverse(start);
            // 翻转后节点变到最后。 通过.next 把断开的链表重新连接;
            start.next = next;
            // 将pre 换成下次要翻转的链表的头节点的上一个节点，即：start；
            pre = start;
            // 反转结束，将end设置为下次需要反转链表的头节点的上一个节点，即：start；
            end = start;
        }
        return dummy.next;

    }

    public ListNode reverseKGroup2(ListNode head, int k) {
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
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;

            pre = start;
            end = pre;


        }
        return dummy.next;

    }

    public ListNode reverseKGroup3(ListNode head, int k) {
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
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;

        }
        return dummy.next;

    }

    public ListNode reverseKGroup4(ListNode head, int k) {
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
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;

        }

        return dummy.next;
    }

    public ListNode reverseKGroup5(ListNode head, int k) {
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
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;

        }
        return dummy.next;

    }

    public ListNode reverseKGroup6(ListNode head, int k) {
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
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;

            pre = start;
            end = pre;
        }

        return dummy.next;


    }


    /**
     * 链表翻转
     *
     * @param head 头节点
     * @return 反转以后的链表
     */
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;


    }


}
