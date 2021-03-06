package linked_list;

/**
 * @author : dev
 * @version :
 * @Date :  1/25/21 5:21 PM
 * @Desc : 链表节点
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "{" +
                "val = " + val +
                '}';
    }
}
