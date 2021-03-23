package linked_list.leetcode_92;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2021/3/22 10:52
 * @Desc : 反转链表2（https://leetcode-cn.com/problems/reverse-linked-list-ii/） 可以看看 206
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/dong-hua-tu-jie-fan-zhuan-lian-biao-de-z-n4px/
 * 题解：https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/java-shuang-zhi-zhen-tou-cha-fa-by-mu-yi-cheng-zho/
 */
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // 初始化指针；
        ListNode g = dummyHead;
        ListNode p = dummyHead.next;

        // 将指针挪到相应位置
        int step = 0;
        while (step < left - 1) {
            g = g.next;
            p = p.next;
            step++;
        }
        // 头插法：插入节点；
        for (int i = 0; i < right - left; i++) {
            ListNode removed = p.next;
            p.next = p.next.next;

            removed.next = g.next;
            g.next = removed;
        }
        return dummyHead.next;

    }

    public ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode dummHead = new ListNode(0);
        dummHead.next = head;
        ListNode g = dummHead;
        ListNode p = dummHead.next;

        int step = 0;
        while (step < left - 1) {
            g = g.next;
            p = p.next;
            step++;
        }
        for (int i = 0; i < right - left; i++) {
            ListNode removed = p.next;
            p.next = p.next.next;

            removed.next = g.next;
            g.next = removed;
        }
        return dummHead.next;

    }

    public ListNode reverseBetween3(ListNode head, int left, int right) {
        // 设置一个哑巴节点，没有值的节点
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode pre = dummyNode;

        ListNode p = dummyNode.next;
        int step = 0;
        while (step < left - 1) {
            pre = pre.next;
            p = p.next;
            step++;
        }
        for (int i = 0; i < right - left; i++) {
            ListNode removed = p.next;
            p.next = p.next.next;
            removed.next = pre.next;
            pre.next = removed;
        }
        return dummyNode.next;
    }

    public ListNode reverseBetween4(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode preNode = dummyNode;

        // 从虚拟节点出发，走 left-1 步骤，到前继节点
        for (int i = 0; i < left - 1; i++) {
            preNode = preNode.next;

        }
        // tail 表示已经反转过的节点
        ListNode tail = preNode.next;
        // cur 表示即将反转的节点
        ListNode cur = tail.next;

        for (int i = 0; i < right - left; i++) {
            ListNode next = cur.next;
            cur.next = preNode.next;
            preNode.next = cur;
            tail.next = next;
            cur = next;

        }
        return dummyNode.next;
    }

    public ListNode reverseBetween5(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode preNode = dummyNode;

        // 从虚拟节点出发，走left-1步骤，到前继节点
        for (int i = 0; i < left - 1; i++) {
            preNode = preNode.next;
        }

        // tail 表示已经反转过的节点
        ListNode tail = preNode.next;
        // cur 表示即将反转的节点
        ListNode cur = tail.next;
        for (int i = 0; i < right - left; i++) {
            ListNode next = cur.next;
            cur.next = preNode.next;
            preNode.next = cur;
            tail.next = next;
            cur = next;
        }

        return dummyNode.next;
    }

    public ListNode reverseBetween6(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode preNode = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            preNode = preNode.next;
        }
        // tail ,已经反转过得节点
        ListNode tail = preNode.next;
        // cur ，表示即将被反转的节点
        ListNode cur = tail.next;
        for (int i = 0; i < right - left; i++) {
            ListNode next = cur.next;
            cur.next = preNode.next;

            preNode.next = cur;
            cur = next;
            tail.next = next;
        }
        return dummyNode.next;

    }

    public ListNode reverseBetween7(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode preNode = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            preNode = preNode.next;
        }

        ListNode tail = preNode.next;
        ListNode cur = tail.next;

        for (int i = 0; i < right - left; i++) {
            ListNode next = cur.next;
            cur.next = preNode.next;
            preNode.next = cur;
            cur = next;
            tail.next = next;
        }
        return dummyNode.next;

    }




    public ListNode reverseBetween8(ListNode head,int left ,int right){


    }


}
