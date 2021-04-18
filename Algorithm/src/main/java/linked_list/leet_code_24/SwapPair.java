package linked_list.leet_code_24;

import java.util.List;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  4/17/21 1:25 PM
 * @Desc : 两两交换链表的节点（https://leetcode-cn.com/problems/swap-nodes-in-pairs/solution/）
 *
 *
 * 题解：https://lyl0724.github.io/2020/01/25/1/
 *  https://leetcode-cn.com/problems/swap-nodes-in-pairs/solution/hua-jie-suan-fa-24-liang-liang-jiao-huan-lian-biao/
 *
 *  https://www.bilibili.com/video/BV1VC4y1s75E?from=search&seid=11893794675564212966
 *
 *
 * 哎，还是多看看，反转链表，记住这些链表常见操作....
 */
public class SwapPair {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}
