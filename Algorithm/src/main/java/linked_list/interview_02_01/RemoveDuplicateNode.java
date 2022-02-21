package linked_list.interview_02_01;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  2021/5/21 19:46
 * @Desc : 字节面试题： 移除重复节点 ：https://leetcode-cn.com/problems/remove-duplicate-node-lcci/
 * <p>
 * <p>
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 * <p>
 * 示例1:
 * <p>
 * 输入：[1, 2, 3, 3, 2, 1]
 * 输出：[1, 2, 3]
 * 示例2:
 * <p>
 * 输入：[1, 1, 1, 1, 2]
 * 输出：[1, 2]
 */
public class RemoveDuplicateNode {
    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur;
            while (temp.next != null) {
                if (temp.next.val == cur.val) {
                    temp.next = temp.next.next;
                } else {
                    temp = temp.next;
                }
            }
            cur = cur.next;
        }
        return head;
    }

    public ListNode removeDuplicateNodes2(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr;
            while (temp.next != null) {
                if (curr.val == temp.next.val) {
                    temp.next = temp.next.next;
                } else {
                    temp = temp.next;
                }
            }

            curr = curr.next;
        }

        return head;

    }

    public ListNode removeDuplicateNodes3(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr;
            while (temp.next != null) {
                if (temp.next.val == curr.val) {
                    temp.next = temp.next.next;
                } else {
                    temp = temp.next;
                }
            }
            curr = curr.next;
        }

        return head;

    }

}
