package linked_list.leet_code_23;


import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  7/10/21 8:02 PM
 * @Desc :
 */
public class MergeKList2 {
    public ListNode mergeKList(ListNode[] lists) {
        // 最小堆
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.add(list);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (minHeap.size() != 0) {
            ListNode minNode = minHeap.remove();
            curr.next = minNode;
            curr = curr.next;

            if (curr.next != null) {
                minHeap.add(minNode.next);
            }
        }
        return dummy.next;

    }

    public ListNode mergeList2(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> (a.val - b.val));
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.add(list);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (minHeap.size() != 0) {
            ListNode minNode = minHeap.remove();
            curr.next = minNode;
            curr = curr.next;

            if (curr.next != null) {
                minHeap.add(minNode.next);
            }
        }

        return dummy.next;
    }
}
