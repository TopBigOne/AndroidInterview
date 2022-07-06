package linked_list.leet_code_23;

import java.util.List;
import java.util.PriorityQueue;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/6 16:53
 * @Desc :
 * 字节：23  leetcode 23 : 合并K个升序链表 ；https://leetcode-cn.com/problems/merge-k-sorted-lists/solution/
 */
public class MergeKList6 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.add(list);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (!minHeap.isEmpty()) {

            ListNode minNode = minHeap.remove();
            curr.next = minNode;
            curr = curr.next;
            if (minNode.next != null) {
                minHeap.add(minNode.next);
            }

        }
        return dummy.next;
    }
}
