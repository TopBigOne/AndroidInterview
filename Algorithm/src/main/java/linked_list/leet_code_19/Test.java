package linked_list.leet_code_19;

import linked_list.ListNode;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/14 23:14
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class Test {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(6);

        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        //  倒数第二个
        removeNthFromEnd.removeNthFromEnd(listNode, 3);

    }
}
