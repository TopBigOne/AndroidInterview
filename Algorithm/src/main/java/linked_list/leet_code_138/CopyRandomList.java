package linked_list.leet_code_138;


import java.util.HashMap;
import java.util.Map;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/10/21 23:06
 * @Url :  138. 复制带随机指针的链表 https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 * @Level :    medium
 * @Desc :
 * @Counter : 5
 * @Answer : https://leetcode-cn.com/problems/copy-list-with-random-pointer/solution/liang-chong-shi-xian-tu-jie-138-fu-zhi-dai-sui-ji-/
 */
public class CopyRandomList {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        // 创建一个哈希表，key 是原节点，value是新节点
        Map<Node, Node> map = new HashMap<>();
        Node p = head;
        // 将原节点和新节点放入哈希表中
        while (p != null) {
            Node newNode = new Node(p.val);
            map.put(p, newNode);
            p = p.next;
        }
        p = head;
        // 遍历原链表，设置新节点的next和random
        while (p != null) {
            Node newNode = map.get(p);
            // p 是原节点，map.get(p) 是对应的新节点，p.next 是原节点的下一个
            // map.get(p.next) 是原节点下一个对应的新节点
            if (p.next != null) {
                newNode.next = map.get(p.next);
            }
            // p.random 是原节点 随机指向
            // map.get(p.random) 是原节点随机指向， 对应的新节点
            if (p.random != null) {
                newNode.random = map.get(p.random);
            }
            p = p.next;
        }
        return map.get(head);
    }

}
