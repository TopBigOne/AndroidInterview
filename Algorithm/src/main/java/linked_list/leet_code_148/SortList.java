package linked_list.leet_code_148;

import linked_list.ListNode;

import java.util.*;

/**
 * @author : dev
 * @version :
 * @Date :  2021/5/11 19:34
 * @Desc : 148：排序链表： -中等—字节：14次； https://leetcode-cn.com/problems/sort-list/
 * <p>
 * <p>
 * https://leetcode-cn.com/problems/sort-list/solution/sort-list-gui-bing-pai-xu-lian-biao-by-jyd/
 * <p>
 * 主要考察3个知识点：
 * 1： 归并排序的整体思想，
 * 2：找到一个链表中间节点的方法；
 * 3：合并两个已经排序好饿链表，
 */
public class SortList {
    /**
     * 没脑子的暴力的 借助第三方解法
     *
     * @param head 未排序的链表
     * @return 排序好的链表
     */
    public ListNode sortList1(ListNode head) {
        TreeMap<Integer, ListNode> map = new TreeMap<>();
        List<ListNode> list = new ArrayList<>();
        ListNode dummy = new ListNode(-1);
        // 将节点拆解成单个节点，放入List中
        while (head != null) {
            ListNode temp = head.next;
            head.next = null;
            list.add(head);
            head = temp;
        }

        // 利用list自带的排序：里面的节点，就是从小到大存放的
        list.sort(Comparator.comparingInt(o -> o.val));
        // 遍历节点列表，将其拼接到dummy下面
        for (ListNode listNode : list) {
            ListNode temp = dummy;
            while (temp.next != null) {
                temp = temp.next;
            }
            // 尾部插入
            temp.next = listNode;
        }
        return dummy.next;


    }



    /**
     * @param head 当前节点
     * @param n    size
     * @return  https://leetcode-cn.com/problems/sort-list/solution/148-pai-xu-lian-biao-bottom-to-up-o1-kong-jian-by-/
     */
    private ListNode cut(ListNode head, int n) {
        if (n <= 0) return head;
        ListNode p = head;
        while (--n > 0 && p != null) {
            p = p.next;
        }
        if (p == null) {
            return null;
        }
        ListNode next = p.next;
        p.next = null;

        return next;
    }

    /**
     * 这个代码：参考leetcode-21：https://leetcode-cn.com/problems/merge-two-sorted-lists/
     *
     * @param l1
     * @param l2
     * @return 合并以后的链表
     */
    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        curr.next = l1 == null ? l2 : l1;

        return dummy.next;

    }


    public ListNode sortList(ListNode head) {
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        dummyHead.next = head;
        // 先统计长度
        ListNode p = dummyHead.next;
        int length = 0;
        while (p != null) {
            length++;
            p = p.next;
        }
        // 循环开始切合和合并
        for (int size = 1; size < length; size <<= 1) {//我靠...每次除以2
            ListNode curr = dummyHead.next;
            ListNode tail = dummyHead;
            while (curr != null) {
                ListNode left = curr;
                // 链表切掉size，剩下的返还给right
                ListNode right = cut(curr, size);
                // 链表切掉size，剩下的返还给cur
                curr = cut(right, size);
                tail.next = merge(left, right);
                while (tail.next != null) {
                    // 保留最尾端
                    tail = tail.next;
                }
            }
        }
        return dummyHead.next;
    }

    /**
     * 归并排序
     *
     * @param head
     * @return
     */
    public ListNode sortList2(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode p = dummy.next;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }
        for (int size = 1; size < len; size <<= 1) {
            ListNode curr = dummy.next;
            ListNode tail = dummy;
            while (curr != null) {
                ListNode left = curr;
                // 链表切掉size ，剩下的返还给size
                ListNode right = cut(curr, size);
                // 剩下的返还给cur
                curr = cut(right, size);
                tail.next = merge(left, right);
                while (tail.next != null) {
                    tail = tail.next;
                }
            }
        }
        return dummy.next;
    }

    public ListNode sortList3(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode p = dummy.next;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }
        // 循环，切割 and 合并
        for (int size = 1; size < len; size <<= 1) {
            ListNode curr = dummy.next;
            ListNode tail = dummy;
            while (curr != null) {
                ListNode left = curr;
                ListNode right = cut(curr, size);
                // 剩下的返给cur
                curr = cut(right, size);
                tail.next = merge(left, right);
                while (tail.next != null) {
                    tail = tail.next;
                }
            }
        }
        return dummy.next;
    }

    public ListNode sortList4(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode p = dummy.next;
        int len = 0;
        while (p!=null){
            len++;
            p = p.next;
        }
        // 循环，切割，and 合并
        for (int size = 0; size < len; size<<=1) {
            ListNode curr = dummy.next;
            ListNode tail = dummy;
            while (curr!=null){
                ListNode left = curr;
                ListNode right = cut(curr,size);
                // 剩下的返给cur
                curr = cut(right,size);
                tail.next = merge(left,right);
                while (tail.next!=null){
                    tail = tail.next;
                }
            }

        }
        return dummy.next;

    }

}
