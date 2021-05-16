package linked_list.leet_code_23;

import java.util.List;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  5/16/21 4:39 PM
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {
        MergeKList mergeKList = new MergeKList();

        ListNode[] rawNodes = new ListNode[3];

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        rawNodes[0] = l1;
        rawNodes[1] = l2;
        rawNodes[2] = l3;

        ListNode result = mergeKList.mergeKLists3(rawNodes);
        System.out.println("result : " + result);
    }
}
