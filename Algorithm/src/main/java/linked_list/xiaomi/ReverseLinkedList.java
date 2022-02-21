package linked_list.xiaomi;

import linked_list.BaseLinkedList;
import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/2/16 15:55
 * @Desc :
 */
public class ReverseLinkedList extends BaseLinkedList {

    public static void main(String[] args) {
        ListNode listNode = generateListNode(1, 2, 3, 4, 5, 6, 7);

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode result = reverseLinkedList.reverseListNode2(listNode);

        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
    }

    /**
     * 递归
     *
     * @param head
     * @return
     */
    public ListNode reverseListNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 找到最后的节点
        ListNode last = reverseListNode(head.next);
        head.next.next = head;
        head.next = null;// help GC;
        return last;
    }
    
    /**
     * pre <- curr  temp
     * 0-   1-   2-3-4-5-6
     *
     * @param head
     * @return
     */
    public ListNode reverseListNode2(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }

}
