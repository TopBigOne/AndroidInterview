package linked_list.leetcode_92;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2021/3/22 10:52
 * @Desc : 反转链表2（https://leetcode-cn.com/problems/reverse-linked-list-ii/）
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
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

    public ListNode reverseBetween3(ListNode head,int left ,int right){
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode g= dummyHead;
        ListNode p = dummyHead.next;
        int step = 0;
        while (step<left-1){
            g  = g.next;
            p = p.next;
            step++;
        }
        for(int i = 0;i<right-left;i++){
            ListNode removed = p.next;
            p.next = p.next.next;
            removed.next = g.next;
            g.next = removed;
        }

        return dummyHead.next;


    }

}
