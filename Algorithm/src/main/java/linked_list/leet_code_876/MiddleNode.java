package linked_list.leet_code_876;

import linked_list.ListNode;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/8/26 23:29
 * @Url : https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * @Level :  easy
 * @Desc : 链表的中间节点
 * @Counter : 2次
 * @Answer :  https://leetcode-cn.com/problems/middle-of-the-linked-list/solution/kuai-man-zhi-zhen-zhu-yao-zai-yu-diao-shi-by-liwei/
 */
public class MiddleNode {
    /**
     * 使用两个指针变量，刚开始都位于链表的第 1 个结点，一个永远一次只走 1 步，一个永远一次只走 2 步，一个在前，一个在后，同时走。
     * 这样当快指针走完的时候，慢指针就来到了链表的中间位置。
     * 思想是：快慢指针的前进方向相同，且它们步伐的「差」是恒定的，
     * 根据这种确定性去解决链表中的一些问题。使用这种思想还可以解决链表的以下问题：
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    public ListNode middleNode2(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }
}
