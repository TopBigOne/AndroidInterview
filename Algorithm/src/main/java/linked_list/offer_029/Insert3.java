package linked_list.offer_029;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/6/18 16:09
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class Insert3 {
    public Node insert(Node head, int insertVal) {
        Node insertNode = new Node(insertVal);
        if (head == null) {
            head = insertNode;
            head.next = insertNode;
            return head;
        }
        Node curr = head;
        while (true) {
            int currValue = curr.val;
            int nextValue = curr.next.val;
            // 中间插入，很好理解
            if (currValue <= insertVal && nextValue >= insertVal) {
                break;
            }

            // 当前值大于下一个值
            if (currValue > nextValue) {
                // 最小值
                // [3,5,1] 0 ==> [3,5,0,1]
                if (nextValue >= insertVal) {
                    break;
                }
                //最大值
                //[3,5,1] 6 ==>[3,5,6,1]
                if (currValue <= insertVal) {
                    break;
                }
            }
            curr = curr.next;

        }
        Node temp = curr.next;
        curr.next = insertNode;
        insertNode.next = temp;

        return head;
    }
}
