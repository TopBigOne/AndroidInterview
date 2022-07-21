package sort.merge_sort.leet_code_148;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/21 00:47
 * @Desc : 自顶向下」的「归并排序」的写法--不适合面试；
 * https://leetcode.cn/problems/sort-list/solution/zi-di-xiang-shang-de-gui-bing-pai-xu-java-dai-ma-b/
 */
public class SortList2 {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        //  找到链表的中点
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 定义位于中点节点的下一个节点，并断开后面的节点
        ListNode midNext = slow.next;
        slow.next = null;
        ListNode listNodeLeft = sortList(head);
        ListNode listNodeRight = sortList(midNext);

        // 合并两个已经有序的单链表，这是我们很熟悉的操作
        return mergeOfTwoSortListNode(listNodeLeft, listNodeRight);

    }

    /**
     * 合并两个有序链表
     * @param l1
     * @param l2
     * @return
     */
    private ListNode mergeOfTwoSortListNode(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeOfTwoSortListNode(l1.next, l2);
            return l1;
        }
        l2.next = mergeOfTwoSortListNode(l1, l2.next);
        return l2;
    }


}
