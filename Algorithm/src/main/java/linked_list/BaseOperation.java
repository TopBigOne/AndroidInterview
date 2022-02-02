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
public class BaseOperation {
    public static ListNode generateListNode(int... node) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        for (int i : node) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        return dummy.next;
    }
}
