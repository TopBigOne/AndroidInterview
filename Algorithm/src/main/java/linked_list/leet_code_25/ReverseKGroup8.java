package linked_list.leet_code_25;

import linked_list.ListNode;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/2/1 15:45
 * @Url :
 * @Level :   hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class ReverseKGroup8 extends BaseOperation {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        // dummy
        ListNode dummy = new ListNode(0x000);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end.next != null) {
            // 找到k的范围内end的节点
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if(end==null){
                break;
            }
            ListNode temp = end.next;
            end.next = null;
            ListNode start = pre.next;
            pre.next = reverse(start);
            start.next = temp;

            pre = start;
            end = start;
        }

        return dummy.next;

    }
}
