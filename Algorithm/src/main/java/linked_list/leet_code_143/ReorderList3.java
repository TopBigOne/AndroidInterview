package linked_list.leet_code_143;

import linked_list.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/2/1 17:28
 * @Url : https://leetcode-cn.com/problems/reorder-list/discuss/44992/Java-solution-with-3-steps/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china
 * @Level :    medium
 * @Desc :
 * @Counter :11
 * @Answer : https://leetcode-cn.com/problems/reorder-list/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-34/
 */
public class ReorderList3 {
    /**
     * https://leetcode-cn.com/problems/reorder-list/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-34/
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null) return;
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        int start = 0;
        int end = list.size() - 1;
        while (start < end) {
            list.get(start++).next = list.get(end);
            if (start == end) {
                break;
            }
            list.get(end--).next = list.get(start);
        }
        list.get(start).next = null;
    }

    public void reorderList2(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        int start = 0;
        int end = list.size() - 1;
        while (start < end) {
            list.get(start++).next = list.get(end);
            if (start == end) {
                break;
            }
            list.get(end--).next = list.get(start);
        }
        list.get(start).next = null;

    }
}
