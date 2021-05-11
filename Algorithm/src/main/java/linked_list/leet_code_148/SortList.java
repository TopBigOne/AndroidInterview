package linked_list.leet_code_148;

import linked_list.ListNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author : dev
 * @version :
 * @Date :  2021/5/11 19:34
 * @Desc : 148：排序链表： -中等—字节：14次； https://leetcode-cn.com/problems/sort-list/
 */
public class SortList {
    /**
     * 没脑子的借助第三方解法
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        TreeMap<Integer, ListNode> map = new TreeMap<>();
        List<ListNode> list = new ArrayList<>();
        ListNode dummy = new ListNode(-1);
        while (head != null) {
            ListNode temp = head.next;
            head.next = null;
            list.add(head);
            head = temp;
        }

        Collections.sort(list, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode listNode : list) {
            insert(dummy, listNode);
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
