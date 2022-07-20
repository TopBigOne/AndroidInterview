package linked_list.leet_code_21;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/20 01:36
 * @Desc :
 */
public class MergeTwoLists3 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) {
                curr.next = new ListNode(list1.val);
                list1 = list1.next;

            } else {
                curr.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            curr = curr.next;
        }

        curr.next = list1 == null ? list2 : list1;

        return dummy.next;

    }


}
