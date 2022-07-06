package linked_list.leet_code_23;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/6 16:37
 * @Desc :
 * <p>
 * 字节：23  leetcode 23 : 合并K个升序链表 ；https://leetcode-cn.com/problems/merge-k-sorted-lists/solution/
 */
public class MergeKList5 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
       // minHeap.addAll(Arrays.asList(lists));

        for (ListNode list : lists) {
            if (list==null) {
                continue;
            }
            minHeap.add(list);
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (!minHeap.isEmpty()) {

            ListNode removeNode = minHeap.remove();
            curr.next = removeNode;
            curr = curr.next;
            if (removeNode.next != null) {
                minHeap.add(removeNode.next);
            }
        }
        return dummy.next;
    }
}
