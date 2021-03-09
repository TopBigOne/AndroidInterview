package linked_list.leetcode_206;


import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  1/25/21 5:19 PM
 * @Desc : 反转链表（https://leetcode-cn.com/problems/reverse-linked-list/）
 */
public class ReverseLinkList {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = null;
        ListNode pre = head;
        while (pre != null) {
            ListNode t = pre.next;
            pre.next = cur;
            cur = pre;
            pre = t;
        }
        return cur;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode cur = null;
        ListNode pre = head;
        while (pre != null) {
            ListNode temp = pre.next;
            pre.next = cur;
            cur = pre;
            pre = temp;
        }
        return cur;
    }

    public ListNode reverseList3(ListNode head) {
        ListNode cur = null;
        ListNode pre = head;
        while (pre != null) {
            ListNode temp = pre.next;
            pre.next = cur;
            cur = pre;
            pre = temp;
        }
        return cur;
    }

    public ListNode reverList4(ListNode head) {
        ListNode cur = null;
        ListNode pre = head;
        while (pre != null) {
            ListNode temp = pre.next;
            pre.next = cur;
            cur = pre;
            pre = temp;
        }
        return cur;
    }

    public ListNode reverseList5(ListNode head) {
        ListNode cur = null;
        ListNode pre = head;
        while (pre != null) {
            ListNode temp = pre.next;
            pre.next = cur;
            cur = pre;
            pre = temp;
        }
        return cur;
    }

    public ListNode reverseList6(ListNode head) {
        ListNode cur = null;
        ListNode pre = head;
        while (pre != null) {
            ListNode temp = pre.next;
            pre.next = cur;
            cur = pre;
            pre = temp;

        }
        return cur;
    }


    public ListNode reverseListNode7(ListNode head) {
        ListNode curr = null;
        ListNode pre = head;
        while (pre != null) {
            ListNode temp = pre.next;
            pre.next = curr;
            curr = pre;
            pre = temp;
        }

        return curr;
    }


    public ListNode reverseListNode8(ListNode head) {
        ListNode curr = null;
        ListNode pre = head;
        while (pre != null) {
            ListNode temp = pre.next;
            pre.next = curr;
            curr = pre;
            pre = temp;
        }

        return curr;
    }


    public ListNode reverseListNode9(ListNode head) {
        ListNode curr = null;
        ListNode pre = head;
        while (pre != null) {
            ListNode temp = pre.next;
            pre.next = curr;
            curr = pre;
            pre = temp;

        }
        return curr;

    }

    public ListNode reverseListNode10(ListNode head) {
        ListNode curr = null;
        ListNode pre = head;
        while (pre != null) {
            ListNode temp = pre.next;
            pre.next = curr;
            curr = pre;
            pre = temp;
        }
        return curr;
    }

    public ListNode reverseListNode11(ListNode head) {
        ListNode curr = null;
        ListNode pre = head;
        while (pre != null) {
            ListNode temp = pre.next;
            pre.next = curr;
            curr = pre;
            pre = temp;
        }

        return curr;
    }

    public ListNode reverseListNode12(ListNode head) {
        ListNode curr = null;
        ListNode pre = head;
        while (pre != null) {
            ListNode temp = pre.next;
            pre.next = curr;
            curr = pre;
            pre = temp;
        }
        return curr;
    }

    public ListNode reverseListNode13(ListNode head) {
        ListNode curr = null;
        ListNode pre = head;
        while (pre != null) {
            ListNode temp = pre.next;
            pre.next = curr;
            curr = pre;
            pre = temp;
        }
        return curr;

    }

    public ListNode reverseListNode14(ListNode head) {
        ListNode curr = null;
        ListNode pre = head;
        while (pre != null) {
            ListNode temp = pre.next;
            pre.next = curr;
            curr = pre;
            pre = temp;
        }

        return curr;
    }


    public ListNode reverseListNode15(ListNode head) {
        ListNode curr = null;
        ListNode pre = head;
        while (pre != null) {
            ListNode temp = pre.next;
            pre.next = curr;
            curr = pre;
            pre = temp;
        }
        return curr;

    }


    public ListNode reverseListNode16(ListNode head) {
        ListNode curr = null;
        ListNode pre = head;
        while (pre != null) {
            ListNode temp = pre.next;
            pre.next = curr;
            curr = pre;
            pre = temp;
        }
        return curr;
    }


    public ListNode reverseListNode17(ListNode head) {
        ListNode curr = null;
        ListNode pre = head;
        while (pre != null) {
            ListNode temp = pre.next;
            pre.next = curr;
            curr = pre;
            pre = temp;
        }

        return curr;
    }

    public ListNode reverseListNode18(ListNode head) {
        // 当前节点
        ListNode curr = null;

        // 当前节点的前一个节点
        ListNode pre = head;
        while (pre != null) {
            // 保存当前节点的后续节点，防止链表断开
            ListNode temp = pre.next;
            pre.next = curr;
            curr = pre;
            pre = temp;
        }

        return curr;
    }

    public ListNode reverseListNode19(ListNode head) {
        // 当前节点
        ListNode pre = null;

        // 当前节点的前一个节点
        ListNode curr = head;
        while (curr != null) {
            // 保存当前节点的后续节点，防止链表断开
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }

        return pre;
    }


}
