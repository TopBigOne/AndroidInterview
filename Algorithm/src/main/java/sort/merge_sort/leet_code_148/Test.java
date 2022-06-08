package sort.merge_sort.leet_code_148;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2021/5/11 19:42
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {
        SortList sortList = new SortList();
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        ListNode result = sortList.sortList(head);
        System.out.println("result: "+result.toString());

    }
}
