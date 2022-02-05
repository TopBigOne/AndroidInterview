package linked_list.leet_code_23;

import linked_list.ListNode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/2/4 01:46
 * @Url :字节：23  leetcode 23 : 合并K个升序链表 ；https://leetcode-cn.com/problems/merge-k-sorted-lists/solution/
 * @Level :    medium
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class MergeKList4 {

    public ListNode mergeKList(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);


        for (ListNode list : lists) {
            if (list==null) {
                continue;
            }
            queue.add(list);
        }

        queue.addAll(Arrays.asList(lists));
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (!queue.isEmpty()) {

            ListNode minNode = queue.remove();
            curr.next = minNode;
            curr = curr.next;
            if (minNode.next != null) {
                queue.add(minNode.next);
            }

        }
        return dummy.next;

    }
}
