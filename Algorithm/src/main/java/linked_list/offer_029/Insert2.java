package linked_list.offer_029;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/6/18 13:29
 * @Url :
 * @Level :    medium
 * @Desc :  offer 29:https://leetcode.cn/problems/4ueAj6/
 * @Counter :
 * @Answer :
 * https://leetcode.cn/problems/4ueAj6/solution/cai-keng-liu-lei-leng-jing-fen-xi-by-che-n8u9/
 */
public class Insert2 {
    public Node insert(Node head, int insertVal) {
        Node insertNode = new Node(insertVal);
        // 头结点为空
        if (head == null) {
            //没有节点的
            head = insertNode;
            head.next = insertNode;
            return head;
        }

        Node cur = head;
        //找到可以插入的节点
        while (true) {
            int currNodeValue = cur.val;
            int nextNodeValue = cur.next.val;

            // 可插入
            if (nextNodeValue >= insertVal && currNodeValue <= insertVal) {
                break;
            }
            if (nextNodeValue < currNodeValue) {
                if (insertVal >= currNodeValue || insertVal <= nextNodeValue) {
                    break;
                }
            }
            if (cur.next == head) {
                break;
            }

            cur = cur.next;
        }

        Node next = cur.next;
        cur.next = insertNode;
        insertNode.next = next;

        return head;
    }


}
