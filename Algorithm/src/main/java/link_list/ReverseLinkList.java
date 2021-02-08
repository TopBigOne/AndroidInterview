package link_list;


/**
 * @author : dev
 * @version :
 * @Date :  1/25/21 5:19 PM
 * @Desc : 反转链表
 */
public class ReverseLinkList {
    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node next = null;
        Node pre = null;
        while (head != null) {
            next = head.next;
            // 当节点的后驱指向前驱
            head.next = pre;
            pre = head;
        }

        return pre;
    }
}
