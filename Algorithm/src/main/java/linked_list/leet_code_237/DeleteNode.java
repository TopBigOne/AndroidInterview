package linked_list.leet_code_237;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/21 11:09
 * @Desc : https://leetcode.cn/problems/delete-node-in-a-linked-list/
 *
 * 题解：https://leetcode.cn/problems/delete-node-in-a-linked-list/solution/tu-jie-shan-chu-lian-biao-zhong-de-jie-dian-python/
 */
public class DeleteNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;

    }

    public void deleteNode2(ListNode node) {
        // 转移值
        node.val = node.next.val;
        // 跳过要删除的节点
        node.next = node.next.next;

    }

    public void deleteNode3(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;


    }

}
