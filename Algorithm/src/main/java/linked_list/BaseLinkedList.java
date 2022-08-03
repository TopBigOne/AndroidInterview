package linked_list;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/2/1 23:41
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class BaseLinkedList {
    public static ListNode generateListNode(int... node) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        for (int i : node) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void printlnListNode(ListNode head) {
        if (head == null) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (head != null) {
            stringBuilder.append(head.val).append("->");
            head = head.next;
        }
        String string = stringBuilder.substring(0, stringBuilder.length() - 2);

        System.err.println(string);

    }




}
