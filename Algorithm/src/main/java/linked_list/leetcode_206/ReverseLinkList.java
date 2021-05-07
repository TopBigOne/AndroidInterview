package linked_list.leetcode_206;

import linked_list.ListNode;

/**
 * @author : dev
 * @version :
 * @Date :  1/25/21 5:19 PM
 * @Desc : 206 反转链表（https://leetcode-cn.com/problems/reverse-linked-list/）
 * 视频：https://www.bilibili.com/video/BV1Af4y1m7Ct?from=search&seid=13384506544605607285
 * https://www.bilibili.com/video/BV1U7411A75v/?spm_id_from=autoNext
 * 留意一下 反转链表2，字节高频面试题：
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

    public ListNode reverseListNode20(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }

    public ListNode reverseListNode21(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }

    public ListNode reverseListNode22(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public ListNode reverseListNode23(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        return pre;
    }

    public ListNode reverseListNode24(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode temp = curr.next;
            // 当前节点的下一个节点，指向上一个节点；
            curr.next = pre;
            // 上一个节点，后移动一位，指向当前节点；
            pre = curr;
            // 当前节点，后移一位，指向下一个节点： ListNode temp = curr.next;
            curr = temp;
        }

        return pre;
    }
    public ListNode reverseListNode25(ListNode head){
        if (head==null||head.next==null) {
            return head;
        }
        ListNode pre = null;
        ListNode curr = head;
        while (curr!=null){
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }

        return pre;

    }


}
