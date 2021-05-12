package linked_list.leet_code_21;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2021/5/11 19:07
 * @Desc : 简单：合并两个有序链表  字节：34次：https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * 归并排序
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(-1);
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

    public ListNode mergeTwoList4(ListNode l1,ListNode l2){
        if (l1==null) {
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (l1!=null&&l2!=null){
            if(l1.val<l2.val){
                curr.next= l1;
                l1= l1.next;
            }else {
                curr.next= l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        curr.next = l1==null? l2:l1;
        return dummy.next;

    }
}
