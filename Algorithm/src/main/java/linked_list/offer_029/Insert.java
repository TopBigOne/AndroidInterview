package linked_list.offer_029;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/6/18 13:22
 * @Url :
 * @Level :    medium
 * @Desc : https://leetcode.cn/problems/4ueAj6/
 * @Counter :
 * @Answer :
 * https://leetcode.cn/problems/4ueAj6/solution/gan-jue-da-jia-xie-de-du-you-dian-fu-za-k1klz/
 */
public class Insert {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }

        Node cur = head;

        while (cur.next != head) {

            int currValue = cur.val;
            int nextVal = cur.next.val;

            if (nextVal < currValue) {
                if (nextVal >= insertVal) {
                    // 最小值
                    // [3,5,1] 0 ==> [3,5,0,1]
                    break;
                } else if (currValue <= insertVal) {
                    //最大值
                    //[3,5,1] 6 ==>[3,5,6,1]
                    break;
                }
            }

            // 中间顺序插入
            // [1,3,5] 2 ==> [1,2,3,5]
            if (currValue <= insertVal && nextVal >= insertVal) {
                break;
            }
            // 移动指针
            cur = cur.next;
        }
        //插
        // 入新节点
        cur.next = new Node(insertVal, cur.next);
        return head;
    }

}
