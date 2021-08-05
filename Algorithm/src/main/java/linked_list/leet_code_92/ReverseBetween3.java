package linked_list.leet_code_92;

import linked_list.ListNode;

/**
 * @author :  dev
 * @version :
 * @Date : 7/19/21 12:16 AM
 * @Url : https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * @Level :  medium
 * @Desc :   反转链表 II
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * @Counter : 23
 * @Answer : https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/java-shuang-zhi-zhen-tou-cha-fa-by-mu-yi-cheng-zho/
 * <p>
 * 比较好理解：
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/dong-hua-tu-jie-fan-zhuan-lian-biao-de-z-n4px/
 */
public class ReverseBetween3 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // dummy
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode preNode = dummy;
        for (int i = 0; i < left - 1; i++) {
            preNode = preNode.next;
        }
        // tail : 表示已经反转过的节点
        ListNode tail = preNode.next;
        ListNode cur = tail.next;
        // 左节点到右子节点之间的元素，进行反转（头插，插到前继节点的后面）
        // 头插的次数为 right-left;
        for (int i = 0; i < right - left; i++) {
            ListNode temp = cur.next;
            cur.next = preNode.next;
            preNode.next = cur;
            tail.next = temp;
            cur = temp;
        }
        return dummy.next;
    }

    public ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode preNode = dummy;
        for (int i = 0; i < left - 1; i++) {
            preNode = preNode.next;
        }

        ListNode tail = preNode.next;
        ListNode cur = tail.next;

        for (int i = 0; i < right - left; i++) {
            ListNode temp = cur.next;
            cur.next = preNode.next;
            preNode.next = cur;
            cur = temp;
            tail.next = temp;
        }

        return dummy.next;
    }


}
