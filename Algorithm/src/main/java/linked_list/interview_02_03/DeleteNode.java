package linked_list.interview_02_03;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  5/21/21 10:55 PM
 * @Desc : leetcode 删除中间节点  https://leetcode-cn.com/problems/delete-middle-node-lcci/submissions/
 *
 * 题解：https://leetcode-cn.com/problems/delete-middle-node-lcci/solution/tu-jie-mian-shi-ti-0203-shan-chu-zhong-jian-jie-di/
 */
public class DeleteNode {

    /**
     * @param node       原链表
     * @param deleteNode 要删除的节点
     * @return
     */
    public ListNode deleteNode(ListNode node, ListNode deleteNode) {
        ListNode dummy = new ListNode(-1);
        dummy.next = node;
        ListNode pre = dummy;
        while (pre.next != null) {
            if (pre.next.val == deleteNode.val) {
                pre.next = pre.next.next;
                break;
            }
            pre = pre.next;
        }
        return dummy.next;
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;

    }

}
