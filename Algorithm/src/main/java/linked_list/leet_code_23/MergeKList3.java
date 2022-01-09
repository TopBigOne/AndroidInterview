package linked_list.leet_code_23;

import linked_list.ListNode;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/1/8 18:53
 * @Url :
 * @Level :     hard
 * @Desc : 合并N 个有序队列
 * @Counter :
 * @Answer :
 */
public class MergeKList3 {
    public ListNode mergeKList(ListNode[] lists) {
        // 优先级队列
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : lists) {
            if(list!=null){
                queue.add(list);
            }

        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (!queue.isEmpty()) {
            ListNode minNode = queue.poll();
            curr.next = minNode;
            curr = curr.next;

            if (minNode.next != null) {
                queue.add(minNode.next);
            }
        }
        return dummy.next;

    }
}
