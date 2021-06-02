package linked_list.leetcode_92;

import linked_list.ListNode;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/6/2 18:49
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
public class ReverseBetween2 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ReverseBetween2 reverseBetween = new ReverseBetween2();
        ListNode result = reverseBetween.reverseBetween(head, 2, 4);

        System.out.println("result : " + result);

    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 1: dummy大法
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode preNode = dummy;
        // 从虚拟头节点开始，走left-1步，到left的前继节点
        for (int i = 0; i < left - 1; i++) {
            preNode = preNode.next;
        }
        // tail 表示已经反转过的节点
        ListNode tail = preNode.next;
        // cur 表示当前需要反转的节点
        ListNode cur = tail.next;
        //  左子节点到右子节点之间的元素，进行反转（头插，插到前继节点的后面）。
        // 头插的次数为 right-left
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
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode tail = pre.next;
        ListNode curr = tail.next;

        for (int i = 0; i < right - left; i++) {
            ListNode temp = curr.next;
            curr.next = pre.next;
            pre.next = curr;
            tail.next = temp;

            //
            curr = temp;
        }
        return  dummy.next;
    }


}
