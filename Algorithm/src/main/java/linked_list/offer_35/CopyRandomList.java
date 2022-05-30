package linked_list.offer_35;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/24 23:30
 * @Desc : 复杂链表的复制 ：https://leetcode.cn/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 * <p>
 * 题解：https://leetcode.cn/problems/fu-za-lian-biao-de-fu-zhi-lcof/solution/jian-zhi-offer-35-fu-za-lian-biao-de-fu-zhi-ha-xi-/
 */
public class CopyRandomList {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        // 1:复制各节点，并构建拼接链表
        while (cur != null) {
            Node tmp = new Node(cur.val);
            tmp.next = cur.next;

            cur.next = tmp;
            cur = tmp.next;
        }
        // 2: 构建各新节点的random的指向
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        // 3： 拆分两个链表
        cur = head.next;
        Node pre = head;
        Node res = head.next;
        while (cur.next != null) {
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        // 单独处理原链表尾结点
        pre.next = null;
        return res;
    }
}
