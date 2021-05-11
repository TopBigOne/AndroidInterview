package linked_list.leet_code_148;

import linked_list.ListNode;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author : dev
 * @version :
 * @Date :  2021/5/11 19:34
 * @Desc : 148 -中等—字节：14次； https://leetcode-cn.com/problems/sort-list/
 */
public class SortList {
    /**
     * 没脑子的借助第三方解法
     *
     * @param head
     * @return
     */
    public ListNode sortList1(ListNode head) {
        TreeMap<Integer, ListNode> map = new TreeMap<>();
        ListNode dummy = new ListNode(-1);
        while (head != null) {
            map.put(head.val, head);
            head = head.next;
        }

        for (Map.Entry<Integer, ListNode> nodeEntry : map.entrySet()) {
            insert(dummy, nodeEntry.getValue());

        }
        return dummy.next;

    }

    private void insert(ListNode dummy, ListNode value) {

        ListNode temp = dummy;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = value;


    }


}
